package nl.sest.gamejam.controller;

import nl.sest.gamejam.model.impl.Model;
import nl.sest.gamejam.model.impl.PointOfInterest;

/**
 * Controller which handles user input.
 *
 * @author Tim
 * @since 1/26/13 8:19 AM
 */
public class GameInputController {

    private Model model;

    public GameInputController(Model model) {
        this.model = model;
    }

    public void handleLeftClick(float x, float y) {
        PointOfInterest pointOfInterest = new PointOfInterest(x, y);
        model.addPointOfInterest(pointOfInterest);
    }
}
