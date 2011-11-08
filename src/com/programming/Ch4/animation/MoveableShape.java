package com.programming.Ch4.animation;

import java.awt.*;

/**
   A shape that can be moved around.
   Information regarding this shape's 
   State is also stored, such as the direction 
   it is moving in, etc. etc.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
   void translate(int dx, int dy);
   
   /**
    * 
    * @return the leftmost x coordinate of the object
    */
   int getLeftXCoordinate();
   /**
    * 
    * @return the rightmost x coordinate of the object
    */
   int getRightXCoordinate();
   
   /**
    * 
    * @return the x direction the object is moving in
    */
   int getXDirection();
   
}
