package com.programming.Ch4.animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
 
	  //setting up the car shape as an icon
      final MoveableShape shape
            = new CarShape(0, ICON_HEIGHT/2, CAR_WIDTH);

      ShapeIcon icon = new ShapeIcon(shape,
            ICON_WIDTH, ICON_HEIGHT);

      final JLabel label = new JLabel(icon);
      
      //end of car shape setup
      
      //beginning of timer setup
      final int DELAY = 10; // Milliseconds between timer ticks
      
      	final Timer t = new Timer(DELAY, new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
              if(shape.getLeftXCoordinate()<=0){
            	  shape.translate(1, 0);
	          }
	          else if(shape.getRightXCoordinate()>=ICON_WIDTH){
	              shape.translate(-1, 0);
	          }
	          else{
	        	  shape.translate(shape.getXDirection()*DEFAULT_SPEED, 0);
	          }
               label.repaint();
            }
         });
      
      //end of timer setup
      
      //add slider -- step 2
      JSlider speedSlider = new JSlider(JSlider.HORIZONTAL,
    		  					MIN_SPEED,MAX_SPEED,DEFAULT_SPEED);
      
      speedSlider.addChangeListener(new ChangeListener(){
    	  public void stateChanged(ChangeEvent e){
    		final  JSlider source = (JSlider) e.getSource();
    		  if(!source.getValueIsAdjusting()){
    			 ActionListener[] listeners = t.getActionListeners();
    			 t.removeActionListener(listeners[0]);
    			 
    			 t.addActionListener(new
    			         ActionListener()
    	         {
    	            public void actionPerformed(ActionEvent event)
    	            {
    	               if(shape.getLeftXCoordinate()<=0){
    	            	   shape.translate(1, 0);
    	               }
    	               else if(shape.getRightXCoordinate()>=ICON_WIDTH){
    	            	   shape.translate(-1, 0);
    	               }
    	               else{
    	            	   shape.translate(shape.getXDirection()*source.getValue(), 0);
    	               }
    	               label.repaint();
    	            }
    	         });
    		  }
    	  }
      });
      // end of step 2
      
         
      //beginning of frame creation
      JFrame frame = new JFrame();
      frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      frame.add(label);
      frame.add(speedSlider);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      //end of frame creation
      
      //set frame to visible, start timer
      frame.setVisible(true);
      t.start();
      
   }
   

   private static final int MIN_SPEED = 0;
   private static final int MAX_SPEED=10;
   private static final int DEFAULT_SPEED = 2;
   private static final int ICON_WIDTH = 600;
   private static final int ICON_HEIGHT = 400;
   private static final int CAR_WIDTH = 100;
}
