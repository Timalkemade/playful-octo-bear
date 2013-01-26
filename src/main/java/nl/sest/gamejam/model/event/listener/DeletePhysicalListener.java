package nl.sest.gamejam.model.event.listener;

import nl.sest.gamejam.model.Physical;

/**
 * A listener for DeletePhysicalEvents
 *
 * @author Tim
 * @since 1/26/13 11:58 AM
 */
public interface DeletePhysicalListener {

    void fireDeletePhysical(Physical physical);
}
