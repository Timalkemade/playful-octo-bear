package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.image.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Obstacle implements Physical, ImageRenderable {

	protected float x, y, radius, angle;
	protected boolean isDynamic = false;
    protected String direction;
	protected Image image;
	protected static float defaultRadius = 4f;
	protected Renderer renderer;
    protected String imageFile = "images/buildings/Normal/A/Building_Normal_1_Shadow_A.png";
    protected float imageSize = 100f;
    protected float value = 0f;

    public Obstacle() {

    }

     public void initializeObstacle(){
        imageBuilding();
        renderer = new ImageRenderer(this);
    }

    /**
     * Default image of building
     */
    public void imageBuilding(){
        try {
            image = new Image(this.imageFile + "Building_" + direction + ".png");
        } catch (SlickException e) {
        }
    }

	@Override
	public float getX() {
		return x;
	}

	@Override
	public void setX(float x) {
		this.x = x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public float getAngle() {
		return angle+45;
	}

	@Override
	public void setAngle(float angle) {
		this.angle = angle;
	}

	@Override
	public boolean isDynamic() {
		return isDynamic;
	}

	@Override
	public Image getImage() {
		return image;
	}

	@Override
	public void setDynamic(boolean dynamic) {
		this.isDynamic = dynamic;
	}

	@Override
	public float getRadius() {
		return radius;
	}

	@Override
	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public Renderer getRenderer() {
		return renderer;
	}
}
