package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.image.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * This is an object that should be protected.
 *
 * @author Tim
 * @since 1/25/13 10:01 PM
 */
public class Valuable implements Physical, ImageRenderable {

	protected float x, y, value, radius;
	protected boolean dynamic;
	protected Image image;
	protected Renderer renderer;
    protected String imageFile = "images/valuables/Tree1.png";
    protected float imageWidth = 60f;
    protected float imageHeight = 45f;
    protected float angle = 0f;

    public Valuable() {};

	/*public Valuable(float x, float y, float angle) {
		this.x = x;
		this.y = y;
        this.angle = angle;
        initiateValuable();
	}         */

    public void initiateValuable() {
        try {
            image = new Image(imageFile);
        } catch (SlickException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        renderer = new ImageRenderer(this);
    }

	/**
	 * Add the given value to the value of the Valuable
	 *
	 * @param delta
	 */
	public void updateValue(float delta) {
		value += delta;
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public float getY() {
		return this.y;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public float getAngle() {
		return angle+45;
	}

	@Override
	public void setAngle(float angle) {
		this.angle = angle;
	}

	@Override
	public boolean isDynamic() {
		return dynamic;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void setDynamic(boolean dynamic) {
		this.dynamic = dynamic;
	}

	@Override
	public float getRadius() {
		return radius;
	}

	@Override
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
