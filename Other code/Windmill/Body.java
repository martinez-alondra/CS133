package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

/** Defines a "Body" for a FireOval; the "body" is just a scalable circle with its origin in the center. Lower left corner in local space would correspond to upper left corner on screen */
public class Body {
	private int myRadius, myColor ;
	private Transform myTranslation, myRotation, myScale ;
	Point lowerLeftInLocalSpace;
 public Body () {
	 myRadius = 10;	
	 lowerLeftInLocalSpace = new Point(-myRadius, -myRadius);
	 myColor = ColorUtil.BLACK ;
     myTranslation = Transform.makeIdentity();
     myRotation = Transform.makeIdentity();
     myScale = Transform.makeIdentity(); 
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
 // ...[code here implementing rotate(), scale(), and translate() as in the Flame class]
 public void draw (Graphics g , Point pCmpRelPrnt, Point pCmpRelScrn) {
	g.setColor(myColor);
	Transform gXform = Transform.makeIdentity();
	g.getTransform(gXform);
	Transform gOrigXform = gXform.copy(); //save the original xform
	gXform.translate(pCmpRelScrn.getX(),pCmpRelScrn.getY());
	gXform.translate(myTranslation.getTranslateX(), myTranslation.getTranslateY());
	gXform.concatenate(myRotation); 
	gXform.scale(myScale.getScaleX(), myScale.getScaleY()); 
	gXform.translate(-pCmpRelScrn.getX(),-pCmpRelScrn.getY()); 
	g.setTransform(gXform);
	//draw the body  	
	g.fillArc(	pCmpRelPrnt.getX() + lowerLeftInLocalSpace.getX() , 	
			    pCmpRelPrnt.getY() + lowerLeftInLocalSpace.getY() ,
			    2*myRadius, 2*myRadius, 0, 360);
	g.setTransform(gOrigXform); //restore the original xform
	}
 }

