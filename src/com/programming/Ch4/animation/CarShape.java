package com.programming.Ch4.animation;

import java.awt.*;
import java.awt.geom.*;


/**
   A car that can be moved around.
*/
public class CarShape implements MoveableShape
{
   /**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public CarShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      unit=width/6;
     
   }

   public void translate(int dx, int dy)
   {
	  if(dx<0){
		  direction=-1;
	  }
	  if(dx>0){
		  direction=+1;
	  }
	  if(dx==0){
		  direction =0;
	  }
      x += dx;
      y += dy;
   }
   
   /**
    * Horstmann's magic code
    * @param g2 i don't really know
    */
   public void draw2(Graphics2D g2)
   {
      Rectangle2D.Double body
            = new Rectangle2D.Double(x, y + width / 6, 
                  width - 1, width / 6);
      Ellipse2D.Double frontTire
            = new Ellipse2D.Double(x + width / 6, y + width / 3, 
                  width/6 , width/6 );
      Ellipse2D.Double rearTire
            = new Ellipse2D.Double(x + width * 2 / 3, y + width / 3,
                  width/6 , width/6 );

      // The bottom of the front windshield
      Point2D.Double r1
            = new Point2D.Double(x + width / 6, y + width / 6);
      // The front of the roof
      Point2D.Double r2
            = new Point2D.Double(x + width / 3, y);
      // The rear of the roof
      Point2D.Double r3
            = new Point2D.Double(x + width * 2 / 3, y);
      // The bottom of the rear windshield
      Point2D.Double r4
            = new Point2D.Double(x + width * 5 / 6, y + width / 6);
      Line2D.Double frontWindshield
            = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
            = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
            = new Line2D.Double(r3, r4);
      
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }
   
   /**
    * I don't even know what's going on in kender's magic diagram
    * thing. so i'm just gonna do it my way
    * @param g2
    */
   public void draw(Graphics2D g2){
	   //DRAW A PICTURE
	   //X axis
	   int bodyLeft=x;
	   //the left side of the left window
	   int leftWindow = x + unit;
	   //the right side of the left window == the left side of the roof
	   int  roofLeft = leftWindow+unit;
	   //the right side of the roof == the left side of the right window
	   int roofRight = roofLeft+2*unit;
	   //the right side of the right window
	   int rightWindow= roofRight+unit;
	   //
	   //onto wheels 
	   //left side of left wheel
	   int leftWheelLeft = leftWindow;
	   //left side of right wheel -- unit compensates
	   //since we're on the left side now
	   int rightWheelLeft = roofRight;
	   
	   //Y axis
	   int roofTop=y;
	   //the top of the body 
	   //== the bottom of the roof window thigny
	   int bodyTop = y+unit;
	   //the bottom of the body 
	   //== the top of the wheel
	   int wheelTop = bodyTop+unit;
	   int wheelDiameter = unit;
	   
	   
	   //LET'S DRAW SOME COOL STUFF!
	   //the body
	   Rectangle2D.Double body
	   	= new Rectangle2D.Double(bodyLeft, bodyTop, width , unit);
	   
	   //the wheels
	   Ellipse2D.Double frontTire
       	= new Ellipse2D.Double(leftWheelLeft,wheelTop,wheelDiameter,wheelDiameter );
	   Ellipse2D.Double rearTire
       	= new Ellipse2D.Double(rightWheelLeft,wheelTop,wheelDiameter,wheelDiameter);
	   
	   //the ugly-ass roof thing
	   Point2D.Double leftWindowBasePoint= new Point2D.Double(leftWindow,bodyTop);
	   
	   //moving left to right in the picture
	   Point2D.Double roofLeftPoint= new Point2D.Double(roofLeft,roofTop);
	   
	   //the right side of roof
	   Point2D.Double roofRightPoint= new Point2D.Double(roofRight,roofTop);
	   
	   //finally
	   Point2D.Double rightWindowBasePoint = new Point2D.Double(rightWindow,bodyTop);
	   
	   //now turn these into lines
	   Line2D.Double leftWindowLine = new Line2D.Double(leftWindowBasePoint, roofLeftPoint);
	   
	   Line2D.Double roofLine = new Line2D.Double(roofLeftPoint,roofRightPoint);
	   
	   Line2D.Double rightWindowLine = new Line2D.Double(roofRightPoint,rightWindowBasePoint);
	   
	   //AND ACTUALLY DRAWING
	   g2.draw(body);
	   
	   g2.draw(frontTire);
	   g2.draw(rearTire);
	   
	   g2.draw(leftWindowLine);
	   g2.draw(roofLine);
	   g2.draw(rightWindowLine);
   }
   
   public int getLeftXCoordinate(){
	   return x;
   }
   public int getRightXCoordinate(){
	   return x+width; //this is straightforward enough
   }
   public int getXDirection(){
	   return direction;
   }
   
   private int x;
   private int y;
   private int width;
   private int direction;
   
   private final int unit;
}
