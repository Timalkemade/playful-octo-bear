package nl.sest.gamejam.model.obstacle.valuable;

import nl.sest.gamejam.model.impl.Valuable;
/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 2:24
 */
public class ATM extends Valuable {

    public ATM(float x, float y) {
        this.imageWidth = 45f;
        this.imageHeight = 45f;
        this.imageFile = "images/valuables/ATM.png";
        this.radius = 5;
        this.value = 0f;

        this.x = x;
        this.y = y;
        initiateValuable();
    }
}
