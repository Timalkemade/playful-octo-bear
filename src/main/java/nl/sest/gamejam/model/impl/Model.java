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
    private Heartbeat heartbeat = null;

    public Model() {
    }

    public Iterable<Collision> getCollisions() {
        return Collections.unmodifiableCollection(collisions);
    }

    public void addCollision(Collision collision) {
        collisions.add(collision);
    }

    public Heartbeat getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Heartbeat aHeartbeat) {
        heartbeat = aHeartbeat;
    }

    public void addBob(Bob bob) {
        bobs.add(bob);
    }

    public void removeBob(Bob bob) {
        bobs.remove(bob);
    }


}