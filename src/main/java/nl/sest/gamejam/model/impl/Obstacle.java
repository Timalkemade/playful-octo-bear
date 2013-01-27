package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.model.ImageRenderable;
import nl.sest.gamejam.model.Physical;
import nl.sest.gamejam.view.ImageRenderer;
import nl.sest.gamejam.view.Renderer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Obstacle implements Physical, ImageRenderable {

	private float x, y, radius, angle;
	private boolean isDynamic = false;
	private Image image;
	private static float defaultRadius = 4;
	private Renderer renderer;

	/**
	 * Create an Obstacle of a certain size
	 *
	 * @param x
	 * @param y
	 * @param size 1 for default size, 2 for 4x size, 3 for 16x size
	 */
	public Obstacle(float x, float y, String building, String direction, int size) {
        this.x = x;
        this.y = y;
        initializeObstacle();
        imageBuilding(building, direction);
	}

	public Obstacle(float x, float y, String building, String direction) {
		this.x = x;
		this.y = y;
        initializeObstacle();
        imageBuilding(building, direction);
	}

    private void initializeObstacle(){
        renderer = new ImageRenderer(this);
        setRadius(defaultRadius);
    }

    private void imageBuilding(String building, String direction){
        int directionInt = convertDirection(direction);
        if(building.compareTo("Normal") == 0)
        {
            //Normal home
            SpriteSheet sheet = null;
            try {
                sheet = new SpriteSheet("images/buildings/Normal_Shadow_" + directionInt + ".png", 100, 100);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            int random = (int)(Math.random() * 8);

            image = sheet.getSubImage(random % 2, random % 4, 100, 100);
        }
        else{
            //Valuable
            SpriteSheet sheet = null;
            try {
                sheet = new SpriteSheet("images/buildings/" + building + ".png", 150, 150);
            } catch (SlickException e) {
                e.printStackTrace();
            }
            image = sheet.getSubImage( (directionInt-1)*150, 0, 150, 150);
        }
    }
    private int convertDirection(String direction){
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
