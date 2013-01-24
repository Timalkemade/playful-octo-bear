package nl.tim.test;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Tim
 * @since 23-1-13
 */
public class Avatar implements Drawable, Moveable {

    private Image image;

    private float speed;
    private Vector2f direction;
    private Vector2f location;

    public Avatar(Image anImage, Vector2f aLocation, float aSpeed, Vector2f aDirection) {
        this.image = anImage;
        this.speed = aSpeed;
        this.direction = aDirection;
        this.location = aLocation;
    }

    @Override
    public void render() {
        image.draw(location.x, location.y);
    }

    @Override
    public Vector2f getLocation() {
        return location.copy();
    }

    @Override
    public void setLocation(Vector2f aLocation) {
        location = aLocation.copy();
    }

    @Override
    public void setSpeed(float aSpeed) {
        speed = aSpeed;
    }

    @Override
    public void setDirection(Vector2f aDirection) {
        direction = aDirection.normalise();
    }

    @Override
    public void move(int delta) {
        Vector2f moveLocation = getLocation();

        float step = speed * ((float) delta / 1000f);
        Vector2f movement = direction.scale(step);
        moveLocation.add(movement);
        setLocation(moveLocation);
    }


}
