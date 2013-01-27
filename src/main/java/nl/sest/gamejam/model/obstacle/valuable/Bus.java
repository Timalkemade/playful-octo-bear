package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:54
 */
public class Bus extends Valuable {

    public Bus(float x, float y) {
        this.imageWidth = 100f;
        this.imageHeight = 45f;
        this.imageFile = "images/valuables/Bus.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}

