package nl.sest.gamejam.view;

import nl.sest.gamejam.model.Physical;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * User: JMIEGHEM
 * Date: 26-1-13
 * Time: 11:40
 */
public class ViewPhysical implements Renderer {

    private Physical object;

    /**
     * Create view for physical object
     * @param newObject Physical object
     */
    public ViewPhysical(Physical newObject)
    {
        object = newObject;
    }

    /**
     * Render object
     */
    public void render() {
        Image image = object.getImage();
        Vector2f location = new Vector2f(object.getX(), object.getY());
        image.draw(location.x, location.y);
    }
}
