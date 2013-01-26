package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.model.Renderable;
import nl.sest.gamejam.view.Renderer;
import nl.sest.gamejam.view.ViewPhysical;
import org.newdawn.slick.Image;

/**
 * A bob is a simple-minded drooling thingy which will follow any shiny thing he sees.
 *
 * @author Tim
 * @since 1/25/13 9:40 PM
 */
public class Bob implements Physical, Renderable {

	private Renderer renderer;
	private float x;
	private float y;
	private float radius;
	private Image image;
	private float angle;
	private boolean isDynamic;
	protected PointOfInterest poi;
    
    public Bob(float x, float y) {
    	this(null, x, y);
    	renderer = createDefaultRenderer();
    	setRadius(1);
    }
    
    public Bob(Renderer aRenderer, float x, float y) {
        this.renderer = aRenderer;
        this.x = x;
        this.y = y;
        angle = 0;
        isDynamic = true;
    }
    
    public void setPOI(PointOfInterest poi) {
    	this.poi = poi;
    }
    
    public PointOfInterest getPOI() {
    	return poi;
    }
    
    /**
     * @return
     */
    public Renderer createDefaultRenderer() {
    	return new ViewPhysical(this);
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
	public Image getImage() {
		return image;
	}

	@Override
	public void setImage(Image anImage) {
		this.image = anImage;
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}

	@Override
	public float getRadius() {
		return radius;
	}

	@Override
	public void setRadius(float radius) {
		this.radius = radius;
	}

}
