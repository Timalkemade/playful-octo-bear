package nl.sest.gamejam.model.impl;

import org.newdawn.slick.Image;

import nl.sest.gamejam.model.Physical;

public class Obstacle implements Physical {

	private float x, y, radius, angle;
	private boolean isDynamic = false;
	private Image image;
	private static float defaultRadius = 4;
	
	/**
	 * Create an Obstacle of a certain size
	 * @param x
	 * @param y
	 * @param size 1 for default size, 2 for 4x size, 3 for 16x size
	 */
	public Obstacle(float x, float y, int size) {
		this(x,y);
		setRadius(size*defaultRadius);
	}
	
	public Obstacle(float x, float y) {
		this.x = x;
		this.y = y;
		setRadius(defaultRadius);
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
		return y;
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
		return isDynamic;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void setImage(Image anImage) {
		image = anImage;
	}

	@Override
	public void setDynamic(boolean dynamic) {
		this.isDynamic = dynamic;
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
