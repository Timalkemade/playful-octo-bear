package nl.sest.gamejam.physics;

import java.util.HashMap;

import nl.sest.gamejam.model.Physical;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

public class PhysicsInterface {

	private World world;
	private HashMap<Physical, Body> objects;
	
    public int targetFPS = 120;  
    public int timeStep = (1000 / targetFPS);  
    
	public PhysicsInterface() {
		
	}
	
	public void update() {
		// Update Box2D world
        world.step(timeStep, 8, 3);
        
        // Sync Box2D objects with the Physical objects
        for (Physical physical : objects.keySet()) {
        	Body body = objects.get(physical);
        	
        	physical.setX(body.getPosition().x);
        	physical.setY(body.getPosition().y);
        	physical.setAngle(body.getAngle());
        }
	}
	
	public void addObject(Physical physical) {
		// Create Bodydef using Physical properties
		float x = physical.getX();
		float y = physical.getY();
		float angle = physical.getAngle();

		BodyDef bodyDef = new BodyDef();
	    bodyDef.angle = angle;
		bodyDef.position.set(x,y);

		if (physical.isDynamic()) {
			bodyDef.type = BodyType.DYNAMIC;
		}
		else {
			bodyDef.type = BodyType.STATIC;
		}
		
		// Attach Bodydef to world and save body to hashmap
		Body body = world.createBody(bodyDef);
		body.setUserData(physical);
		objects.put(physical, body);
	}
	
	public void deleteObject(Physical physical) {
		// Get Body attached to Physical object
		Body body = objects.get(physical);
		
		// Remove Body from world and Physical from hashmap
		world.destroyBody(body);
		objects.remove(physical);
	}
}
