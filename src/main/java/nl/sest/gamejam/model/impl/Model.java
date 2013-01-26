package nl.sest.gamejam.model.impl;

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
    private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();
    private final ArrayList<PointOfInterest> pointsOfInterest = new ArrayList<PointOfInterest>();
    private Heartbeat heartbeat;

    public Model() {
    }
    
    /**
     * Apply damage to the valuable
     * @param v
     * @param damage
     */
    public void applyDamage(Valuable v, float damage) {
    	// TODO Implement
    }
    
    /**
     * Get all the Bobs in the world
     * @return
     */
    public Set<Bob> getBobs() {
    	return bobs;
    }

    /**
     * Gives the POIs in the World.
     * @return
     */
    public ArrayList<PointOfInterest> getPointsOfInterest() {
    	return pointsOfInterest;
    }
    
    /**
     * Gives the collisions that occurred over time
     * @return
     */
    public Iterable<Collision> getCollisions() {
        return Collections.unmodifiableCollection(collisions);
    }

    /**
     * Adds a collision to the list of collissions that occurred.
     * @param collision
     */
    public void addCollision(Collision collision) {
        collisions.add(collision);
    }

    /**
     * Get the current Heartbeat
     * @return
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


}
