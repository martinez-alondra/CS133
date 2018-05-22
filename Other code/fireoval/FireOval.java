package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

/** This class defines a "FireOval", which is a hierarchical object composed
 *  of a scaled "Body" and four scaled, translated, and rotated "Flames".
 */
public class FireOval {
	private Body myBody ;
	private Flame [] flames ;
	private Transform myTranslation, myRotation, myScale ;
	private double flameOffset = 0 ;		// current flame distance from FireOval
	private double flameIncrement = 1 ;		// change in flame distance each tick
	private double maxFlameOffset = 10 ;	// max distance before reversing
	
	public FireOval () {
	 	myTranslation = Transform.makeIdentity();
   	    myRotation = Transform.makeIdentity();
   	    myScale = Transform.makeIdentity();
	 	myBody = new Body(); 		// create a properly-scaled Body for the FireOval
	 	myBody.scale((float)2.5, (float) 1.5);
		flames = new Flame [4]; 	// create an array to hold the four flames
		// create four flames, each scaled, translated “up” in Y, and then rotated
		// relative to the local origin
		Flame f0 = new Flame();  f0.translate(0, 40);   f0.scale ((float)0.25,(float) 1);
		flames[0] = f0 ;   f0.setColor(ColorUtil.BLACK);
		Flame f1 = new Flame(); f1.translate(0, 40);f1.rotate(-90);f1.scale((float)0.25,(float) 1);
		flames[1] = f1 ;   f1.setColor(ColorUtil.GREEN);
		Flame f2 = new Flame(); f2.translate(0, 40);f2.rotate(180);f2.scale((float)0.25, (float) 1);
		flames[2] = f2 ;   f2.setColor(ColorUtil.BLUE);
		Flame f3 = new Flame(); f3.translate(0, 40);f3.rotate(90);f3.scale((float)0.25, (float)1);
		flames[3] = f3;    f3.setColor(ColorUtil.MAGENTA);
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
		myBody.draw(g, pCmpRelPrnt, pCmpRelScrn);
		for (Flame f : flames) {
				f.draw(g, pCmpRelPrnt, pCmpRelScrn);
			} 
		g.setTransform(gOrigXform);//restore the original xform
		} 
	// Invoked to update the local transforms of FireOval and its sub-shapes, flames.
	public void updateLTs () {
		// update the FireOval position and orientation
		this.translate(1,1);
		this.rotate(1) ;
		// update the flame positions (move them along their local Y axis)
		// this is why flames are TRANSLATED before they are ROTATED
		for (Flame f:flames) {
			f.translate ((float)0, (float)flameIncrement);  
		}
		flameOffset += flameIncrement ;
		// reverse direction of flame movement for next time if we've hit the max
		if (Math.abs(flameOffset) >= maxFlameOffset) {
			flameIncrement *= -1 ;
		}
	}	
} //end 
