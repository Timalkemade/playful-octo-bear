package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.physics.PhysicsInterface;
import nl.sest.gamejam.view.DebugRenderer;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.Slick2DJBox2DDebugDraw;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DebugGameState extends MainGameState {



	public DebugGameState() {
		super();
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		model = new Model();
		pi = new PhysicsInterface(model);

		inputController = new GameInputController(model);

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
	public int getID() {
		return 0;
	}
}
