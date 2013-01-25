package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;

/**
 * @author Tim
 * @since 1/25/13 9:40 PM
 */
public class Bob implements Physical, Renderable {

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public Renderer getRenderer() {
        return null;
    }
}
