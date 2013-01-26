package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.ViewPOI;

/**
 * A point of interest is a shiny, cool or otherwise attractive point which attracts a Bob.
 *
 * @author Tim
 * @since 1/25/13 10:03 PM
 */
public class PointOfInterest implements Force, Renderable {

    private Renderer renderer;
	private float x;
	private float y;

	protected float interest = 0; // This will affect how many Bobs will go to this POI.
	protected long startTime = 0;
	protected float maxLifetime = 0; // The total lifetime of this POI (sigma of Gaussian function)
	protected float maxInterest = 0; // The maximum interest that this POI will reach ('a' of Gaussian function)


	/**
	 * Constructor for a point of interest.
	 *
	 * @param x The x location of this PointOfInterest
	 * @param y The y location of this PointOfInternet
	 */
	public PointOfInterest(float x, float y, float maxInterest, float lifetime) {
		this.x = x;
		this.y = y;

		this.startTime = System.currentTimeMillis();
		this.maxInterest = maxInterest;
		this.maxLifetime = lifetime;
        this.renderer = new ViewPOI( this );
	}

	/**
	 * Starts the lifecycle of the POI
	 * @param maxInterest The interest factor to which it will grow
	 * @param lifetime The time during which the POI will be active
	 */
	public void start(float maxInterest, float lifetime) {
		startTime = System.currentTimeMillis();
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	/**
	 * Get the time at which this POI was created
	 *
	 * @return
	 */
	public float getStartTime() {
		return startTime;
	}

	/**
	 * Get the total expected lifetime of this POI.
	 *
	 * @return
	 */
	public float getMaxLifetime() {
		return maxLifetime;
	}

	/**
	 * Get the maximum interest factor that this POI should reach.
	 *
	 * @return
	 */
	public float getMaxInterest() {
		return maxInterest;
	}

	/**
	 * Set the interest factor of the POI (this affects how many Bobs will go to this POI).
	 *
	 * @param i
	 */
	public void setInterest(float i) {
		interest = i;
	}

	/**
	 * Gets the interest factor of this POI. This affects how many Bobs will go to this POI.
	 *
	 * @return
	 */
	public float getInterest() {
		return interest;
	}

	@Override
	public Renderer getRenderer() {
        return renderer;
	}

    public void updateRenderer(int delta) {
        this.renderer.update(delta);
    }
}
