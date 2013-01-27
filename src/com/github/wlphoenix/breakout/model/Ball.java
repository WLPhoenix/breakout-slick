package com.github.wlphoenix.breakout.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Ball {
	
	float xPos, yPos;
	public final float WIDTH = 16;
	public final float HEIGHT = 16;
	Vector2f direction;
	
	Image image;
	
	public Ball(Image image) {
		this.image = image;
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
	
	public float getHeight() {
		return HEIGHT;
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
}
