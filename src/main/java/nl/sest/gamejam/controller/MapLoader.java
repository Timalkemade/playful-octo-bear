package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Constants;
import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.model.impl.Obstacle;

public class MapLoader {

	public MapLoader() {
		
	}
	
	/**
	 * TODO connect to xml or something
	 * @param model
	 */
	public void loadMap(Model model) {
		
		float gs = 4 * Constants.METER_SIZE; // grid square size in meters
		// With 800 * 800 pixels and METER_SIZE of 20, there are 40 * 40 meters, 10 * 10 grids
		
		// Create buildings
		
		// Line 3
		model.addObstacle(new Obstacle(1*gs, 3*gs));
		model.addObstacle(new Obstacle(3*gs, 3*gs));
		model.addObstacle(new Obstacle(5*gs, 3*gs));
		model.addObstacle(new Obstacle(7*gs, 3*gs));
		model.addObstacle(new Obstacle(9*gs, 3*gs));
		
		// Line 5
		model.addObstacle(new Obstacle(1*gs, 5*gs));
		model.addObstacle(new Obstacle(3*gs, 5*gs));
		model.addObstacle(new Obstacle(5*gs, 5*gs));
		model.addObstacle(new Obstacle(7*gs, 5*gs));
		model.addObstacle(new Obstacle(7*gs, 5*gs));
		
		model.addObstacle(new Obstacle(2*gs, 8*gs));
		model.addObstacle(new Obstacle(2*gs, 8*gs));
	}

}
