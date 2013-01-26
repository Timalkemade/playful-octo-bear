package nl.sest.gamejam.model;

import nl.sest.gamejam.view.Renderer;

/**
 * @author Tim
 * @since 1/25/13 10:09 PM
 */
public interface Renderable {

	/**
	 * The renderer that can render the object.
	 *
	 * @return The renderer
	 */
	Renderer getRenderer();

	/**
	 * Get X coordinate.
	 *
	 * @return the x coordinate
	 */
	float getX();

	/**
	 * Get Y coordinate.
	 *
	 * @return the y coordinates
	 */
	float getY();


}
