package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Physical;

/**
 * @author Tim
 * @since 1/25/13 10:54 PM
 */
public class Collision implements Event {

    private final Physical collider1;
    private final Physical collider2;
    private final long timestamp;

    public Collision(Physical aCollider1, Physical aCollider2) {
        this.collider1 = aCollider1;
        this.collider2 = aCollider2;
        timestamp = System.currentTimeMillis();
    }

    public Physical getCollider1() {
        return collider1;
    }

    public Physical getCollider2() {
        return collider2;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }
}
