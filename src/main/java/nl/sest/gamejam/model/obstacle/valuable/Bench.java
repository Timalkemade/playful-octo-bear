package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:53
 */
public class Bench extends Valuable{

    public Bench(float x, float y) {
        this.imageWidth = 90f;
        this.imageHeight = 25f;
        this.imageFile = "images/valuables/Bench.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}
