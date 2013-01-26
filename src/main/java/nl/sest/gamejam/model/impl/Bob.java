package nl.sest.gamejam.model.impl;

import org.newdawn.slick.geom.Vector2f;

import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.ViewObject;

import java.util.UUID;

/**
 * A bob is a simple-minded drooling thingy which will follow any shiny thing he sees.
 *
 * @author Tim
 * @since 1/25/13 9:40 PM
 */
public class Bob implements Physical, Renderable {

    private final UUID id = UUID.randomUUID();
    private Renderer renderer;
    private float x;
    private float y;
    private float angle;
    private boolean isDynamic;

    public Bob(float x, float y) {
    	this(null, x, y);
    	renderer = createDefaultRenderer();
    }
    
    /**
     * TODO Not correctly implemented yet
     * @return
     */
    public Renderer createDefaultRenderer() {
    	return new ViewObject(null, new Vector2f());
    }
    
    public Bob(Renderer aRenderer, float x, float y) {
        this.renderer = aRenderer;
        this.x = x;
        this.y = y;
        angle = 0;
        isDynamic = true;

    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float newX) {
        this.x = newX;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float newY) {
        y = newY;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float newAngle) {
        this.angle = newAngle;
    }

    @Override
    public boolean isDynamic() {
        return isDynamic;
    }

    @Override
    public void setDynamic(boolean dynamic) {
        this.isDynamic = dynamic;
    }

    @Override
    public Renderer getRenderer() {
        return renderer;
    }

    public UUID getId() {
        return id;
    }


    @Override
    public boolean equals(Object other) {
        return this == other
                || (other != null
                && getClass() == other.getClass()
                && id.equals(((Bob) other).id));
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

	@Override
	public float getRadius() {
		return 0;
	}

	@Override
	public void setRadius(float radius) {
	}

}
