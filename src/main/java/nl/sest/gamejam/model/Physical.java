package nl.sest.gamejam.model;

import org.newdawn.slick.Image;

/**
 * @author Tim
 * @since 1/25/13 10:29 PM
 */
public interface Physical {

    float getX();

    void setX(float x);
    
    float getY();
    
    void setY(float y);
    
    float getAngle();
    
    void setAngle(float angle);
    
    boolean isDynamic();

    Image getImage();

    void setImage(Image anImage);
    
    void setDynamic(boolean dynamic);
}
