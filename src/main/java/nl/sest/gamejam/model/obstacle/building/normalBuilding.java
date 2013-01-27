package nl.sest.gamejam.model.obstacle.building;

import nl.sest.gamejam.model.ImagePicker;
import nl.sest.gamejam.model.impl.Obstacle;

/**
 * User: JMIEGHEM
 * Date: 27-1-13
 * Time: 1:38
 */
public class NormalBuilding extends Obstacle {

    public NormalBuilding(float x, float y, String direction) {
        imageFile = "buildings/Normal/"+direction+"/";
        imageSize = 100f;
        radius = 7f;
        value = 0f;

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.initializeObstacle();
    }

    @Override
    public void imageBuilding(){
        //PickImage
        ImagePicker im = new ImagePicker();
        image = im.pick(imageFile);
    }
}
