package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.physics.PhysicsInterface;

import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import nl.sest.gamejam.view.DebugRenderer;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.Slick2DJBox2DDebugDraw;

public class DebugGameState extends BasicGameState {

	GameController gc;
	Model model;
	World world;
	PhysicsInterface pi;
	Renderer renderer;
	GameInputController inputController;
	
	public DebugGameState() {
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		model = new Model();
		pi = new PhysicsInterface(model);
		
		MapLoader maploader = new MapLoader();
		maploader.loadMap(model);
		
		gc = new GameController(model);
		
//		// Setup debugger
		Slick2DJBox2DDebugDraw debug = new Slick2DJBox2DDebugDraw(arg0);
		debug.appendFlags(DebugDraw.e_shapeBit);
		debug.appendFlags(DebugDraw.e_aabbBit);
		debug.setCamera(40, 40, 8);
		pi.getWorld().setDebugDraw(debug);
		pi.update();
		
		world = pi.getWorld();
		renderer = new DebugRenderer(world);
		
		inputController = new GameInputController(model);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		renderer.render();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		pi.update();
		gc.step(arg2);

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
