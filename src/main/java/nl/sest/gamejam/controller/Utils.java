package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import org.newdawn.slick.geom.Vector2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

	private static float screenHeight;
	private static float width;
	private static Model model;

	private Utils() {
	}

	public static void initialize(float width, float height) {
		Utils.screenHeight = height;
		Utils.width = width;
	}

	public static void setModel(Model theModel) {
		Utils.model = theModel;
	}

	/**
	 * Computes World coordinates from Screen coordinates
	 *
	 * @param x
	 * @param y
	 * @return The Coordinate in meters
	 */
	public static Vector2f screenToWorld(Model model, float x, float y) {
		float worldHeight = model.getWorldHeight();

		float ratio = worldHeight / screenHeight;

		float worldX = x * ratio;
		float worldY = (screenHeight - y) * ratio;

		return new Vector2f(worldX, worldY);
	}

	public static float getWorldToScreenScale() {
		return screenHeight / model.getWorldHeight();
	}
	
	public static Vector2f worldToScreen(float x, float y) {

		float worldHeight = model.getWorldHeight();
		float ratio = screenHeight / model.getWorldHeight();

		float screenX = x * ratio;
		float screenY = (worldHeight - y) * ratio;
		return new Vector2f(screenX, screenY);
	}

}
