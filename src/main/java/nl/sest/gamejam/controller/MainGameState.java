package nl.sest.gamejam.controller;

import java.util.List;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.physics.PhysicsInterface;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.Slick2DJBox2DDebugDraw;
import nl.sest.gamejam.view.ViewGame;

public class MainGameState extends BasicGameState {

//	GameController gc;
	Model model;
	World world;
	Renderer renderer;
	GameInputController inputController;
	
	public MainGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		model = new Model();
		PhysicsInterface pi = new PhysicsInterface(model);
		world = pi.getWorld();
		
		MapLoader maploader = new MapLoader();
		maploader.loadMap(model);
		
//		gc = new GameController(model);
		renderer = new ViewGame(arg0, arg0.getGraphics());

	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		renderer.render();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		world.step(arg2, 8, 3);
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
