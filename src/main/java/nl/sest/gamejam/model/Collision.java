package nl.sest.gamejam.model;

import nl.sest.gamejam.model.Physical;

/**
 * @author Tim
 * @since 1/25/13 10:54 PM
 */
public class Collision {

    private Physical collider1;
    private Physical collider2;

    public Physical getCollider1() {
        return collider1;
    }

    public Physical getCollider2() {
        return collider2;
    }
}
