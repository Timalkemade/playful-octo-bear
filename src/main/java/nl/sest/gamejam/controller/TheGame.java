package nl.sest.gamejam.controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TheGame extends StateBasedGame {

	public TheGame(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new MainGameState());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
