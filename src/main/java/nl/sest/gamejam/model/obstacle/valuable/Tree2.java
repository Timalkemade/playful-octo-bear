package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:55
 */
public class Tree2 extends Valuable {

    public Tree2(float x, float y) {
        this.imageWidth = 45f;
        this.imageHeight = 45f;
        this.imageFile = "images/valuables/Tree_2.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}

