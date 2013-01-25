package nl.sest.gamejam.view;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * User: JMIEGHEM
 * Date: 25-1-13
 * Time: 22:46
 */
public class ViewObject implements Renderer {

    private Image image;
    private Vector2f location;

    public ViewObject(Image anImage, Vector2f aLocation) {
        this.image = anImage;
        this.location = aLocation;
    }

    public void render() {
        image.draw(location.x, location.y);
    }
}
