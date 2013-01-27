package nl.sest.gamejam.model.player;

import nl.sest.gamejam.exception.ImageLoadingException;
import nl.sest.gamejam.model.AnimationRenderable;
import nl.sest.gamejam.model.Force;
import nl.sest.gamejam.view.AnimationRenderer;
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
    private String repulsorDir = "repulsor3";

	public PlayerRepulsor(float x, float y) {
		LOGGER.debug("Created repulsor at [{}, {}]", x, y);
		this.x = x;
		this.y = y;

        try {
            animation = new Animation(true);
            Image im1 = new Image("images/"+repulsorDir+"/WC_1.png");
            Image im2 = new Image("images/"+repulsorDir+"/WC_2.png");
            Image im3 = new Image("images/"+repulsorDir+"/WC_3.png");
            Image im4 = new Image("images/"+repulsorDir+"/WC_4.png");


            animation.addFrame(im1, duration);
            animation.addFrame(im2, duration);
            animation.addFrame(im3, duration);
            animation.addFrame(im4, duration);
            animation.addFrame(im3, duration);
            animation.addFrame(im2, duration);
            animation.addFrame(im1, duration);
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

	public void setX(float newX) {
		x = newX;
	}

	public void setY(float newY) {
		y = newY;
	}
}
