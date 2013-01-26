package nl.sest.gamejam.view;

import nl.sest.gamejam.model.ImageRenderable;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 11:40
 */
public class ImageRenderer implements Renderer {

	private ImageRenderable object;

	/**
	 * Create view for physical object
	 *
	 * @param newObject Physical object
	 */
	public ImageRenderer(ImageRenderable newObject) {
		object = newObject;
	}

	/**
	 * Render object
	 */
	public void render() {
		Image image = object.getImage();
		Vector2f location = new Vector2f(object.getX(), object.getY());
		image.draw(location.x, location.y);
	}
}
