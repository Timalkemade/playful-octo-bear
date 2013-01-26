package nl.sest.gamejam.view;

import org.jbox2d.dynamics.World;
import org.newdawn.slick.SlickException;

public class DebugRenderer implements Renderer {

	private World world;
	
	public DebugRenderer(World world) {
		this.world = world;
	}

	@Override
	public void render() throws SlickException {
		int b = world.getBodyCount();
		world.drawDebugData();
	}

    @Override
    public void update(int delta){ }

}
