package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.physics.PhysicsInterface;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.ViewGame;
import org.jbox2d.dynamics.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainGameState extends BasicGameState {

	private final static Logger LOGGER = LoggerFactory.getLogger(MainGameState.class);

	protected GameController gc;
	protected Model model;
	protected World world;
	protected Renderer renderer;
	protected GameInputController inputController;
	protected PhysicsInterface pi;

	public MainGameState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {

		model = new Model();
		model.setStartTime(System.currentTimeMillis());
		Utils.setModel(model);

		pi = new PhysicsInterface(model);

		inputController = new GameInputController(model);

		gc = new GameController(model);
		pi.registerPhysicsCollisionListener(gc);
		
		MapLoader maploader = new MapLoader();
		maploader.loadMap(model);
		
		pi.update();

		renderer = new ViewGame(arg0, model);

		world = pi.getWorld();
		inputController = new GameInputController(model);
		gc.start();

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
		return 0;
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		inputController.handleMousePressed(x, y);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		inputController.handleForceReleased(x, y);
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		inputController.handleForceDragged(newx, newy);
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException {
		super.leave(container, game);
		Utils.setModel(null);
	}
}
