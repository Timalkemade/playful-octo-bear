package nl.sest.gamejam.view;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 13:22
 */
public class ViewPOI implements Renderer {

    /** The particle system running everything */
    private ParticleSystem system;
    int delta = 0;

    /**
     * POI particle view
     * @param location Vector2f lcoation of POI
     * @param delta Delta integer for the Particle state
     * @throws SlickException
     */
    public ViewPOI( Vector2f location, int delta) throws SlickException{
        Image image = new Image("images/earth.jpg", true);
        system = new ParticleSystem(image);

        system.addEmitter(new FireEmitter( (int)location.x, (int)location.y ));
    }

    public void render(){
        system.update(delta+1);
        system.render();
    }


}
