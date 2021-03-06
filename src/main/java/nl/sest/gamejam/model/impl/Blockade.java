package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.exception.ImageLoadingException;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.image.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * @author Tim
 * @since 1/27/13 12:47 AM
 */
public class Blockade implements Physical, ImageRenderable {

	private float x;
	private float y;
	private float angle;
	private boolean isDynamic;
	private Blockade previous;

	public final static float RADIUS = 1f;

	private Image image;
	private Renderer renderer;

	public Blockade(float x, float y, boolean dynamic, Blockade previous) {
		this.x = x;
		this.y = y;
		isDynamic = dynamic;
		this.previous = previous;
		try {
			image = new Image("images/bobs/bloodcell.png");
		} catch (SlickException e) {
			throw new ImageLoadingException("Failed to load image");
		}

		renderer = new ImageRenderer(this);
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}

	public boolean isDynamic() {
		return isDynamic;
	}

	public void setDynamic(boolean dynamic) {
		isDynamic = dynamic;
	}

	public float getRadius() {
		return RADIUS;
	}

	/**
	 * No-Op.
	 *
	 * @param radius the radius to ingore
	 */
	public void setRadius(float radius) {
	}

	public Blockade getPrevious() {
		return previous;
	}

	@Override
	public Image getImage() {
		return image;
	}
}
