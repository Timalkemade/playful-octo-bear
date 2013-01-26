package nl.sest.gamejam.physics;

import java.util.HashMap;

import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.impl.Bob;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PhysicsInterface {

	private World world;
	private HashMap<Physical, Body> objects;
	
    public int targetFPS = 120;  
    public int timeStep = (1000 / targetFPS);  
    
	public PhysicsInterface() {
	    // Init world
		Vec2 gravity = new Vec2(0.0f, 0.0f);
	    boolean doSleep = true;
	    
	    world = new World(gravity, doSleep);
	}
	
	public void update() {
		// Update Box2D world
        world.step(timeStep, 8, 3);
        
        // Sync Box2D objects with the Physical objects
        for (Physical physical : objects.keySet()) {
        	Body body = objects.get(physical);
        	
        	// If the physical is a Bob, apply force (use predefined force for now)
        	if (physical instanceof Bob) {
        		body.applyForce(new Vec2(5, 5), body.getWorldCenter());
        	}
        	
        	// If the Physical is dynamic, update the Physical properties using the Body properties
        	if (physical.isDynamic()) {
	        	physical.setX(body.getPosition().x);
	        	physical.setY(body.getPosition().y);
	        	physical.setAngle(body.getAngle());
        	}
        	// Else if the Physical is static, update the Body properties using the Physical properties
        	else {
        		float x = physical.getX();
        		float y = physical.getY();
        		float angle = physical.getAngle();
        		body.setTransform(new Vec2(x, y), angle);
        	}
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

		// Create shape (use circle for now)
	    CircleShape circleShape = new CircleShape();
	    circleShape.m_radius = 0.5f;

	    // Create FixtureDef (use predefined parameters for now)
	    FixtureDef fixtureDef = new FixtureDef();
	    fixtureDef.shape = circleShape;
	    fixtureDef.density = 1;
	    fixtureDef.friction = 0.01f;
	    fixtureDef.restitution = 0.3f;
		
	    // Attach FixtureDef to body
	    body.createFixture(fixtureDef);
	}
	
	public void deleteObject(Physical physical) {
		// Get Body attached to Physical object
		Body body = objects.get(physical);
		
		// Remove Body from world and Physical from hashmap
		world.destroyBody(body);
		objects.remove(physical);
	}
}
