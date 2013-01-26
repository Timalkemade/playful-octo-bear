package nl.sest.gamejam.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * The model keeps track of where everything in is in the world. Basically is should be called Big Brother.
 *
 * @author Tim
 * @since 1/25/13 10:01 PM
 */
public class Model {

    private final Stack<Collision> collisions = new Stack<Collision>();
    private final List<Bob> bobs = new ArrayList<Bob>();
    private final ArrayList<TrainDestination> trainDestinations = new ArrayList<TrainDestination>();
    private Heartbeat heartbeat;

    public Model() {
        heartbeat = new Heartbeat(0f);
    }

    public Iterable<Collision> getCollisions() {
        return Collections.unmodifiableCollection(collisions);
    }

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
    
    /**
     * Set a new Heartbeat
     * @param hb
     */
    public void setHeartbeat(Heartbeat hb) {
    	heartbeat = hb;
    }

    public void addBob(Bob bob) {
        bobs.add(bob);
    }
    
    public ArrayList<TrainDestination> getTrainDestinations() {
    	return trainDestinations;
    }


}