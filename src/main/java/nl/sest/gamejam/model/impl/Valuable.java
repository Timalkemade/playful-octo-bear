package nl.sest.gamejam.model.impl;

import org.newdawn.slick.Image;

import nl.sest.gamejam.model.Physical;

/**
 * This is an object that should be protected.
 *
 * @author Tim
 * @since 1/25/13 10:01 PM
 */
public class Valuable implements Physical {

	float x, y, value, angle, radius;
	boolean dynamic;
	Image image;
	
	public Valuable(float x, float y, float value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	/**
	 * Add the given value to the value of the Valuable
	 * @param delta
	 */
	public void updateValue(float delta) {
		value += delta;
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
