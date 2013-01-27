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
	private final Set<Blockade> blockades = new HashSet<Blockade>();

	private final List<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
	private final Set<Obstacle> obstacles = new HashSet<Obstacle>();
	private final Set<PointOfInterest> destinations = new HashSet<PointOfInterest>();
	private final Set<Pit> pits = new HashSet<Pit> ();

	private final Set<Valuable> valuables = new HashSet<Valuable>();
	private final Set<Edge> edges = new HashSet<Edge>();

	private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();
	private List<CreatePhysicalListener> createListeners = new ArrayList<CreatePhysicalListener>();
	private List<DeletePhysicalListener> deleteListeners = new ArrayList<DeletePhysicalListener>();

	private List<EventListener> eventListeners = new ArrayList<EventListener>();

	private Heartbeat heartbeat;

	private float height = 0;
	private float width = 0;

	private float currency = 0;
	private int virusKills = 0;
	private int cellKills = 0;
	private int virusPass = 0;
	private long startTime = 0;

	public Model() {
	}

	/**
	 * Set the game starting time
	 *
	 * @param startTime
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * Get the timestamp when the game started
	 *
	 * @return
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * Set the amount of currency the player has
	 *
	 * @param currency
	 */
	public void setCurrency(float currency) {
		this.currency = currency;
	}

	/**
	 * Add or subtract currency from the player's stash
	 *
	 * @param delta
	 */
	public void updateCurrency(float delta) {
		this.currency += delta;
	}

	/**
	 * Get the current amount of currency in the player's stash
	 *
	 * @return
	 */
	public float getCurrency() {
		return currency;
	}

	/**
	 * Apply damage to the valuable.
	 *
	 * @param v      The valuable that was hit
	 * @param damage The damage done to the valuable
	 */
	public void applyDamage(Valuable v, float damage) {
		updateCurrency(-damage);
		v.updateValue(-damage);
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
	
	public void addEdge(Edge edge) {
		edges.add(edge);
		fireCreateListeners(edge);
	}

	public void addBlockade(Blockade blockade) {
		blockades.add(blockade);
		fireCreateListeners(blockade);
	}

	public void removeBlockade(Blockade blockade) {
		blockades.remove(blockade);
		fireDeleteListeners(blockade);
	}

	public Collection<Blockade> getBlockades() {
		return Collections.unmodifiableCollection(blockades);
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

	/**
	 * Add a POI with a Pit
	 * @param pointOfInterest
	 */
	public void addPointOfInterest(PointOfInterest pointOfInterest) {
		pointsOfInterest.add(pointOfInterest);
		Pit pit = new Pit(pointOfInterest.getX(), pointOfInterest.getY());
		pits.add(pit);
		fireCreateListeners(pit);
	}
	
	public void cellKill() {
		cellKills++;
	}
	
	public void virusKill() {
		virusKills++;
	}
	
	public void virusPass() {
		virusPass++;
	}
	
	public int getVirusKills() {
		return virusKills;
	}
	
	public int getCellKills() {
		return cellKills;
	}
	
	public int getVirusPass() {
		return virusPass;
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
	 * Add a valuable to the Model
	 *
	 * @param v
	 */
	public void addValuable(Valuable v) {
		valuables.add(v);
		fireCreateListeners(v);
	}

	/**
	 * Get all Obstacles from the Model
	 *
	 * @return
	 */
	public Set<Obstacle> getObstacles() {
		return obstacles;
	}
	
	/**
	 * Add POI that will be attracting throughout the level
	 * @param pointOfInterest
	 */
	public void addDestination(PointOfInterest pointOfInterest) {
		destinations.add(pointOfInterest);
	}
	
	public Set<PointOfInterest> getDestinations() {
		return destinations;
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
		renderables.addAll(valuables);
		renderables.addAll(blockades);

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
