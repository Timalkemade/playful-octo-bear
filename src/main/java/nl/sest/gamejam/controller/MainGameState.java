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

		MapLoader maploader = new MapLoader();
		maploader.loadMap(model);

		gc = new GameController(model);
		pi.update();

		renderer = new ViewGame(arg0, model);

		world = pi.getWorld();
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
		return 0;
	}


	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		if (button == 0) {
			inputController.handleLeftClick(x, y);
		} else if (button == 1) {
			inputController.handleRightClick(x, y);
		}
	}


	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		inputController.handleMouseDrag(oldx, oldy, newx, newy);
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		inputController.handleMouseUp(x, y);
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) throws SlickException {
		super.leave(container, game);
		Utils.setModel(null);
	}
}
