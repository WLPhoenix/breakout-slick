package com.github.wlphoenix.breakout.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Bumper {
	
	private float xPos, yPos;
	private final float WIDTH = 32;
	private Vector2f direction;
	boolean isBallConnected;
	
	Image image;
	
	public Bumper(Image image){
		this.image = image;
		xPos = 100;
		yPos = 700;
		isBallConnected = true;
		direction = new Vector2f(0,0);
	}

	public boolean isBallConnected()
	{
		return isBallConnected;
	}
	
	public void disconnect() {
		isBallConnected = false;
	}
	
	public void setPosition(float xPos, float yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void setX(float xPos) {
		this.xPos = xPos;
	}
	
	public void setY(float yPos) {
		this.yPos = yPos;
	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public float getWidth() {
		return WIDTH;
	}
	
	public void setDirection (Vector2f dir) {
		this.direction = dir;
	}
	
	public Vector2f getDirection() {
		return direction;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void updatePosition() {
		xPos += direction.x;
		if(direction.x > .01) 
			direction.x *= 0.6;
		else
			direction.x = 0;
	}
}
