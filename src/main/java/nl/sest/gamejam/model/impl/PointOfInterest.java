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
	protected long startTime = 0;
	protected float maxLifetime = 0; // The total lifetime of this POI (sigma of Gaussian function)
	protected float maxInterest = 0; // The maximum interest that this POI will reach ('a' of Gaussian function)
	
	/**
	 * 
	 * @param location The location where this point should be situated.
	 */
	public PointOfInterest(Point location, float maxInterest, float lifetime) {
		this.location = location;
		startTime = System.currentTimeMillis();
		this.maxInterest = maxInterest;
		this.maxLifetime = lifetime;
	}
	
	/**
	 * Get the time at which this POI was created
	 * @return
	 */
	public float getStartTime() {
		return startTime;
	}
	
	/**
	 * Get the total expected lifetime of this POI.
	 * @return
	 */
	public float getMaxLifetime() {
		return maxLifetime;
	}
	
	/**
	 * Get the maximum interest factor that this POI should reach.
	 * @return
	 */
	public float getMaxInterest() {
		return maxInterest;
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
