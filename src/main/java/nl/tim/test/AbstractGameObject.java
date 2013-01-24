package nl.tim.test;

import org.newdawn.slick.geom.Vector2f;

/**
 * @author Tim
 * @since 23-1-13
 */
public abstract class AbstractGameObject implements Drawable {

    private Vector2f location;

    public AbstractGameObject(Vector2f aLocation) {
        location = aLocation;
    }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    @Override
    public abstract void render();

}
