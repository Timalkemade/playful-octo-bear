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
    private Graphics graphics = null;
    private TrueTypeFont font;
    private float score = 5000f;
    private float time = 0f;

    private int HeightTopBar = 0;
    private int HeightWindow = 0;
    private int WidthWindow = 0;


    /**
     * Constructor
     * @param gc The GameContainer object
     * @param g  The Graphics object
     */
    public ViewGame(GameContainer gc, Graphics g){
        this.gamecontainer = gc;
        this.graphics = g;

        this.WidthWindow = gc.getWidth();
        this.HeightWindow = gc.getHeight();

        //Set font                                    .
        Font awtFont = new Font("Times New Roman", Font.BOLD, 20);
        font = new TrueTypeFont(awtFont, false);
    }

    /**
     * Render Game view
     */
    public void render() {
        //Disable Frame per Seconds
        gamecontainer.setShowFPS(false);

        TopBar();
        SideBar();
        Map();
    }

    /**
     * Create topbar with scores and time
     */
    private void TopBar(){
        try{
            Image topbar = new Image("images/topbar.jpg");
            HeightTopBar = topbar.getHeight();
            topbar.draw(0,0);
        }
        catch(SlickException se){
        }

        String sScore = new DecimalFormat("###,###,###,###").format(score);
        font.drawString(166,10, sScore, Color.black);

        /*
        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / 1000) / 60);
        graphics.drawString("Time: " + minutes + ":" + seconds, 200,1);
        */

        int FPS = gamecontainer.getFPS();
        graphics.drawString("FPS: " + FPS, 700, 1);
    }

    /**
     * Map generator
     */
    private void Map() {
        try{
            Image map = new Image("images/map.jpg");
            map.draw(0,HeightTopBar);
        }
        catch(SlickException se){
        }
    }

    /**
     * Create sidebar with Twitterfeed
     */
    private void SideBar(){
        //@Todo: Twitter feed

    }

}
