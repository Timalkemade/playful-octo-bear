package nl.sest.gamejam.view;

import nl.sest.gamejam.controller.Utils;
import nl.sest.gamejam.model.Renderable;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 13:22
 */
public class ViewPOI implements Renderer {

	/**
	 * The particle system running everything
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewPOI.class);

	private ParticleSystem system;
	private Renderable object;

	/**
	 * POI particle view
	 *
	 * @param newObject Renderable object POI
	 */
	public ViewPOI(Renderable newObject) {
		object = newObject;

		Image image = null;
		try {
			image = new Image("images/earth.jpg", true);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		system = new ParticleSystem(image);
		Vector2f location = Utils.worldToScreen(object.getX(), object.getY());
		system.addEmitter(new FireEmitter((int) location.getX(), (int) location.getY()));
	}

	@Override
	public void update(int delta) {
		LOGGER.debug("Update Delta {}", delta);
		system.update(delta);
	}

	public void render() {
		system.render();
	}

}
