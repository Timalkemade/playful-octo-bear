package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImagePicker;
import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;

/**
 * A bob is a simple-minded drooling thingy which will follow any shiny thing he sees.
 *
 * @author Tim
 * @since 1/25/13 9:40 PM
 */
public class Bob implements Physical, ImageRenderable {

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
        initializeBob();
    }
    
    public Bob(Renderer aRenderer, float x, float y) {
        this.renderer = aRenderer;
        this.x = x;
        this.y = y;
        initializeBob();
    }

    private void initializeBob()
    {
        setRadius(1);
        angle = 0;
        isDynamic = true;
        //PickImage
        ImagePicker im = new ImagePicker();
        this.image = im.pick("bobs");
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
    	return new ImageRenderer(this);
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

    @Override
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
