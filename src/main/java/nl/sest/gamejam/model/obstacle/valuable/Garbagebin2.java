package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:54
 */
public class Garbagebin2 extends Valuable {

    public Garbagebin2(float x, float y) {
        this.imageWidth = 25f;
        this.imageHeight = 25f;
        this.imageFile = "images/valuables/Garbagebin_B.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}
