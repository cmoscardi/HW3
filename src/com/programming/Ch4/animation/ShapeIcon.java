package com.programming.Ch4.animation;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

/**
   An icon that contains MoveableShapes.
   It also can check to see if two shapes
   residing within its space have collided
*/
public class ShapeIcon implements Icon
{
	/**
	 * Constructs an Icon which 
	 * contains the moveable shape
	 * @param shape the MoveableShape this Icon will contain
	 * @param width the width of the full container irrespective
	 * of the shape's size
	 * @param height the height of the full container irrespective of the 
	 * shape's size
	 */
   public ShapeIcon(MoveableShape shape,
      int width, int height)
   {
	  shapes = new ArrayList<MoveableShape>();
      shapes.add(shape);
      this.width = width;
      this.height = height;
   }
   
   /**
    * Add a shape to your lovely
    * Icon area of shapes
    * @param shape the MoveableShape you want to add
    */
   public void addShape(MoveableShape shape){
	   shapes.add(shape);
   }
   /**
    * @see Icon
    */
   public int getIconWidth()
   {
      return width;
   }
   /**
    * @see Icon
    */
   public int getIconHeight()
   {
      return height;
   }
   /**
    * This, excitingly enough, draws every shape
    * which you have added into this Icon
    * @see Icon
    */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for(int i=0;i<shapes.size();i++){
    	  shapes.get(i).draw(g2);
      }
   }
   /**
    * This method takes the two indices of the 
    * objects you want to see if are collided. 
    * Index 0 is the index of the shape you constructed with, 
    * and index 1 through n-1 are the indices of the shapes you 
    * added in later	
    * @return True if they're, y'know, on top of
    * each other
    */
   public boolean isCollided(int index1, int index2){
	  if(index1>=shapes.size()||index2>=shapes.size()){
		  return false;
	  }
	  
	  MoveableShape movingShape = shapes.get(index1);
	  MoveableShape frameOfReference = shapes.get(index2);
	  int compareValueRight = movingShape.getRightXCoordinate()
	  		- frameOfReference.getLeftXCoordinate();
	  int compareValueLeft = movingShape.getLeftXCoordinate() 
	  		- frameOfReference.getRightXCoordinate();
	  
		  if(compareValueRight>0&&compareValueLeft<0){
			   return true;
		   }

	  
	  return false;
   }

   private int width;
   private int height;
   
   //ArrayList is a clear choice here
   //Not too many elements are going to be used
   //But it'd still be weird to put a set limit
   //on how many
   private ArrayList<MoveableShape> shapes;
}


