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
 * @author Tim
 * @since 1/26/13 9:38 AM
 */
public class PlayerRepulsor implements Force, AnimationRenderable {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerRepulsor.class);

	private float x;
	private float y;
	private int duration = 50;
    private Animation animation;
	private Renderer renderer;

	public PlayerRepulsor(float x, float y) {
		LOGGER.debug("Created repulsor at [{}, {}]", x, y);
		this.x = x;
		this.y = y;

        try {
            animation = new Animation(true);
            animation.addFrame(new Image("images/repulsor1/WC_1.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_2.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_3.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_4.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_3.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_2.png"), duration);
            animation.addFrame(new Image("images/repulsor1/WC_1.png"), duration);
            animation.setLooping(true);
            this.renderer = new AnimationRenderer(this);
        } catch (SlickException e) {
            throw new ImageLoadingException("Failed to load image", e);
        }
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
    public Animation getAnimation() {
        return animation;
    }

}
