package nl.tim.test;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * @author Tim
 * @since 23-1-13
 */
public class ImageGameObject extends AbstractGameObject {

    private Image image;

    public ImageGameObject(Image anImage, Vector2f aLocation) {
        super(aLocation);
        image = anImage;
    }

    @Override
    public void render() {
        image.draw(getLocation().x, getLocation().y);
    }
}
