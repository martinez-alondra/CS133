package com.mycompany.transformdemo;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
/** This class defines a triangle with Local Transformations (LTs). Client
 *  code can apply arbitrary transformations to the triangle by invoking methods to      
 *  update/modify the LTs; when the triangle is drawn it automatically 
 *  applies its current LTs to drawing coordinates. */
import com.codename1.ui.geom.Point;
public class Triangle {
	private Point top, bottomLeft, bottomRight ;
	private int myColor ;
	private Transform myRotation, myTranslation, myScale ;
	public Triangle (int base, int height) {
		
		top = new Point (0, height/2);
		bottomLeft = new Point (-base/2, -height/2);
		bottomRight = new Point (base/2, -height/2);
		myColor = ColorUtil.BLACK;
		/*
		top = new Point (base/2, height/2);
		bottomLeft = new Point (-base/2 + base/2, -height/2);
		bottomRight = new Point (base/2 + base/2, -height/2);
		myColor = ColorUtil.BLACK;
		*/
	}
	public void draw (Graphics g, Point pCmpRelPrnt) {
		g.setColor(ColorUtil.BLACK);
		 
		g.drawLine (
		            pCmpRelPrnt.getX() + top.getX(), 
		            pCmpRelPrnt.getY() + top.getY(), 
		            pCmpRelPrnt.getX() + bottomLeft.getX(), 
		            pCmpRelPrnt.getY() + bottomLeft.getY()
		            );  
	
		g.drawLine (
				    pCmpRelPrnt.getX() + bottomLeft.getX(), 
				    pCmpRelPrnt.getY() + bottomLeft.getY(), 
				    pCmpRelPrnt.getX() + bottomRight.getX(), 
				    pCmpRelPrnt.getY() + bottomRight.getY()
				    );
		 
		g.drawLine (
				    pCmpRelPrnt.getX() + bottomRight.getX(),
				    pCmpRelPrnt.getY() + bottomRight.getY(),  
				    pCmpRelPrnt.getX() + top.getX(), 
				    pCmpRelPrnt.getY() + top.getY()
				    );
				    
	}
} //end of Triangle class
