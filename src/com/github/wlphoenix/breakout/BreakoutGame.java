package com.github.wlphoenix.breakout;

import static com.github.wlphoenix.breakout.utils.PrintUtilities.logPrintln;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.github.wlphoenix.breakout.model.Ball;
import com.github.wlphoenix.breakout.model.Block;
import com.github.wlphoenix.breakout.model.Bumper;

public class BreakoutGame extends BasicGame {
	
	Image background;
	Bumper bumper;
	Ball ball;
	Block[] blocks;
	float ballOffsetX;
	float ballOffsetY;
	
	Map<String, Image> images;

	public BreakoutGame() {
		super("Let's play breakout.");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new BreakoutGame());
		app.setDisplayMode(600, 800, false);
		app.start();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		logPrintln("START - init");
		
		try {
			container.setVSync(true);

			loadImages();
			buildModel();
			
		} catch (SlickException se) {
			throw new SlickException ("Error in initilization: " + se);
		} catch (Exception e) {
			
		}
		
		logPrintln("END - init");
	}
	
	private void loadImages() throws SlickException{
		images = new HashMap<String, Image>();
		images.put("background", new Image("/resources/img/background-600-800.png"));
		images.put("redBlock", new Image("/resources/img/block-red-32-16.png"));
		images.put("blueBlock", new Image("/resources/img/block-blue-32-16.png"));
		images.put("greenBlock", new Image("/resources/img/block-green-32-16.png"));
		images.put("yellowBlock", new Image("/resources/img/block-yellow-32-16.png"));
		images.put("bumper", new Image("/resources/img/bumper-full.png"));
		images.put("ball", new Image("/resources/img/ball-16.png"));
		
	}
	
	private void buildModel() throws SlickException
	{
		background = images.get("background");
		bumper = new Bumper(images.get("bumper"));
		ball = new Ball(images.get("ball"));
		
		ballOffsetX = (bumper.getWidth()/2) + (ball.getWidth()/2);
		ballOffsetY = ball.getHeight();
		if(bumper.isBallConnected()){
			ball.setPosition(bumper.getX() + ballOffsetX , bumper.getY() - ballOffsetY);
			ball.setDirection(new Vector2f(0,0));
		}
		buildBlockArray();
	}
	
	private void buildBlockArray() throws SlickException
	{
		blocks = new Block[24];
		int x = 0;
		int y = 0;
		for (int i = 0; i < blocks.length; i++) {
			blocks[i] = new Block(x + 172, y + 64, images.get("redBlock"));
			x = (x + 32) % 256;
			if(x==0)
				y += 32;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		background.draw(0,0);
		ball.getImage().draw(ball.getX(), ball.getY());
		bumper.getImage().draw(bumper.getX(), bumper.getY());
		for(Block b : blocks) {
			if(!b.isCleared())
				b.getImage().draw(b.getX(), b.getY());
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		Input input = container.getInput();
		
		if(bumper.isBallConnected()){
			ball.setPosition(bumper.getX() + ballOffsetX , bumper.getY() - ballOffsetY);
		} else {
			Vector2f ballDir = ball.getDirection();
			ball.setX(ball.getX() + ballDir.x);
			ball.setY(ball.getY() + ballDir.y);
		}
		
		if (input.isKeyDown(Input.KEY_LEFT) && input.isKeyDown(Input.KEY_RIGHT)) {
		} else if (input.isKeyDown(Input.KEY_LEFT)) {
			bumper.setDirection(new Vector2f(-6.0f, 0));			
		} else if (input.isKeyDown(Input.KEY_RIGHT)) { 
			bumper.setDirection(new Vector2f(6.0f, 0));
		}
		
		bumper.updatePosition();
		
		if (input.isKeyDown(Input.KEY_SPACE)) {
			if(bumper.isBallConnected()) {
				bumper.disconnect();
				ball.setDirection(new Vector2f(2.5f, -2.5f));
				
			}
		}
	}
}
