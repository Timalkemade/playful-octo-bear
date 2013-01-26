//package nl.sest.gamejam.controller;
//
//import nl.sest.gamejam.model.impl.Model;
//
//public class GameController {
//
//	protected Model model;
//	protected long startTime;
//	protected long currentTime;
//	
//	// Game state
//	protected long lastHeartbeat = 0;
//	protected int heartbeatTime = 10; // time in milliseconds between each heartbeat
//	
//	// Settings
//	protected int heartbeatVolume = 10; // number of Bobs per heartbeat
//	protected float damageChance = 0.1f; // the chance that a single Bob will damage a Valuable on collision
//	protected float heartbeatDuration = 10; // duration of a heartbeat in milliseconds
//	
//	public GameController(Model model) {
//		this.model = model;
//	}
//	
//	public void start() {
//		startTime = System.currentTimeMillis();
//	}
//	
//	/**
//	 * Checks if it is time for a Heartbeat and if so, applies one.
//	 */
//	public void maybeHeartBeat() {
//		// Get current heartbeat state
//		float heartbeatState = model.getHeartbeatState();
//		
//		// If it is time for a new heartbeat and there is no heartbeat in progress
//		if(heartbeatState == 0 && currentTime > lastHeartbeat - heartbeatTime) {
//			heartBeatStart();
//		}
//	}
//	
//	protected void heartBeatStart() {
//		// Get possible heartbeat positions
//		Heartbeat hb = new Heartbeat();
//		model.announce(hb);
//	}
//	
//	/**
//	 * Creates new Bobs
//	 */
//	protected void heartBeatUnload() {
//		TrainDestination destination = model.getHeartBeat
//	}
//	
//	protected void heartBeatEnd() {
//		
//	}
//	
//	/**
//	 * Progresses the heartbeat for this step
//	 */
//	protected void updateHeartbeat() {
//		
//	}
//	
//	/**
//	 * Read model and adjust game state accordingly.
//	 * @param dt The time passed during this step.
//	 */
//	public void step(int dt) {
//		currentTime = System.currentTimeMillis();
//		handleCollisions();
//		maybeHeartBeat();
//		updateHeartBeat();
//	}
//	
//	/**
//	 * Handles all the collisions during this step.
//	 */
//	public void handleCollisions() {
//		// Get collisions
//		Iterable<Collision> collisions = model.getCollisions();
//		
//		// Go through collisions
//		for (Collision c : collisions) {
//			Physical objectA = collisions.getPhysicalA();
//			Physical objectB = collisions.getPhysicalB();
//			
//			// TODO Check if one of the objects is a Bob and the other a Valuable
//			// If so, by chance apply damage to the Valuable
//		}
//	}
//	
//	/**
//	 * Set the model to read and write during the game.
//	 * @param model
//	 */
//	public void setModel(Model model) {
//		this.model = model;
//	}
//	
//	public void loadSettings(...) {
//		
//	}
//
//}
