package nl.sest.gamejam.model.player;

import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tim
 * @since 1/26/13 9:38 AM
 */
public class PlayerRepulsor implements Force, Renderable {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerRepulsor.class);

	private float x;
	private float y;

	public PlayerRepulsor(float x, float y) {
		LOGGER.debug("Created repulsor at [{}, {}]", x, y);
		this.x = x;
		this.y = y;
	}

	@Override
	public Renderer getRenderer() {
		return null;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
