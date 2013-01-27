package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Physical;

public class Pit implements Physical {

	float x, y, angle, radius;
	boolean dynamic = false;
	
	public Pit(float x, float y) {
		this.x = x;
		this.y = y;
		radius = 2;
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
		return dynamic;
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
