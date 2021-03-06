package nl.sest.gamejam.view.image;

import nl.sest.gamejam.controller.Utils;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 11:40
 */
public class ImageRenderer implements Renderer {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageRenderer.class);

	private ImageRenderable object;
    private Image image;

	/**
	 * Create view for physical object
	 *
	 * @param newObject Physical object
	 */
	public ImageRenderer(ImageRenderable newObject) {
		object = newObject;
        image = object.getImage();
        image.rotate(object.getAngle());
	}

	/**
	 * Render object
	 */
	public void render() {
		//LOGGER.debug("original Location {}, {}", object.getX(), object.getY());
		Vector2f location = Utils.worldToScreen(object.getX(), object.getY());
		float drawLocationX = location.getX() - image.getCenterOfRotationX();
		float drawLocationY = location.getY() - image.getCenterOfRotationY();
	    //LOGGER.debug("scale {}", Utils.getWorldToScreenScale());
		image.draw(drawLocationX, drawLocationY, Utils.getWorldToScreenScale());
	}

	@Override
	public void update(int delta) {
	}
}
