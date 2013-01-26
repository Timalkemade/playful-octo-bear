package nl.sest.gamejam.model.player;

import nl.sest.gamejam.exception.ImageLoadingException;
import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tim
 * @since 1/26/13 9:38 AM
 */
public class PlayerRepulsor implements Force, ImageRenderable {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerRepulsor.class);

	private float x;
	private float y;
	private Image image;
	private Renderer renderer;

	public PlayerRepulsor(float x, float y) {
		LOGGER.debug("Created repulsor at [{}, {}]", x, y);
		this.x = x;
		this.y = y;

		try {
			image = new Image("images/dino.png");
		} catch (SlickException e) {
			throw new ImageLoadingException("Failed to load image", e);
		}
		this.renderer = new ImageRenderer(this);

	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	@Override
	public Image getImage() {
		return image;
	}
}
