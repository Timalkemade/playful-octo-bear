package nl.sest.gamejam.controller;

import org.jbox2d.common.Vec2;

import nl.sest.gamejam.model.impl.*;
import nl.sest.gamejam.model.obstacle.building.*;

public class MapLoader {

	public MapLoader() {

	}

	/**
	 * TODO connect to xml or something
	 *
	 * @param model
	 */
	public void loadMap(Model model) {

		float gs = 16; // grid square size in meters
		model.setWorldDimension(20 * gs, 15 * gs);
		
		// Buildings
        model.addObstacle(new NormalBuilding(2 * gs, 2 * gs, "N"));
        model.addObstacle(new NormalBuilding(9 * gs, 2 * gs, "N"));
		model.addObstacle(new NormalBuilding(14 * gs, 2 * gs, "N"));
		model.addObstacle(new NormalBuilding(19 * gs, 3 * gs, "N"));
		model.addObstacle(new NormalBuilding(12 * gs, 4 * gs, "N"));
		model.addObstacle(new NormalBuilding(17 * gs, 4 * gs, "N"));
		model.addObstacle(new NormalBuilding(5 * gs, 5 * gs, "N"));
		model.addObstacle(new NormalBuilding(8 * gs, 5 * gs, "N"));
		model.addObstacle(new NormalBuilding(11 * gs, 6 * gs, "N"));
		model.addObstacle(new NormalBuilding(15 * gs, 6 * gs, "N"));
		model.addObstacle(new NormalBuilding(18 * gs, 6 * gs, "N"));
		model.addObstacle(new NormalBuilding(2 * gs, 7 * gs, "N"));
		model.addObstacle(new NormalBuilding(6 * gs, 7 * gs, "N"));
		model.addObstacle(new NormalBuilding(8 * gs, 7 * gs, "N"));
		model.addObstacle(new NormalBuilding(10 * gs, 8 * gs, "E"));
		model.addObstacle(new NormalBuilding(13 * gs, 8 * gs, "N"));
		model.addObstacle(new NormalBuilding(16 * gs, 9 * gs, "N"));
		model.addObstacle(new NormalBuilding(2 * gs, 11 * gs, "N"));
		model.addObstacle(new NormalBuilding(8 * gs, 11 * gs, "N"));
		model.addObstacle(new NormalBuilding(10 * gs, 11 * gs, "N"));
		model.addObstacle(new NormalBuilding(6 * gs, 12 * gs, "N"));
		model.addObstacle(new NormalBuilding(12 * gs, 12 * gs, "N"));
		model.addObstacle(new NormalBuilding(17 * gs, 12 * gs, "N"));
		model.addObstacle(new NormalBuilding(2 * gs, 13 * gs, "N"));
		model.addObstacle(new NormalBuilding(9 * gs, 13 * gs, "N"));
		model.addObstacle(new NormalBuilding(19 * gs, 13 * gs, "N"));
		model.addObstacle(new NormalBuilding(5 * gs, 14 * gs, "N"));
		model.addObstacle(new NormalBuilding(13 * gs, 14 * gs, "N"));

		// Trains
		model.addTrainDestination(new TrainDestination(10 * gs, -2 * gs));
		model.addTrainDestination(new TrainDestination(-2 * gs, 4 * gs));

		// POIs
		model.addPointOfInterest(new PointOfInterest(6 * gs, 2 * gs, 1));
//		model.addPointOfInterest(new PointOfInterest(6 * gs, 9 * gs, 0.5f));
		model.addPointOfInterest(new PointOfInterest(7 * gs, 14 * gs, 1f));
		model.addPointOfInterest(new PointOfInterest(19 * gs, 10 * gs, 1f));
//		model.addPointOfInterest(new PointOfInterest(12 * gs, 6 * gs, 0.5f));
		PointOfInterest goal = new PointOfInterest(17 * gs, 20 * gs, 50);
		model.addPointOfInterest(goal);
		
		
		// Valuable
//		model.addValuable(new ATM(10.5f * gs, 3.5f * gs));
//		model.addValuable(new Tree1(19f * gs, 5f * gs));
//		model.addValuable(new Bus(7f * gs, 6f * gs));
//		model.addValuable(new Bench(17f * gs, 6.5f * gs));
//		model.addValuable(new Garbagebin1(2f * gs, 7.5f * gs));
//		model.addValuable(new Tree2(9f * gs, 7.5f * gs));
//		model.addValuable(new Tile(18f * gs, 10f * gs));
//		model.addValuable(new Lantern(8f * gs, 11.5f * gs));
//		model.addValuable(new Tree1(10.5f * gs, 13f * gs));
		
		// Edges
		model.addEdge(new Edge(new Vec2(10*gs,16*gs), new Vec2(80*gs,1))); // top wall
//		model.addEdge(new Edge(new Vec2(19*gs,-5*gs), new Vec2(18*gs,0))); // to guide Bobs (top right)
//		model.addEdge(new Edge(new Vec2(20*gs,0), new Vec2(25*gs,-2*gs))); // to guide Bobs (top right)
//		
//		model.addEdge(new Edge(new Vec2(20*gs,0), new Vec2(20*gs,15*gs))); // right wall
//		model.addEdge(new Edge(new Vec2(5*gs,15*gs), new Vec2(20*gs,15*gs))); // bottom wall
//		model.addEdge(new Edge(new Vec2(20*gs,0), new Vec2(20*gs,15*gs))); // guide Bobs in (bottom right)
//		model.addEdge(new Edge(new Vec2(20*gs,15*gs), new Vec2(25*gs,20*gs))); // guide Bobs in (bottom right)
//		
//		model.addEdge(new Edge(new Vec2(0,5*gs), new Vec2(0,15*gs))); // left wall
//		model.addEdge(new Edge(new Vec2(0,15*gs), new Vec2(-5*gs,17*gs))); // guide Bobs in (bottom left)
//		model.addEdge(new Edge(new Vec2(5*gs,15*gs), new Vec2(2*gs,20*gs))); // guide Bobs in (bottom left)
//		
//		model.addEdge(new Edge(new Vec2(0,5*gs), new Vec2(-5*gs,-2*gs))); // guide Bobs in (top left)
//		model.addEdge(new Edge(new Vec2(5*gs,0), new Vec2(0*gs,-5*gs))); // guide Bobs in (top left)
		
	}

}
