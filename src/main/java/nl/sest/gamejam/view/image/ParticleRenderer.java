package nl.sest.gamejam.view.image;

import nl.sest.gamejam.controller.Utils;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;
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
public class ParticleRenderer implements Renderer {

	/**
	 * The particle system running everything
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticleRenderer.class);

	private ParticleSystem system;
	private Renderable object;

	/**
	 * POI particle view
	 *
	 * @param newObject Renderable object POI
	 */
	public ParticleRenderer(ImageRenderable newObject) {
		object = newObject;

		system = new ParticleSystem(newObject.getImage());
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
