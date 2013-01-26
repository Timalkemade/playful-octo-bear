package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.Renderable;
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
	private final Set<PlayerAttractor> playerAttractors = new HashSet<PlayerAttractor>();
	private final Set<PlayerRepulsor> playerRepulsors = new HashSet<PlayerRepulsor>();

	private final List<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();

	private final Set<Obstacle> obstacles = new HashSet<Obstacle>();

	private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();

	private List<CreatePhysicalListener> createListeners = new ArrayList<CreatePhysicalListener>();
	private List<DeletePhysicalListener> deleteListeners = new ArrayList<DeletePhysicalListener>();
	private List<EventListener> eventListeners = new ArrayList<EventListener>();

	private Heartbeat heartbeat;

	private float height = 0;
	private float width = 0;

	public Model() {
	}

	/**
	 * Apply damage to the valuable.
	 *
	 * @param v      The valuable that was hit
	 * @param damage The damage done to the valuable
	 */
	public void applyDamage(Valuable v, float damage) {
		// TODO Implement
	}

	/**
	 * Set the dimension of the World
	 *
	 * @param width
	 * @param height
	 */
	public void setWorldDimension(float width, float height) {
		this.height = height;
		this.width = width;
	}

	public float getWorldHeight() {
		return height;
	}

	public float getWorldWidth() {
		return width;
	}

	/**
	 * Fire an event for all EventListeners
	 *
	 * @param e
	 */
	public void fireEvent(Event e) {
		for (EventListener el : eventListeners)
			el.onEvent(e);
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
		fireCreateListeners(bob);
	}

	public void removeBob(Bob bob) {
		bobs.remove(bob);
		fireDeleteListeners(bob);
	}

	/**
	 * Get all the Bobs in the world
	 *
	 * @return
	 */
	public Set<Bob> getBobs() {
		return bobs;
	}

	public ArrayList<TrainDestination> getTrainDestinations() {
		return trainDestinations;
	}


	/**
	 * Adds a TrainDestination to the Model
	 *
	 * @param td
	 */
	public void addTrainDestination(TrainDestination td) {
		trainDestinations.add(td);
	}

	public void addPointOfInterest(PointOfInterest pointOfInterest) {
		pointsOfInterest.add(pointOfInterest);
	}

	/**
	 * Add an Obstacle to the Model
	 *
	 * @param o
	 */
	public void addObstacle(Obstacle o) {
		obstacles.add(o);
		fireCreateListeners(o);
	}

	/**
	 * Get all Obstacles from the Model
	 *
	 * @return
	 */
	public Set<Obstacle> getObstacles() {
		return obstacles;
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

	public Collection<PlayerAttractor> getPlayerAttractors() {
		return Collections.unmodifiableCollection(playerAttractors);
	}


	public void addPlayerRepulsor(PlayerRepulsor playerRepulsor) {
		playerRepulsors.add(playerRepulsor);
	}

	public void removePlayerRepulsor(PlayerRepulsor playerRepulsor) {
		playerRepulsors.remove(playerRepulsor);
	}

	public Collection<PlayerRepulsor> getPlayerRepulsors() {
		return Collections.unmodifiableCollection(playerRepulsors);
	}

	/**
	 * Register a listener which listens to events.
	 *
	 * @param listener the listener
	 */
	public void registerEventListener(EventListener listener) {
		eventListeners.add(listener);
	}

	/**
	 * Remove a listener which listens to events.
	 *
	 * @param listener the listener
	 */
	public void unregisterEventListener(EventListener listener) {
		eventListeners.remove(listener);
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

	public Collection<Renderable> getRenderables() {
		List<Renderable> renderables = new ArrayList<Renderable>();
		renderables.addAll(bobs);
		renderables.addAll(obstacles);
		renderables.addAll(pointsOfInterest);
		renderables.addAll(playerAttractors);
		renderables.addAll(playerRepulsors);

		return renderables;
	}

	/**
	 * Fires all {@link CreatePhysicalListener}s that are registered.
	 *
	 * @param physical The {@link Physical} that was created
	 */
	private void fireCreateListeners(Physical physical) {
		for (CreatePhysicalListener createPhysicalListener : createListeners) {
			createPhysicalListener.fireCreatePhysical(physical);
		}
	}

	/**
	 * Fires all {@link DeletePhysicalListener}s that are registered.
	 *
	 * @param physical The {@link Physical} that was deleted
	 */
	private void fireDeleteListeners(Physical physical) {
		for (DeletePhysicalListener deletePhysicalListener : deleteListeners) {
			deletePhysicalListener.fireDeletePhysical(physical);
		}
	}
}
