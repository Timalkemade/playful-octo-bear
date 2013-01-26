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

    private Image image;
    private Vector2f location;

    /**
     * Create view for physical object
     * @param Object
     */
    public ViewPhysical(Physical Object)
    {
        this.image = Object.getImage();
        this.location = new Vector2f(Object.getX(), Object.getY());
    }

    /**
     * Render object
     */
    public void render() {
        image.draw(location.x, location.y);
    }
}
