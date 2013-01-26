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
		model.addObstacle(new Obstacle(1 * gs, 3 * gs, "Normal", "N"));
		model.addObstacle(new Obstacle(3 * gs, 3 * gs, "Normal", "E"));
		model.addObstacle(new Obstacle(5 * gs, 3 * gs, "Normal", "S"));
		model.addObstacle(new Obstacle(7 * gs, 3 * gs, "Normal", "W"));
		model.addObstacle(new Obstacle(9 * gs, 3 * gs, "Normal", "N"));

		// Line 5
		model.addObstacle(new Obstacle(1 * gs, 5 * gs, "Bank", "N"));
		model.addObstacle(new Obstacle(3 * gs, 5 * gs, "Normal", "S"));
		model.addObstacle(new Obstacle(5 * gs, 5 * gs, "Normal", "N"));
		model.addObstacle(new Obstacle(7 * gs, 5 * gs, "Jewelry", "S"));
		model.addObstacle(new Obstacle(7 * gs, 5 * gs, "Normal", "N"));

		model.addObstacle(new Obstacle(2 * gs, 8 * gs, "Normal", "S", 2));
		model.addObstacle(new Obstacle(9 * gs, 8 * gs, "Normal", "N", 2));

		// Bobs
		model.addBob(new Bob(2 * gs, 3 * gs));
		model.addBob(new Bob(4 * gs, 3 * gs));
		model.addBob(new Bob(6 * gs, 3 * gs));

		// POIs
		model.addPointOfInterest(new PointOfInterest(4 * gs, 4 * gs, 0, 0));

		// Trains
		model.addTrainDestination(new TrainDestination(0, -5));

		// Valuable
		model.addValuable(new Valuable(2 * gs, 2 * gs, 1000));
	}

}
