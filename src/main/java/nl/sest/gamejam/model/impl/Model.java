package nl.sest.gamejam.model.impl;

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
    private final Set<PointOfInterest> pointsOfInterest = new HashSet<PointOfInterest>();
    private final Set<PlayerAttractor> playerAttractors = new HashSet<PlayerAttractor>();
    private final Set<PlayerRepulsor> playerRepulsors = new HashSet<PlayerRepulsor>();

    private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();
    private Heartbeat heartbeat;

    public Model() {
    }

    public Iterable<Collision> getCollisions() {
        return Collections.unmodifiableCollection(collisions);
    }

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
}
