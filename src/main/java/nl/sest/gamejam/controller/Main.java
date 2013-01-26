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
		
		try{
			TheGame game = new TheGame("The Game");
			AppGameContainer app = new AppGameContainer(game, 800, 800, false);
		
			app.setMinimumLogicUpdateInterval(20);
			app.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
