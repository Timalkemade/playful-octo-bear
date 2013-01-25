package nl.sest.gamejam.model;

/**
 * @author Tim
 * @since 1/25/13 10:54 PM
 */
public class Collision implements Event {

    private Physical collider1;
    private Physical collider2;
    private long timestamp;

    public Collision(Physical aCollider1, Physical aCollider2, long currentTime) {
        this.collider1 = aCollider1;
        this.collider2 = aCollider2;
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
