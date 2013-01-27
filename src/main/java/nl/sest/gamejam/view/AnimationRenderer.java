package nl.sest.gamejam.view;

import nl.sest.gamejam.controller.Utils;
import nl.sest.gamejam.model.AnimationRenderable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 10:53
 */
public class AnimationRenderer implements Renderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageRenderer.class);

    private AnimationRenderable object;
    private Animation animation;

    /**
     * Create view for physical object
     *
     * @param newObject Physical object
     */
    public AnimationRenderer(AnimationRenderable newObject) {
        object = newObject;
        animation = object.getAnimation();
    }

    /**
     * Render object
     */
    public void render() {
        //LOGGER.debug("original Location {}, {}", object.getX(), object.getY());
        Vector2f location = Utils.worldToScreen(object.getX(), object.getY());
        float drawLocationX = location.getX() - animation.getWidth()/2;
        float drawLocationY = location.getY() - animation.getHeight()/2;
        //LOGGER.debug("location {}", location);
        animation.draw(drawLocationX, drawLocationY);
    }

    @Override
    public void update(int delta) {
    }
}
