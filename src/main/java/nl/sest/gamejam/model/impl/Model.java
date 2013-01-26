package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.event.listener.CreatePhysicalListener;
import nl.sest.gamejam.model.event.listener.DeletePhysicalListener;
import nl.sest.gamejam.model.player.PlayerAttractor;
import nl.sest.gamejam.model.player.PlayerRepulsor;

import java.util.*;

/**
 * The model keeps track of where everything in is in the world. Basically is should be called Big Brother.
 *
 * @author Tim
 * @since 1/25/13 10:01 PM
 */
public class Model {

	private final Stack<Collision> collisions = new Stack<Collision>();
	private final Set<Bob> bobs = new HashSet<Bob>();
	private final List<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
	private final Set<PlayerAttractor> playerAttractors = new HashSet<PlayerAttractor>();
	private final Set<PlayerRepulsor> playerRepulsors = new HashSet<PlayerRepulsor>();

	private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();

	private List<CreatePhysicalListener> createListeners = new ArrayList<CreatePhysicalListener>();
	private List<DeletePhysicalListener> deleteListeners = new ArrayList<DeletePhysicalListener>();

	private Heartbeat heartbeat;

	public Model() {
	}

	/**
	 * Apply damage to the valuable
	 *
	 * @param v
	 * @param damage
	 */
	public void applyDamage(Valuable v, float damage) {
		// TODO Implement
	}

	/**
	 * Get all the Bobs in the world
	 *
	 * @return
	 */
	public Set<Bob> getBobs() {
		return bobs;
	}

	/**
	 * Gives the POIs in the World.
	 *
	 * @return
	 */
	public List<PointOfInterest> getPointsOfInterest() {
		return Collections.unmodifiableList(pointsOfInterest);
	}

	/**
	 * Gives the collisions that occurred over time
	 *
	 * @return
	 */
	public Iterable<Collision> getCollisions() {
		return Collections.unmodifiableCollection(collisions);
	}

	/**
	 * Adds a collision to the list of collissions that occurred.
	 *
	 * @param collision
	 */
	public void addCollision(Collision collision) {
		collisions.add(collision);
	}

	/**
	 * Get the current Heartbeat.
	 *
	 * @return the heartbeat of the game
	 */
	public Heartbeat getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(Heartbeat aHeartbeat) {
		heartbeat = aHeartbeat;
	}

	public void addBob(Bob bob) {
		bobs.add(bob);
	}

	public ArrayList<TrainDestination> getTrainDestinations() {
		return trainDestinations;
	}

	public void removeBob(Bob bob) {
		bobs.remove(bob);
	}

	public void addPointOfInterest(PointOfInterest pointOfInterest) {
		pointsOfInterest.add(pointOfInterest);
	}

	public void removePointOfInterest(PointOfInterest pointOfInterest) {
		pointsOfInterest.remove(pointOfInterest);
	}

	public void addPlayerAttractor(PlayerAttractor playerAttractor) {
		playerAttractors.add(playerAttractor);
	}

	public void removePlayerAttractor(PlayerAttractor playerAttractor) {
		playerAttractors.remove(playerAttractor);
	}

	public void addPlayerRepulsor(PlayerRepulsor playerRepulsor) {
		playerRepulsors.add(playerRepulsor);
	}

	public void removePlayerRepulsor(PlayerRepulsor playerRepulsor) {
		playerRepulsors.remove(playerRepulsor);
	}

	/**
	 * Register a listener which listens to creation of physical objects.
	 *
	 * @param listener the listener
	 */
	public void registerCreatePhysicalEventListener(CreatePhysicalListener listener) {
		createListeners.add(listener);
	}

	/**
	 * Remove a listener which listens to creation of physical objects.
	 *
	 * @param listener the listener
	 */
	public void unregisterCreatePhysicalEventListener(CreatePhysicalListener listener) {
		createListeners.remove(listener);
	}

	/**
	 * Add a listener which listens to deletion of physical objects.
	 *
	 * @param listener the listener
	 */
	public void registerDeletePhysicalEventListener(DeletePhysicalListener listener) {
		deleteListeners.add(listener);
	}

	/**
	 * Remove a listener which listens to deletion of physical objects.
	 *
	 * @param listener the listener
	 */
	public void unregisterDeletePhysicalEventListener(DeletePhysicalListener listener) {
		deleteListeners.remove(listener);
	}
}
