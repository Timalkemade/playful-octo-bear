package nl.sest.gamejam.view;

import nl.sest.gamejam.events.HeartbeatEvent;
import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.model.event.listener.DeletePhysicalListener;
import nl.sest.gamejam.model.impl.EventListener;
import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.view.sound.DestroySound;
import nl.sest.gamejam.view.sound.SoundHeartbeat;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:51
 */
public class ViewGame implements Renderer, EventListener, DeletePhysicalListener {

	private GameContainer gamecontainer = null;
	private TrueTypeFont font;

	private int widthWindow = 0;

	private Model model;

	/**
	 * Constructor
	 *
	 * @param gc The GameContainer object
	 */
	public ViewGame(GameContainer gc, Model theModel) {
		this.gamecontainer = gc;
		model = theModel;
		model.registerEventListener(this);
		model.registerDeletePhysicalEventListener(this);

		this.widthWindow = gc.getWidth();

		//Set font                                    .
		Font awtFont = new Font("Times New Roman", Font.BOLD, 20);
		font = new TrueTypeFont(awtFont, false);

	}

	/**
	 * Render Game view
	 */
	public void render() throws SlickException {
		//Disable Frame per Seconds
		gamecontainer.setShowFPS(false);
		Image background = new Image("images/Background_A.png");
		background.draw(0, 0);

		sideBar();
		map();
		renderModel();
		topBar();
	}

	/**
	 * Create topbar with scores and time
	 */
	private void topBar() throws SlickException {

		int halfWindow = widthWindow / 2;
		int seperator = 25;
		int barWidth = 240;
		int logoWidth = 120;
		//Currency
		Image imageCurrency = new Image("images/menu/Currency.png");
		imageCurrency.draw(halfWindow - barWidth - seperator, 0);

		String sScore = new DecimalFormat("###,###,###,###").format(model.getCurrency());
		font.drawString(halfWindow - barWidth - seperator + logoWidth, 47, sScore);

		//Currency
		Image imageTime = new Image("images/menu/Time.png");
		imageTime.draw(halfWindow + seperator, 0);

		long time = System.currentTimeMillis() - model.getStartTime();
		int seconds = (int) ((time / 1000) % 60);
		int minutes = (int) ((time / 1000) / 60);
		String sMinutes = new DecimalFormat("00").format(minutes);
		String sSeconds = new DecimalFormat("00").format(seconds);
		font.drawString(halfWindow + seperator + logoWidth, 47, sMinutes + ":" + sSeconds);

        /*
		*/

		int FPS = gamecontainer.getFPS();
		font.drawString(widthWindow - 100, 1, "FPS: " + FPS);
	}

	/**
	 * Map generator
	 */
	private void map() throws SlickException {

		for (Renderable renderable : model.getObstacles()) {
			Renderer renderer = renderable.getRenderer();
			if (renderer != null) {
				renderer.render();
			}
		}
	}

	/**
	 * Create sidebar with Twitterfeed
	 */
	private void sideBar() {
		//@Todo: Twitter feed
	}

	private void renderModel() throws SlickException {
		for (Renderable renderable : model.getRenderables()) {
			Renderer renderer = renderable.getRenderer();
			if (renderer != null) {
				renderer.render();
			}
		}

	}

	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEvent(HeartbeatEvent event) {
		SoundHeartbeat hb = new SoundHeartbeat();
		hb.render();
	}


	@Override
	public void update(int delta) {
	}


	@Override
	public void fireDeletePhysical(Physical physical) {
		DestroySound ds = new DestroySound();
		ds.render();
	}
}
