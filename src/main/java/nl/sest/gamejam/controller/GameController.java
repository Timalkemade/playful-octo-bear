package nl.sest.gamejam.controller;

import nl.sest.gamejam.events.CellPassEvent;
import nl.sest.gamejam.events.HeartbeatEvent;
import nl.sest.gamejam.events.VirusPassEvent;
import nl.sest.gamejam.model.impl.*;
import nl.sest.gamejam.physics.PhysicsCollisionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Remi
 */
public class GameController implements PhysicsCollisionListener {

	protected Model model;
	protected long currentTime;

	// Game state
	protected long lastHeartbeat = 0; // timestamp when the last Heartbeat ended
	protected int heartbeatTime = 1000; // time in milliseconds between each heartbeat
	protected long lastPOIappeared = 0; // timestamp when the last POI appeared
	protected long nextPOITime = 0; // timestamp when next POI should appear
	protected HashMap<Bob, Float> bobDamageCooldown = new HashMap<Bob, Float>();
	protected float virusCellRatio = 0.1f;
	
	// Settings
	protected int heartbeatVolume = 9; // number of Bobs per heartbeat
	protected float damageChance = 1; // the chance that a single Bob will damage a Valuable on collision
	protected float damagePerEvent = 20; // the damage applied for every violent event
	protected float damageCoolDown = 1000; // time in ms before a Bob can damage something again
	protected float heartbeatDuration = 500; // duration of a heartbeat in milliseconds
	protected float POIminInterval = 5000; // minimum time in ms before a new POI appears
	protected float POImaxInterval = 20000; // maximum time in ms before a new POI appears
	protected float POImaxInterest = 10; // maximum interest factor of POIs
	protected float POImaxBoostTime = 10000; // maximum life time of POIs 
	protected float POIboostRate = 0.001f; // interest boost per ms during boost
	protected float POIdecayRate = 0.0005f; // interest decrease per ms always
	protected float maxCurrency = 100000; // starting currency
	protected float damagePerVirus = 200;
	protected float repairPerCell = 50;
	
	private final static Logger logger = LoggerFactory.getLogger(GameController.class);
	
	public GameController(Model model) {
		this.model = model;
	}

	public void start() {
		model.setStartTime(System.currentTimeMillis());
		model.setCurrency(maxCurrency);
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
			for(TrainDestination td : destinations)
				hb.addTrain(new Train(td, heartbeatVolume));
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
				// Scatter Bobs
				float rX = (float)(Math.random()*9);
				float rY = (float)(Math.random()*9);
				
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
		if(hb.getState() > 1) {
			heartbeatEnd();
		}
	}

	/**
	 * Read model and adjust game state accordingly.
	 *
	 * @param dt The time passed during this step in milliseconds.
	 */
	public void step(int dt) {
		currentTime = System.currentTimeMillis();
		maybeHeartbeat();
		updateHeartbeat();
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

	@Override
	public void valuableCollisionEvent(Bob bob, Valuable valuable) {
		maybeApplyDamage(bob, valuable);
	}

	@Override
	public void obstacleCollisionEvent(Bob bob, Obstacle obstacle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pitCollisionEvent(Bob bob, Pit pit) {
		if(bob.isVirus()) {
			model.virusKill(bob);
		}
		else {
			model.cellKill(bob);
		}
	}

	@Override
	/**
	 * Bobs passing
	 */
	public void edgeCollisionEvent(Bob bob, Edge edge) {
		model.removeBob(bob);
		if(bob.isVirus()) {
			model.updateCurrency(damagePerVirus);
			model.fireEvent(new VirusPassEvent(currentTime, bob));
		}
		else {
			if(model.getCurrency() < maxCurrency)
				model.updateCurrency(repairPerCell);
			model.fireEvent(new CellPassEvent(currentTime, bob));
		}
	}

}
