package nl.sest.gamejam.controller;

import java.util.ArrayList;

import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.impl.Bob;
import nl.sest.gamejam.model.impl.Collision;
import nl.sest.gamejam.model.impl.Heartbeat;
import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.model.impl.Train;
import nl.sest.gamejam.model.impl.TrainDestination;

/**
 * 
 * TODO POIs
 * @author Remi
 *
 */
public class GameController {

	protected Model model;
	protected long startTime;
	protected long currentTime;
	
	// Game state
	protected long lastHeartbeat = 0;
	protected int heartbeatTime = 10; // time in milliseconds between each heartbeat
	
	// Settings
	protected int heartbeatVolume = 10; // number of Bobs per heartbeat
	protected float damageChance = 0.1f; // the chance that a single Bob will damage a Valuable on collision
	protected float heartbeatDuration = 1000; // duration of a heartbeat in milliseconds
	
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
		// Get current heartbeat state
		float heartbeatState = model.getHeartbeat().getState();
		
		// If it is time for a new heartbeat and there is no heartbeat in progress
		if(heartbeatState == 0 && currentTime > lastHeartbeat - heartbeatTime) {
			heartbeatStart();
		}
	}
	
	/**
	 * Create a new Heartbeat
	 */
	protected void heartbeatStart() {
		// Get possible TrainDestinations
		ArrayList<TrainDestination> destinations = model.getTrainDestinations();
		
		// Pick a random destination
		int r = (int)Math.random()*destinations.size();
		TrainDestination destination = destinations.get(r);
		
		// Create heartbeat
		Heartbeat hb = new Heartbeat(0);
		hb.addTrain(new Train(destination, heartbeatVolume));
		model.setHeartbeat(hb);
	}
	
	/**
	 * Creates new Bobs at the destinations of the trains in the heartbeat.
	 */
	protected void heartbeatUnload() {
		// Get the trains on this heartbeat
		Iterable<Train> trains = model.getHeartbeat().getTrains();
		for(Train t : trains) {
			// Get the destination of this train
			TrainDestination destination = t.getDestination();
			float x = destination.getLocation().getX();
			float y = destination.getLocation().getY();
			
			// Create Bobs at the destination
			for(int i=0; i<t.getNumBobs(); i++) {
				Bob bob = new Bob(x, y);
				model.addBob(bob);
			}
		}
	}
	
	protected void heartbeatEnd() {
		
	}
	
	/**
	 * Progresses the heartbeat for this step
	 * @param dt The time passed during this step in milliseconds
	 */
	protected void updateHeartbeat() {
		// Get current Heartbeat
		Heartbeat hb = model.getHeartbeat();
		long heartbeatStart = hb.getTimestamp();
		
		// Compute state as percentage and set new state
		float progress = (currentTime-heartbeatStart)/heartbeatDuration;
		hb.setState(progress);
	}
	
	/**
	 * Read model and adjust game state accordingly.
	 * @param dt The time passed during this step in milliseconds.
	 */
	public void step(int dt) {
		currentTime = System.currentTimeMillis();
		handleCollisions();
		maybeHeartbeat();
		updateHeartbeat();
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
			
			// TODO Check if one of the objects is a Bob and the other a Valuable
			// If so, by chance apply damage to the Valuable
		}
	}
	
	/**
	 * Set the model to read and write during the game.
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
