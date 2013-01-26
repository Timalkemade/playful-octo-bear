package nl.sest.gamejam.controller;

import org.jbox2d.common.Vec2;

import nl.sest.gamejam.model.impl.Model;

public class Utils {

	private static float height;
	private static float width;
	
	public static void setScreenDimension(float width, float height) {
		Utils.height = height;
		Utils.width = width;
	}
	
	public static float getScreenWidth() {
		return width;
	}
	
	public static float getScreenHeight() {
		return height;
	}
	
	/**
	 * Computes World coordinates from Screen coordinates
	 * @param x
	 * @param y
	 * @return The Coordinate in meters
	 */
	public static Vec2 screenToWorld(Model model, float x, float y) {
		float worldHeight = model.getWorldHeight();
		
		float ratio = worldHeight / height;
		
		float worldX = x * ratio;
		float worldY = y * ratio; 
		
		return new Vec2(worldX, worldY);
	}

}
