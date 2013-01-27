package nl.sest.gamejam.model.player;

import nl.sest.gamejam.exception.ImageLoadingException;
import nl.sest.gamejam.model.AnimationRenderable;
import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.view.AnimationRenderer;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The player attractor point is an attractive force that the player sets.
 *
 * @author Tim
 * @since 1/26/13 9:37 AM
 */
public class PlayerAttractor implements Force, AnimationRenderable {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerAttractor.class);

	private float x;
	private float y;
	private Animation animation;
    private int duration = 50;

	private Renderer renderer;

	/**
	 * Constructor for the PlayerAttractor.
	 *
	 * @param x x location
	 * @param y y location
	 */
	public PlayerAttractor(float x, float y) {
		//LOGGER.debug("Created attractor at [{}, {}]", x, y);
		this.x = x;
		this.y = y;

        try {
            animation = new Animation(true);
            animation.addFrame(new Image("images/attractor/ATRACTOR1.png"), duration);
            animation.addFrame(new Image("images/attractor/ATRACTOR2.png"), duration);
            animation.setLooping(true);
            renderer = new AnimationRenderer(this);
        } catch (SlickException e) {
            throw new ImageLoadingException("Failed to load image", e);
        }
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

    @Override
    public Animation getAnimation() {
        return animation;
    }
}
