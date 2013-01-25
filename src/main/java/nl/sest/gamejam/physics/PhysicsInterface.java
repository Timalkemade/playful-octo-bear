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
        
        // Sync Box2D objects with the physical objects
        for (Physical physical : objects.keySet()) {
        	Body body = objects.get(physical);
        	
        	physical.setX(body.getPosition().x);
        	physical.setY( body.getPosition().y);
        }
	}
	
	public void addObject(Physical physical) {
		// Create Bodydef using Physical properties
		float x = physical.getX();
		float y = physical.getY();

		BodyDef bodyDef = new BodyDef();
	    bodyDef.type = BodyType.STATIC;
	    bodyDef.angle = 0;
		bodyDef.position.set(x,y);
		
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
