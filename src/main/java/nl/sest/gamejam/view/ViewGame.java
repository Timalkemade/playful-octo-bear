package nl.sest.gamejam.view;

import nl.sest.gamejam.controller.Utils;
import nl.sest.gamejam.events.*;
import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.model.impl.EventListener;
import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.view.sound.DestroyCellSound;
import nl.sest.gamejam.view.sound.DestroySound;
import nl.sest.gamejam.view.sound.MusicSound;
import nl.sest.gamejam.view.sound.SoundHeartbeat;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.Font;
import java.text.DecimalFormat;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:51
 */
public class ViewGame implements Renderer, EventListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ViewGame.class);

	private GameContainer gamecontainer = null;
	private TrueTypeFont font;

	private int widthWindow = 0;
    private int heightWindow = 0;

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

		this.widthWindow = gc.getWidth();
        this.heightWindow = gc.getHeight();

		//Set font                                    .
		Font awtFont = new Font("Times New Roman", Font.BOLD, 20);
		font = new TrueTypeFont(awtFont, false);
		MusicSound music = new MusicSound();
		music.loop();
	}

	/**
	 * Render Game view
	 */
	public void render() throws SlickException {
		//Disable Frame per Seconds
		gamecontainer.setShowFPS(false);

        backgroundSolid();
        //backgroundAnimated();
		sideBar();
		map();
		renderModel();
		topBar();
	}

    private void backgroundSolid() throws SlickException {
        Image background = new Image("images/Background_Day3b.png");
        float heightScale = Utils.getScreenHeight() / background.getHeight();
        LOGGER.debug("Screen {} / image {} = scale {}", Utils.getScreenHeight(), background.getHeight(), heightScale);
        background.draw(0, 0, heightScale*1.15f);
    }

    private void backgroundAnimated() throws SlickException {
        Animation animation = new Animation(true);
        int duration = 20;

        Image im1_us = new Image("images/background/1.png");
        float heightScale = 1.15f * Utils.getScreenHeight() / im1_us.getHeight();
        Image im1 = im1_us.getScaledCopy(heightScale);
        Image im2_us = new Image("images/background/2.png");
        Image im2 = im2_us.getScaledCopy(heightScale);
        Image im3_us = new Image("images/background/3.png");
        Image im3 = im3_us.getScaledCopy(heightScale);
        Image im4_us = new Image("images/background/4.png");
        Image im4 = im4_us.getScaledCopy(heightScale);

        animation.addFrame(im1, duration);
        animation.addFrame(im2, duration);
        animation.addFrame(im3, duration);
        animation.addFrame(im4, duration);
        animation.addFrame(im3, duration);
        animation.addFrame(im2, duration);
        animation.addFrame(im1, duration);

        animation.setLooping(true);
        animation.draw(0,0);
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
		imageCurrency.draw(halfWindow - barWidth - seperator, heightWindow-logoWidth);

		String sScore = new DecimalFormat("###,###,###,###").format(model.getCurrency());
		font.drawString(halfWindow - barWidth - seperator + logoWidth,  heightWindow-logoWidth+47, sScore);

		//Currency
		Image imageTime = new Image("images/menu/Time.png");
		imageTime.draw(halfWindow + seperator,  heightWindow-logoWidth);

		long time = System.currentTimeMillis() - model.getStartTime();
		int seconds = (int) ((time / 1000) % 60);
		int minutes = (int) ((time / 1000) / 60);
		String sMinutes = new DecimalFormat("00").format(minutes);
		String sSeconds = new DecimalFormat("00").format(seconds);
		font.drawString(halfWindow + seperator + logoWidth,  heightWindow-logoWidth+47, sMinutes + ":" + sSeconds);

        /*
		*/

//		int FPS = gamecontainer.getFPS();
//		font.drawString(widthWindow - 100, 1, "FPS: " + FPS);
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
		hb.play();
	}

	@Override
	public void onEvent(VirusKillEvent event) {
		LOGGER.debug("Virus Kill Event");
		DestroySound ds = new DestroySound();
		ds.play();
	}

	@Override
	public void onEvent(CellKillEvent event) {
		LOGGER.debug("Cell kill Event");
		DestroyCellSound sound = new DestroyCellSound();
		sound.play();
	}

	@Override
	public void onEvent(CellPassEvent event) {
		LOGGER.debug("Cell Pass Event");
	}

	@Override
	public void onEvent(VirusPassEvent event) {
		LOGGER.debug("Cell Pass Event");
	}


	@Override
	public void update(int delta) {
	}
}
