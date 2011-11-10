package com.programming.Ch4.animation;

import java.awt.*;
import java.awt.geom.*;
/**
 * Class specific notes: this class is a 100x100 "moveable" shape
 * which doesn't actually move anywhere in my test code! If you 
 * wanted to, it would take like 5 seconds to add an actual 'direction'
 * method and whatnot
 *  * @author Christian
 *
 */
public class BoxOfDestruction implements MoveableShape{
	private int x;
	private int y;
	private static final int BOX_WIDTH = 100;
	private static final int BOX_HEIGHT = 100;
	private final Rectangle2D.Double BOX_OF_DOOM;
	public BoxOfDestruction(int x, int y){
		this.x = x;
		this.y = y;
		BOX_OF_DOOM = new Rectangle2D.Double(x,y,BOX_WIDTH,BOX_HEIGHT);
	}
	
	/**
	 * This draws the box
	 */
	public void draw(Graphics2D g2){
		 g2.draw(BOX_OF_DOOM);
	}
	
	/**
	 * @see MoveableShape
	 */
	public void translate(int dx, int dy){
		x+=dx;
		y+=dy;
	}
	
	/**
	 * @see MoveableShape
	 */
	public int getLeftXCoordinate(){
		return x;
	}
	
	/**
	 * @see MoveableShape
	 */
	public int getRightXCoordinate(){
		return x+BOX_WIDTH;
	}
	
	/**
	 * Class specific: Do not use!
	 * This will return 0 
	 */
	public int getXDirection(){
		return 0; //the box never moves
	}
}
