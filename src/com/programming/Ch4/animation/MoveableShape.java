package com.programming.Ch4.animation;

import java.awt.*;

/**
   A shape that can be moved around.
   Information regarding this shape's 
   state is also stored, such as the direction 
   it is moving in, etc. etc.
   @author Cay horstmann, with subtle yet delicious
   touches form Christian moscardi
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
    * @return the x direction the object is/was moving in. 
    * +1 if the object is/was moving to the right. 
    * -1 if the object is/was moving to the left.
    * ONLY RETURN 0 IF YOU WANT THIS METHOD TO BE KNOWN
    * AS UNUSABLE IN YOUR SHAPE
    */
   int getXDirection();
   
}
