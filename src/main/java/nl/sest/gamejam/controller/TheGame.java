package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.event.listener.EndGameListener;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TheGame extends StateBasedGame implements EndGameListener {

	public TheGame(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainGameState());
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		getCurrentState().render(gc, this, g);
	}

	@Override
	public void endGame() {
				
	}

}
