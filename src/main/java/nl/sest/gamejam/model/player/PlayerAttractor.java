package nl.sest.gamejam.model.player;

import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;

/**
 * The player attractor point is an attractive force that the player sets.
 *
 * @author Tim
 * @since 1/26/13 9:37 AM
 */
public class PlayerAttractor implements Force, Renderable {

	private float x;
	private float y;

	/**
	 * Constructor for the PlayerAttractor.
	 *
	 * @param x x location
	 * @param y y location
	 */
	public PlayerAttractor(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	@Override
	public Renderer getRenderer() {
		return null;
	}
}
