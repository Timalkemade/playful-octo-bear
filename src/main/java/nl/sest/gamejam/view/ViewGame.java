package nl.sest.gamejam.view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.text.DecimalFormat;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:51
 */
public class ViewGame implements Renderer {

    private GameContainer gamecontainer = null;
    private Graphics graphics = null;
    private float score = 0f;
    private float time = 70000f;

    /**
     * Constructor
     * @param GameContainer gc
     * @param Graphics g
     */
    public ViewGame(GameContainer gc, Graphics g){
        this.gamecontainer = gc;
        this.graphics = g;
    }

    /**
     * Render Game view
     */
    public void render() {
        //Disable Frame per Seconds
        gamecontainer.setShowFPS(false);

        TopBar();
        SideBar();
    }

    /**
     * Create topbar with scores and time
     */
    private void TopBar(){
        graphics.drawRect(0, 0, gamecontainer.getWidth(), 22);
        String sScore = new DecimalFormat("###,###,###.#").format(score);
        graphics.drawString("Score: " + sScore, 10, 1);

        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / 1000) / 60);
        graphics.drawString("Time: " + minutes + ":" + seconds, 200,1);

        int FPS = gamecontainer.getFPS();
        graphics.drawString("FPS: " + FPS, 700, 1);

    }

    /**
     * Create sidebar with Twitterfeed
     */
    private void SideBar(){
        //@Todo: Twitter feed

    }

}
