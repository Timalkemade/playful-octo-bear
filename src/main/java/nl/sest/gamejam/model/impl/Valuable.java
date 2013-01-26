package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImagePicker;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;

/**
 * This is an object that should be protected.
 *
 * @author Tim
 * @since 1/25/13 10:01 PM
 */
public class Valuable implements Physical, ImageRenderable {

	private float x, y, value, angle, radius;
	private boolean dynamic;
	private Image image;
	private Renderer renderer;

	public Valuable(float x, float y, float value) {
		this.x = x;
		this.y = y;
		this.value = value;
		ImagePicker im = new ImagePicker();
		this.image = im.pick("valuables");
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
		return angle;
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
	public void setImage(Image anImage) {
		this.image = anImage;
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
