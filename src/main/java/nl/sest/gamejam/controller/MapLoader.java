package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.*;

public class MapLoader {

	public MapLoader() {

	}

	/**
	 * TODO connect to xml or something
	 *
	 * @param model
	 */
	public void loadMap(Model model) {

		float gs = 8; // grid square size in meters
		model.setWorldDimension(10 * gs, 10 * gs);

		// Create buildings

		// Line 3
		model.addObstacle(new Obstacle(1 * gs, 3 * gs));
		model.addObstacle(new Obstacle(3 * gs, 3 * gs));
		model.addObstacle(new Obstacle(5 * gs, 3 * gs));
		model.addObstacle(new Obstacle(7 * gs, 3 * gs));
		model.addObstacle(new Obstacle(9 * gs, 3 * gs));

		// Line 5
		model.addObstacle(new Obstacle(1 * gs, 5 * gs));
		model.addObstacle(new Obstacle(3 * gs, 5 * gs));
		model.addObstacle(new Obstacle(5 * gs, 5 * gs));
		model.addObstacle(new Obstacle(7 * gs, 5 * gs));
		model.addObstacle(new Obstacle(7 * gs, 5 * gs));

		model.addObstacle(new Obstacle(2 * gs, 8 * gs, 2));
		model.addObstacle(new Obstacle(9 * gs, 8 * gs, 2));

		// Bobs
		model.addBob(new Bob(2 * gs, 3 * gs));
		model.addBob(new Bob(4 * gs, 3 * gs));
		model.addBob(new Bob(6 * gs, 3 * gs));

		// POIs
		model.addPointOfInterest(new PointOfInterest(7f * gs, 8 * gs, 0, 0));

		// Trains
		model.addTrainDestination(new TrainDestination(0, -5));
	}

}
