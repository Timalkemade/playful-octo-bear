package nl.sest.gamejam.view;

import org.newdawn.slick.SlickException;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:34
 * Main Renderer
 */
public interface Renderer {

    void render() throws SlickException;

    void update(int dt);
}
