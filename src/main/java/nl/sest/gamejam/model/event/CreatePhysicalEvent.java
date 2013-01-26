package nl.sest.gamejam.model.event;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Physical;

/**
 * An event which is triggered when a new physical is added to the model.
 *
 * @author Tim
 * @since 1/26/13 11:36 AM
 */
public class CreatePhysicalEvent implements Event {

    private final Physical physical;
    private final long timestamp;

    public CreatePhysicalEvent(Physical aPhysical) {
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
