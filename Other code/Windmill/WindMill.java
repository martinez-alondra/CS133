package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

/** This class defines a "FireOval", which is a hierarchical object composed
 *  of a scaled "Body" and four scaled, translated, and rotated "Flames".
 */
public class WindMill {
	private Line myLine ;
	private FireOval myFireOval;
	private Transform myTranslation, myRotation, myScale ;
	private double flameOffset = 0 ;		// current flame distance from FireOval
	private double flameIncrement = 1 ;		// change in flame distance each tick
	private double maxFlameOffset = 10 ;	// max distance before reversing
	
	public WindMill () {
		
		myFireOval = new FireOval ();
		
	 	myTranslation = Transform.makeIdentity();
   	    myRotation = Transform.makeIdentity();
   	    myScale = Transform.makeIdentity();
   	    
   	    myFireOval.scale(2,2);
		myFireOval.rotate (45) ;
		myFireOval.translate (200, 200) ;	
		
		myLine = new Line();
		myLine.scale(20,2);
		myLine.rotate (0) ;
		myLine.translate (200, 120) ;
		
	 }
	 public void rotate (double degrees)	{
			myRotation.rotate ((float) Math.toRadians(degrees), 0, 0);
	 }
	 public void scale (float sx, float sy) {
			myScale.scale (sx, sy);
	 }
	 public void translate (float tx, float ty) {
			myTranslation.translate (tx, ty);
	 }
	public void draw (Graphics g, Point pCmpRelPrnt, Point pCmpRelScrn) {
		Transform gXform = Transform.makeIdentity();
		g.getTransform(gXform);
		Transform gOrigXform = gXform.copy(); //save the original xform
		//move the drawing coordinates back
		gXform.translate(pCmpRelScrn.getX(),pCmpRelScrn.getY());
		// append FireOval's LTs to the graphics object's transform
		gXform.translate(myTranslation.getTranslateX(), myTranslation.getTranslateY()); 
		gXform.concatenate(myRotation);
		gXform.scale(myScale.getScaleX(), myScale.getScaleY());
		//move the drawing coordinates so that the local origin coincides with the screen origin
		gXform.translate(-pCmpRelScrn.getX(),-pCmpRelScrn.getY()); 
		g.setTransform(gXform); 
		//draw sub-shapes of FireOval
		myFireOval.draw(g, pCmpRelPrnt, pCmpRelScrn);
		myLine.draw(g, pCmpRelPrnt, pCmpRelScrn);
		g.setTransform(gOrigXform);//restore the original xform
	} 
	// Invoked to update the local transforms of FireOval and its sub-shapes, flames.
	public FireOval getFireOval() {
		return myFireOval;
	}
	public void updateLTs () {
		// update the FireOval position and orientation
		this.translate(0,0);
		//this.translate(1,1);
		this.rotate(1) ;
		// update the flame positions (move them along their local Y axis)
		// this is why flames are TRANSLATED before they are ROTATED
		/*
		for (Flame f:flames) {
			f.translate ((float)0, (float)0);  
			//f.translate ((float)0, (float)flameIncrement);  
		}
		*/
		flameOffset += flameIncrement ;
		// reverse direction of flame movement for next time if we've hit the max
		if (Math.abs(flameOffset) >= maxFlameOffset) {
			flameIncrement *= -1 ;
		}
	}	
} //end 
