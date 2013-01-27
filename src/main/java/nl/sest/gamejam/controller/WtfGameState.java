package nl.sest.gamejam.controller;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

/**
 * @author Tim
 * @since 1/27/13 1:57 PM
 */
public class WtfGameState extends BasicGameState {

	private Image image;

	@Override
	public int getID() {
		return 4;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		image = new Image("images/credits2013_new.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		image.draw();
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			game.enterState(1, new EmptyTransition(), new FadeInTransition());
		}
	}
}
