package com.mycompany.myapp;

import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
/** Defines a single "flame" to be used as an arm of a FireOval.
 *  The Flame is modeled after the "Triangle" class, but specifies
 *  fixed dimensions of 40 (base) by 40 (height) in local space.
 *  Clients using the Flame can scale it to have any desired proportions.
 */
import com.codename1.ui.geom.Point;

public class Line {
	private Point top, bottom;
	private int myColor ;
	private Transform myTranslation ;
	private Transform myRotation ;
	private Transform myScale ;

	public Line ()	{
		// define a default flame with base=40, height=40, and origin in the center.
		top = new Point (0, 20);
		bottom = new Point (0, -20);
		// initialize the transformations applied to the Flame
	    myTranslation = Transform.makeIdentity();
        myRotation = Transform.makeIdentity();
        myScale = Transform.makeIdentity();
	}
	public void setColor(int iColor){
		myColor = iColor;
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
		//append the flames’s LTs to the xform in the Graphics object (do not forget to do “local 	//origin” transformations). ORDER of LTs: Scaling LT will be applied to coordinates FIRST, 	//then Translation LT, and lastly Rotation LT. Also restore the xform at the end of draw() to 	//remove this sub-shape’s LTs from xform of the Graphics object. Otherwise, we would also 	//apply these LTs to the next sub-shape since it also uses the same Graphics object.
	 	Transform gXform = Transform.makeIdentity();
		g.getTransform(gXform);
		Transform gOrigXform = gXform.copy(); //save the original xform
		gXform.translate(pCmpRelScrn.getX(),pCmpRelScrn.getY());
		gXform.concatenate(myRotation); 
		gXform.translate(myTranslation.getTranslateX(), myTranslation.getTranslateY());
		gXform.scale(myScale.getScaleX(), myScale.getScaleY()); 
		gXform.translate(-pCmpRelScrn.getX(),-pCmpRelScrn.getY()); 
		g.setTransform(gXform);
		//draw the lines as before
		g.drawLine(pCmpRelPrnt.getX()+top.getX(), pCmpRelPrnt.getY()+top.getY(), 
				   pCmpRelPrnt.getX() + bottom.getX(),pCmpRelPrnt.getY() + bottom.getY()); 	
		g.setTransform(gOrigXform); //restore the original xform (remove LTs)
		//do not use resetAffine() in draw()! Instead use getTransform()/setTransform(gOrigForm)
		}
	} 