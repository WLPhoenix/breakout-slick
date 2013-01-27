package com.github.wlphoenix.breakout.model;

import org.newdawn.slick.Image;

public class Block {

	boolean cleared;
	final float X, Y;
	public static final float WIDTH = 32;
	public static final float HEIGHT = 16;
	
	final Image image;
	
	public Block(float xPos, float yPos, Image image) {
		this.X = xPos;
		this.Y = yPos;
		this.image = image;
		cleared = false;
	}
	
	public boolean isCleared() {
		return cleared;
	}
	
	public void setCleared() {
		cleared = true;
	}
	
	public float getX() {
		return X;
	}
	
	public float getY() {
		return Y;
	}
	
	public Image getImage() {
		return image;
	}
}
