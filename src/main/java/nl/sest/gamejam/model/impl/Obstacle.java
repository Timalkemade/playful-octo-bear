package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Obstacle implements Physical, ImageRenderable {

	protected float x, y, radius, angle;
	protected boolean isDynamic = false;
    protected String direction;
	protected Image image;
	protected static float defaultRadius = 4;
	protected Renderer renderer;
    protected String imageFile = "images/buildings/Normal_Shadow_1.png";
    protected float imageSize = 100f;
    protected float value = 0f;

    public Obstacle() {

    }

     public void initializeObstacle(){
        renderer = new ImageRenderer(this);
        imageBuilding();
    }

    /**
     * Default image of building
     */
    public void imageBuilding(){
        int directionInt = convertDirection(direction);
        SpriteSheet sheet = null;
        try {
            sheet = new SpriteSheet(this.imageFile, (int)this.imageSize, (int)this.imageSize);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        image = sheet.getSubImage( (int)((directionInt-1)*this.imageSize), 0, (int)this.imageSize, (int)this.imageSize);
    }

    public int convertDirection(String direction){
        if(direction.compareTo("E") == 0)
            return 2;
        if(direction.compareTo("S") == 0)
            return 3;
        if(direction.compareTo("W") == 0)
            return 4;
        return 1;
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
		return angle;
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
