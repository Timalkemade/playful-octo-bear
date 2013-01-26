package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Event;

/**
 * A heartbeat is the basic flow of the game. Each heartbeat a new flow of bobs appears.
 *
 * @author Tim
 * @since 1/26/13 12:35 AM
 */
public class Heartbeat implements Event {

    private final long timestamp;
    private float state;

    /**
     * Constructor for heartbeat. Use the state initialize the state and the timestamp.
     * @param state the initial state
     */
    public Heartbeat(float state) {
        this.timestamp = System.currentTimeMillis();
        this.state = state;
    }

    public float getState() {
        return state;
    }

    public void setState(float state) {
        this.state = state;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }


}
