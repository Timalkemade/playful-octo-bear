package nl.sest.gamejam.model.impl;

import org.newdawn.slick.geom.Point;

/**
 * This is an area where new Bobs come into the World by a Train.
 * @author Remi
 *
 */
public class TrainDestination {

	private Point location;
	
	public TrainDestination(float x, float y) {
		location = new Point(x, y);
	}
	
	public Point getLocation() {
		return location;
	}

}
