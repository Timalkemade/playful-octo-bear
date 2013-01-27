package nl.sest.gamejam.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Tim
 * @since 1/27/13 12:47 PM
 */
public class MenuGameState extends BasicGameState implements ComponentListener {

	private Image image;
	private MouseOverArea startButton;
	private MouseOverArea endButton;
	private MouseOverArea wtfButton;

	private boolean started = false;
	private boolean quit = false;
	private boolean wtf = false;

	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		super.enter(container, game);
		started = false;
		quit = false;
		wtf = false;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		image = new Image("images/menu/Menu_A.png").getScaledCopy(container.getWidth(), container.getHeight());
		Image startButtonImage = new Image("images/menu/Menu_Button_Play.png");
		Image endButtonImage = new Image("images/menu/Menu_Button_Stop.png");
		Image wtfButtonImage = new Image("images/menu/Menu_Button_Wtf.png");

		startButton = new MouseOverArea(container, startButtonImage, 350, 300, this);
		endButton = new MouseOverArea(container, endButtonImage, 350, 400, this);
		wtfButton = new MouseOverArea(container, wtfButtonImage, 350, 500, this);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		image.draw();
		startButton.render(container, g);
		endButton.render(container, g);
		wtfButton.render(container, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (started) {
			game.enterState(2);
		} else if (quit) {
			container.exit();
		} else if (wtf) {
			game.enterState(4);
		}

	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if (source == startButton) {
			started = true;
		} else if (source == endButton) {
			quit = true;
		} else if (source == wtfButton) {
			wtf = true;
		}
	}
}
