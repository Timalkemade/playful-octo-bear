package nl.sest.gamejam.model.event;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Physical;

/**
 * An event which is triggered when a bob is removed from the model.
 *
 * @author Tim
 * @since 1/26/13 11:41 AM
 */
public class RemovePhysicalEvent implements Event {

    private Physical physical;
    private long timestamp;

    public RemovePhysicalEvent(Physical aPhysical) {
        timestamp = System.currentTimeMillis();
        this.physical = aPhysical;
    }

    public Physical getPhysical() {
        return physical;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
