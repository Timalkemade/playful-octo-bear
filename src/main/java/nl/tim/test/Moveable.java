package nl.tim.test;

import org.newdawn.slick.geom.Vector2f;

/**
 * @author Tim
 * @since 23-1-13
 */
public interface Moveable {

    Vector2f getLocation();

    void setLocation(Vector2f location);

    void setSpeed(float speed);

    void setDirection(Vector2f direction);

    void move(int delta);

}
