package nl.sest.gamejam.model.impl;

import org.jbox2d.common.Vec2;

import nl.sest.gamejam.model.Physical;

public class Edge implements Physical{

	float radius, angle;
	boolean dynamic = false;
	Vec2 point1, point2;
	
	public Edge(Vec2 point1, Vec2 point2) {
		this.point1 = point1;
		this.point2 = point2;
	}
	
	public Vec2 getPoint1() {
		return point1;
	}
	
	public Vec2 getPoint2() {
		return point2;
	}
	
	@Override
	public float getX() {
		return point1.x;
	}

	@Override
	public void setX(float x) {
		point1.x = x;
	}

	@Override
	public float getY() {
		return point1.y;
	}

	@Override
	public void setY(float y) {
		point1.y = y;
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
