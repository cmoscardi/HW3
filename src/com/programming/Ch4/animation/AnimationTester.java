package com.programming.Ch4.animation;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
   This program implements an animation that moves
   a car shape.
   1) Constructs a car shape <br>
   2) Constructs an icon container <br>
   3) Constructs a container for that icon <br>
   4) Constructs a timer which changes the state of 
   the icon <br>
   5) Constructs a speed slider and an action to
   make that speed slider do something <br>
   6) Constructs a box which can be created by
   the push of a button <br>
   7) and puts it all into a big container <br>
   <h>FOR STEP 3</h> <br>
   This program, in the general, uses the Memento 
   pattern - the controller (whether the shapeIcon or 
   the test class) accesses the child class in order to get
   its state - that is, the direction in which the car is 
   moving <br> <br>
   
   Incidentally, if the box is created while the car
   is in the middle of it, it will trap the car and the 
   poor car won't be able to escape, like a deadly black
   hole or something
   
   @author cay horstmann, with subtle yet delicious 
   touches from christian moscardi
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
 
	  //setting up the car shape as an icon
      final MoveableShape shape
            = new CarShape(0, ICON_HEIGHT/2, CAR_WIDTH);

      final ShapeIcon icon = new ShapeIcon(shape,
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
	        	  if(icon.isCollided(0, 1)){
           		   shape.translate(-1*shape.getXDirection(),0);
           	   }
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
    	            	   if(icon.isCollided(0, 1)){
    	            		   shape.translate(-1*shape.getXDirection(),0);
    	            	   }
    	            	   shape.translate(shape.getXDirection()*source.getValue(), 0);
    	               }

    	               label.repaint();
    	            }
    	         });
    		  }
    	  }
      });
      // end of step 2
      
      //add button for box of doom - 
      //step 3
      final JButton boxButton = new JButton("Add fun box");
      boxButton.addActionListener(new ActionListener(){
    	  public void actionPerformed(ActionEvent e){
    		  icon.addShape(new BoxOfDestruction(BOX_X,BOX_Y));
    	  }
      });
      //beginning of frame creation
      JFrame frame = new JFrame();
      frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
      frame.add(label);
      frame.add(boxButton);
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
   private static final int ICON_WIDTH = 1200;
   private static final int ICON_HEIGHT = 400;
   private static final int CAR_WIDTH = 100;
   private static final int BOX_X= 900;
   private static final int BOX_Y=200;
}
