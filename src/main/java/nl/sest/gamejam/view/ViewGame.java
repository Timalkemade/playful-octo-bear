package nl.sest.gamejam.view;

import java.awt.Font;
import org.newdawn.slick.*;

import java.text.DecimalFormat;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:51
 */
public class ViewGame implements Renderer {

    private GameContainer gamecontainer = null;
    private TrueTypeFont font;
    private float score = 5000f;
    private float time = 0f;

    private int HeightTopBar = 0;
    private int HeightWindow = 0;
    private int WidthWindow = 0;


    /**
     * Constructor
	 * @param gc The GameContainer object
	 *
	 */
    public ViewGame(GameContainer gc){
        this.gamecontainer = gc;

        this.WidthWindow = gc.getWidth();
        this.HeightWindow = gc.getHeight();

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

        topBar();
        sideBar();
        map();
    }

    /**
     * Create topbar with scores and time
     */
    private void topBar() throws SlickException{
        Image topbar = new Image("images/topbar.jpg");
        HeightTopBar = topbar.getHeight();
        topbar.draw(0,0);

        String sScore = new DecimalFormat("###,###,###,###").format(score);
        font.drawString(166, 8, sScore, Color.black);

        /*
        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / 1000) / 60);
        graphics.drawString("Time: " + minutes + ":" + seconds, 200,1);
        */

        int FPS = gamecontainer.getFPS();
        font.drawString(700, 1, "FPS: " + FPS);
    }

    /**
     * Map generator
     */
    private void map() throws SlickException {
        Image map = new Image("images/map.jpg");
        map.draw(0,HeightTopBar);
    }

    /**
     * Create sidebar with Twitterfeed
     */
    private void sideBar() throws SlickException{
        //@Todo: Twitter feed

    }

}
