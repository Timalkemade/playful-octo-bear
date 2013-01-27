package nl.sest.gamejam.model.obstacle.building;

import nl.sest.gamejam.model.impl.Obstacle;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 1:38
 */
public class NormalBuilding extends Obstacle {

    protected String imageFile = "images/buildings/Normal_Shadow_1.png";
    protected float imageSize = 100f;
    protected float radius = 4;
    protected float value = 0f;

    public NormalBuilding(float x, float y, String direction) {
        imageFile = "images/buildings/Normal_Shadow_1.png";
        imageSize = 100f;
        radius = 4;
        value = 0f;

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.initializeObstacle();
    }

    @Override
    public void imageBuilding(){
        int directionInt = convertDirection(direction);
        SpriteSheet sheet = null;
        try {
            sheet = new SpriteSheet("images/buildings/Normal_Shadow_" + directionInt + ".png", (int)imageSize, (int)imageSize);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        int random = (int)(Math.random() * 8);

        image = sheet.getSubImage(random % 2, random % 4, (int)imageSize, (int)imageSize);
    }
}
