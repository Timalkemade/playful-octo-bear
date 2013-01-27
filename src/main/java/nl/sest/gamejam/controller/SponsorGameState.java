package nl.sest.gamejam.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;

/**
 * @author Tim
 * @since 1/27/13 12:40 PM
 */
public class SponsorGameState extends BasicGameState {

	private Image image;
	boolean isRendered;

	@Override
	public int getID() {
		return 0;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		image = new Image("images/credits2013_new.png").getScaledCopy(0.7f);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		image.draw();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException("Interrupted");
		}
		isRendered = true;
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (isRendered) {
			game.enterState(1, new EmptyTransition(), new FadeInTransition());
		}
	}
}
