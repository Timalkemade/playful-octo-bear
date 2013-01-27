package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.exception.ImageLoadingException;
import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.view.ParticleRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * A point of interest is a shiny, cool or otherwise attractive point which attracts a Bob.
 *
 * @author Tim
 * @since 1/25/13 10:03 PM
 */
public class PointOfInterest implements Force, ImageRenderable {

	private Renderer renderer;
	private float x;
	private float y;

	private Image image;

	protected float interest = 0; // This will affect how many Bobs will go to this POI.
	protected long startTime = 0;
	protected float maxBoostTime = 0; // The total lifetime of this POI (sigma of Gaussian function)
	protected float maxInterest = 0; // The maximum interest that this POI will reach ('a' of Gaussian function)
	protected float staticInterest = 0; // If set higher than 0, this will always stay the same

	/**
	 * Constructor for a point of interest.
	 *
	 * @param x The x location of this PointOfInterest
	 * @param y The y location of this PointOfInternet
	 */
	public PointOfInterest(float x, float y, float interest) {
		this.x = x;
		this.y = y;
		this.interest = interest;

		this.startTime = System.currentTimeMillis();

		try {
			this.image = new Image("images/earth.jpg");
		} catch (SlickException e) {
			throw new ImageLoadingException("Could not load image", e);
		}

		this.renderer = new ParticleRenderer(this);
	}
	
	/**
	 * Set a static interest to this POI. This will not change if set.
	 * @param interest
	 */
	public void setStaticInterest(float interest) {
		staticInterest = interest;
	}

	/**
	 * Starts the lifecycle of the POI
	 *
	 * @param maxInterest The interest factor to which it will grow
	 * @param lifetime    The time during which the POI will be active
	 */
	public void start(float maxInterest, float lifetime) {
		startTime = System.currentTimeMillis();
		interest = 0.01f;
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
	public long getStartTime() {
		return startTime;
	}

	/**
	 * Get the total expected lifetime of this POI.
	 *
	 * @return
	 */
	public float getMaxBoostTime() {
		return maxBoostTime;
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

	@Override
	public Image getImage() {
		return image;
	}

    @Override
    public float getAngle() {
        return 0f;
    }
}
