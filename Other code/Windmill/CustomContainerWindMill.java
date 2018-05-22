package com.mycompany.myapp;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

public class CustomContainerWindMill extends Container {
	WindMill myWindMill, myWindMill2;
	Line myLine;
	public CustomContainerWindMill () {
		// create a FireOval to display
		myWindMill = new WindMill ();
		// rotate, scale, and translate this FireOval on the container
		myWindMill.translate (100, 100) ;	
		
		myWindMill2 = new WindMill ();
		// rotate, scale, and translate this FireOval on the container
		myWindMill2.scale ((float) 0.5 , (float) 0.5) ;	
		myWindMill2.translate (400, 400) ;	
		
	}
	public FireOval getWindMillFireOval() {
		return myWindMill.getFireOval();
	}
	
	public FireOval getWindMill2FireOval() {
		return myWindMill2.getFireOval();
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
 		myWindMill.draw(g, pCmpRelPrnt, pCmpRelScrn);
 		myWindMill2.draw(g, pCmpRelPrnt, pCmpRelScrn);
		g.resetAffine(); //restore the xform in Graphics object 
	} 
} 
