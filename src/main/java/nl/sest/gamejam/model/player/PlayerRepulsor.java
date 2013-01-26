package nl.sest.gamejam.model.player;

import nl.sest.gamejam.model.Force;

/**
 * @author Tim
 * @since 1/26/13 9:38 AM
 */
public class PlayerRepulsor implements Force {

    private float x;
    private float y;

    public PlayerRepulsor(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
