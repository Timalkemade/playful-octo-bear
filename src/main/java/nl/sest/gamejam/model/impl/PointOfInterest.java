package nl.sest.gamejam.model.impl;

import org.newdawn.slick.geom.Point;

/**
 * A point of interest is a shiny, cool or otherwise attractive point which attracts a Bob
 *
 * @author Tim
 * @since 1/25/13 10:03 PM
 */
public class PointOfInterest {

	protected float interest = 0; // This will affect how many Bobs will go to this POI.
	protected Point location; // The location of this POI
	
	/**
	 * 
	 * @param location The location where this point should be situated.
	 */
	public PointOfInterest(Point location) {
		this.location = location;
	}
	
	/**
	 * Set the interest factor of the POI (this affects how many Bobs will go to this POI).
	 * @param i
	 */
	public void setInterest(float i) {
		interest = i;
	}
	
	/**
	 * Gets the interest factor of this POI. This affects how many Bobs will go to this POI.
	 * @return
	 */
	public float getInterest() {
		return interest;
	}
	
	/**
	 * The location where this POI is situated.
	 */
	public Point getLocation() {
		return location;
	}
	
}
