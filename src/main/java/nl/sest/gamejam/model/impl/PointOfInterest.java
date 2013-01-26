package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Force;

import java.util.UUID;

/**
 * A point of interest is a shiny, cool or otherwise attractive point which attracts a Bob.
 *
 * @author Tim
 * @since 1/25/13 10:03 PM
 */
public class PointOfInterest implements Force {

    private final UUID id;
    private float x;
    private float y;


    /**
     * Constructor for a point of interest.
     *
     * @param x The x location of this PointOfInterest
     * @param y The y location of this PointOfInternet
     */
    public PointOfInterest(float x, float y) {
        id = UUID.randomUUID();
        this.x = x;
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object other) {
        return this == other
                || (other != null
                && getClass() == other.getClass()
                && id.equals(((PointOfInterest) other).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
