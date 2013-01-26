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
			String widthArg = args[0];
			String heightArg = args[1];
			
			TheGame game = new TheGame("The Game");
			
			float height = Float.parseFloat(heightArg);
			float width = Float.parseFloat(widthArg);
			
			AppGameContainer app = new AppGameContainer(game, (int)width, (int)height, true);
			Utils.setScreenDimension(width, height);
			
			app.setMinimumLogicUpdateInterval(20);
			app.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
