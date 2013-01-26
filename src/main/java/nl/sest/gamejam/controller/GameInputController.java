package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.model.player.PlayerAttractor;
import nl.sest.gamejam.model.player.PlayerRepulsor;
import org.newdawn.slick.geom.Vector2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Controller which handles user input.
 *
 * @author Tim
 * @since 1/26/13 8:19 AM
 */
public class GameInputController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameInputController.class);

	private Model model;

	public GameInputController(Model model) {
		this.model = model;
	}

	public void handleLeftClick(float x, float y) {
		LOGGER.debug("Left click at: [{}, {}]", x, y);

		Vector2f converted = Utils.screenToWorld(model, x, y);
		PlayerAttractor playerAttractor = new PlayerAttractor(converted.x, converted.y);
		model.addPlayerAttractor(playerAttractor);
	}

	public void handleRightClick(float x, float y) {
		LOGGER.debug("Right click at [{}, {}]", x, y);

		Vector2f converted = Utils.screenToWorld(model, x, y);
		PlayerRepulsor playerRepulsor = new PlayerRepulsor(converted.x, converted.y);
		model.addPlayerRepulsor(playerRepulsor);
	}
}
