package nl.sest.gamejam.controller;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public Main() {
	}

	/**
	 * @param args
	 * @throws SlickException
	 */
	public static void main(String[] args) throws SlickException {

		try {

			TheGame game = new TheGame("The Game");

			float height;
			float width;

			height = 768;
			width = 1024;

			AppGameContainer app = new AppGameContainer(game, (int) width, (int) height, false);
			Utils.initialize(width, height);

			app.setMinimumLogicUpdateInterval(20);
			app.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
