package nl.sest.gamejam.physics;

import nl.sest.gamejam.model.impl.Bob;
import nl.sest.gamejam.model.impl.Obstacle;
import nl.sest.gamejam.model.impl.Valuable;

public interface PhysicsCollisionListener {

	void obstacleCollisionEvent(Bob bob, Obstacle obstacle); 
	
	void valuableCollisionEvent(Bob bob, Valuable valuable);
	
}
