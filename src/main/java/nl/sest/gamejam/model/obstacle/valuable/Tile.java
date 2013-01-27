package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:55
 */
public class Tile extends Valuable {

    public Tile(float x, float y) {
        this.imageWidth = 35f;
        this.imageHeight = 35f;
        this.imageFile = "images/valuables/Tile.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}