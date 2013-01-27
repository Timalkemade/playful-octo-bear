package nl.sest.gamejam.model.obstacle.building;

import nl.sest.gamejam.model.impl.Obstacle;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 1:38
 */
public class Jewelry extends Obstacle {

    public Jewelry(float x, float y, String direction) {
        this.imageSize = 150f;
        this.imageFile = "images/buildings/Jewelry/";
        this.radius = 10f;
        this.value = 0f;

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.initializeObstacle();
    }
}
