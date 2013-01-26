package nl.sest.gamejam.controller;

import nl.sest.gamejam.view.SoundHeartbeat;
import nl.sest.gamejam.view.ViewGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        ViewGame vg = new ViewGame(gc,g);
        vg.render();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
