package nl.sest.gamejam.model.impl;

import java.util.ArrayList;

import nl.sest.gamejam.model.Event;

/**
 * A heartbeat is the basic flow of the game. Each heartbeat a new flow of bobs appears.
 *
 * @author Tim
 * @since 1/26/13 12:35 AM
 */
public class Heartbeat implements Event {

    private final long timestamp; // the start of the Heartbeat
    private float state; // indicates the progress of the Heartbeat (between 0 and 1)
    private ArrayList<Train> trains = new ArrayList<Train>();
    private boolean isUnloaded = false;

    /**
     * Constructor for heartbeat. Use the state initialize the state and the timestamp.
     * @param state the initial state
     */
    public Heartbeat(float state) {
        this.timestamp = System.currentTimeMillis();
        this.state = state;
    }
    
    /**
     * Add a Train to the heartbeat
     * @param t
     */
    public void addTrain(Train t) {
    	trains.add(t);
    }
    
    /**
     * Gets the trains on this heartbeat.
     * @return
     */
    public Iterable<Train> getTrains() {
    	return trains;
    }

    /**
     * Get the current state of the heartbeat
     * @return
     */
    public float getState() {
        return state;
    }

    /**
     * Set the current state of the heartbeat
     * @param state
     */
    public void setState(float state) {
        this.state = state;
    }

    @Override
    /**
     * Get the start time of the heartbeat
     */
    public long getTimestamp() {
        return timestamp;
    }
    
    /**
     * States this Heartbeat as unloaded
     * @param unloaded
     */
    public void setUnloaded(boolean unloaded) {
    	isUnloaded = unloaded;
    }
    
    /**
     * Check whether this Heartbeat has already unloaded
     * @return
     */
    public boolean isUnloaded() {
    	return isUnloaded;
    }


}
