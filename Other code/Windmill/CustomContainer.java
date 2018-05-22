package com.mycompany.myapp;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

public class CustomContainer extends Container {
	FireOval myFireOval ;
	Line myLine;
	public CustomContainer () {
		// create a FireOval to display
		myFireOval = new FireOval ();
		// rotate, scale, and translate this FireOval on the container
		myFireOval.scale(2,2);
		myFireOval.rotate (45) ;
		myFireOval.translate (200, 200) ;	
		
		myLine = new Line();
		myLine.scale(20,2);
		myLine.rotate (0) ;
		myLine.translate (200, 120) ;	
	}
	public FireOval getFireOval() {
		return myFireOval;
	}
	public void paint (Graphics g) {
		super.paint (g);
		Transform gXform = Transform.makeIdentity(); 
		g.getTransform(gXform);
		//move the drawing coordinates back
		gXform.translate(getAbsoluteX(),getAbsoluteY()); 
		//apply display mapping
		gXform.translate(0, getHeight());
		gXform.scale(1, -1);
	
		gXform.translate(-getAbsoluteX(),-getAbsoluteY()); 
		g.setTransform(gXform);
        Point pCmpRelPrnt = new Point(this.getX(), this.getY());
 		Point pCmpRelScrn = new Point(getAbsoluteX(),getAbsoluteY());
		// tell the fireball to draw itself
		myFireOval.draw(g, pCmpRelPrnt, pCmpRelScrn);
		myLine.draw(g, pCmpRelPrnt, pCmpRelScrn);
		g.resetAffine(); //restore the xform in Graphics object 
	} 
} 
