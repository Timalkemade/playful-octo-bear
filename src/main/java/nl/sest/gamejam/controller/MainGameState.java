package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainGameState extends BasicGameState {

	//	GameController gc;
	private GameInputController inputController;

	public MainGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		Model model = new Model();
		inputController = new GameInputController(model);
//		gc = new GameController(model);

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {

//		gc.step(arg2);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0) {
			inputController.handleLeftClick(x, y);
		}
	}
}
