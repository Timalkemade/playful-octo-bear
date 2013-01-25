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
    float score = 0f;
    float time = 0f;

    public void ViewGame(GameContainer gc, Graphics g){
        this.gamecontainer = gc;
        this.graphics = g;
    }

    public void render() {
        TopBar();
        SideBar();
    }

    private void TopBar(){
        graphics.drawRect(0, 0, gamecontainer.getWidth(), 20);
        String sScore = new DecimalFormat("#.#").format(score);

        graphics.drawString("Score: " + sScore, 10, 10);

        int seconds = (int) ((time / 1000) % 60);
        int minutes = (int) ((time / 1000) / 60);
        graphics.drawString("Time till next heartbeat: " + minutes + ":" + seconds, 100,10);
    }

    private void SideBar(){
        //@Todo: Twitter feed

    }

}
