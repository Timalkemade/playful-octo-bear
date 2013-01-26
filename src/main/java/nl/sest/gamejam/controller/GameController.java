package nl.sest.gamejam.controller;

import nl.sest.gamejam.events.HeartbeatEvent;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.impl.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Remi
 */
public class GameController {

	protected Model model;
	protected long startTime;
	protected long currentTime;

	// Game state
	protected long lastHeartbeat = 0; // timestamp when the last Heartbeat ended
	protected int heartbeatTime = 1000; // time in milliseconds between each heartbeat
	protected long lastPOIappeared = 0; // timestamp when the last POI appeared
	protected long nextPOITime = 0; // timestamp when next POI should appear

	// Settings
	protected int heartbeatVolume = 3; // number of Bobs per heartbeat
	protected float damageChance = 1; // the chance that a single Bob will damage a Valuable on collision
	protected float damagePerEvent = 20; // the damage applied for every violent event
	protected float heartbeatDuration = 500; // duration of a heartbeat in milliseconds
	protected float POIminInterval = 5000; // minimum time in ms before a new POI appears
	protected float POImaxInterval = 20000; // maximum time in ms before a new POI appears
	protected float POImaxInterest = 10; // maximum interest factor of POIs
	protected float POImaxLifeTime = 100000; // maximum life time of POIs

	private final static Logger logger = LoggerFactory.getLogger(GameController.class);
	
	public GameController(Model model) {
		this.model = model;
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	/**
	 * Checks if it is time for a Heartbeat and if so, applies one.
	 */
	public void maybeHeartbeat() {
		Heartbeat hb = model.getHeartbeat();
		
		// If no heartbeat has occurred yet, do one now
		if(hb == null)
			heartbeatStart();
		
		// Else check if it is time for new heartbeat
		else {
			// Get current heartbeat state
			float heartbeatState = hb.getState();
	
			// If it is time for a new heartbeat and there is no heartbeat in progress
			if (heartbeatState < 0 && currentTime - lastHeartbeat > heartbeatTime) {
				heartbeatStart();
			}
		}
	}

	/**
	 * Create a new Heartbeat
	 */
	protected void heartbeatStart() {
		// Get possible TrainDestinations
		ArrayList<TrainDestination> destinations = model.getTrainDestinations();

		// Pick a random destination
		int numTrains = destinations.size();
		Heartbeat hb = new Heartbeat(0);
		if(numTrains > 0) {
			int r = (int) Math.random() * (destinations.size()-1);
			TrainDestination destination = destinations.get(r);
			hb.addTrain(new Train(destination, heartbeatVolume));
		}
		// Create heartbeat
		model.setHeartbeat(hb);
		model.fireEvent(new HeartbeatEvent(hb, currentTime));
	}

	/**
	 * Creates new Bobs at the destinations of the trains in the heartbeat.
	 */
	protected void heartbeatUnload() {
		// Get the trains on this heartbeat
		Iterable<Train> trains = model.getHeartbeat().getTrains();
		for (Train t : trains) {
			// Get the destination of this train
			TrainDestination destination = t.getDestination();
			float x = destination.getLocation().getX();
			float y = destination.getLocation().getY();

			// Create Bobs at the destination
			for (int i = 0; i < t.getNumBobs(); i++) {
				float rX = 3+(float)(Math.random()*3);
				float rY = 3+(float)(Math.random()*3);
				
				Bob bob = new Bob(x+rX, y+rY);
				model.addBob(bob);
			}
		}
	}

	/**
	 * States the end of the heartbeat
	 */
	protected void heartbeatEnd() {
		lastHeartbeat = System.currentTimeMillis();
		Heartbeat hb = model.getHeartbeat();
		hb.setUnloaded(true);
		hb.setState(-1);
	}

	/**
	 * Progresses the heartbeat for this step
	 */
	protected void updateHeartbeat() {
		// Get current Heartbeat
		Heartbeat hb = model.getHeartbeat();
		long heartbeatStart = hb.getTimestamp();

		// Compute state as percentage and set new state
		if(hb.getState() >= 0) {
			float progress = (currentTime - heartbeatStart) / heartbeatDuration;
			hb.setState(progress);
		}

		// If progress is past halfway and has Heartbeat has not been unloaded yet, unload
		if (hb.getState() > 0.5 && !hb.isUnloaded()) {
			heartbeatUnload();
			hb.setUnloaded(true);
		}
		
		// If heartbeat state passes 1, end heartbeat
		logger.debug("state {}", hb.getState());
		if(hb.getState() > 1) {
			logger.debug("heatbeatEnd");
			heartbeatEnd();
		}
	}

	/**
	 * Increase and decrease the interest factors of the POIs
	 */
	public void updatePOIs(int dt) {
		// Go through POIs
		List<PointOfInterest> pois = model.getPointsOfInterest();
		for (PointOfInterest poi : pois) {
            poi.updateRenderer(dt);
			// If POI lifetime exceeds max lifetime, set interest to 0
			if (currentTime - poi.getStartTime() > poi.getMaxLifetime())
				poi.setInterest(0);
				// Otherwise, if POI is active (has an interest factor higher than 0) calculate new interest
			else if (poi.getInterest() > 0) {
				// Gaussian function
				float mean = poi.getMaxLifetime() / 2;
				float sd = poi.getMaxLifetime() / 6;
				float max = poi.getMaxInterest();
				float x = currentTime - poi.getStartTime();
				float currentInterest = (float) Math.pow(max * Math.E, -1 * (Math.pow(x - mean, 2.0) / Math.pow(2 * sd, 2.0)));

				// Set new interest
				poi.setInterest(currentInterest);
			}
		}

		// If it is time, create new POI
		if (currentTime > nextPOITime) {
			// Select random POI
			int random = (int) Math.random() * pois.size();
			PointOfInterest poi = pois.get(random);

			// Activate POI
			poi.start(POImaxInterest, POImaxLifeTime);

			// Determine next POI appearance
			int POIInterval = (int) (Math.random() * (POImaxInterval - POIminInterval) + POIminInterval);
			nextPOITime = currentTime + POIInterval;
		}
	}

	/**
	 * Read model and adjust game state accordingly.
	 *
	 * @param dt The time passed during this step in milliseconds.
	 */
	public void step(int dt) {
		currentTime = System.currentTimeMillis();
		handleCollisions();
		maybeHeartbeat();
		updateHeartbeat();
		updatePOIs(dt);
	}

	/**
	 * Handles all the collisions during this step.
	 */
	public void handleCollisions() {
		// Get collisions
		Iterable<Collision> collisions = model.getCollisions();

		// Go through collisions
		for (Collision c : collisions) {
			Physical objectA = c.getCollider1();
			Physical objectB = c.getCollider2();

			// If one of the objects is Bob and the other Valuable, by chance apply damage to Valuable
			if ((objectA instanceof Bob && objectB instanceof Valuable)) {
				maybeApplyDamage((Bob) objectA, (Valuable) objectB);
			} else if (objectA instanceof Valuable && objectB instanceof Bob) {
				maybeApplyDamage((Bob) objectB, (Valuable) objectA);
			}
		}
	}

	/**
	 * Checks if, by chance the given Bob should apply damage to the given Valuable and if so, does so.
	 */
	protected void maybeApplyDamage(Bob bob, Valuable valuable) {
		// Determine if the damage should be applied
		float random = (float) Math.random();
		if (random < damageChance)
			model.applyDamage(valuable, damagePerEvent);
	}

	/**
	 * Set the model to read and write during the game.
	 *
	 * @param model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * TODO implement
	 */
	public void loadSettings() {

	}

}
