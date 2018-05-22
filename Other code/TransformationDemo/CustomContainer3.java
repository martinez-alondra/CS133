package com.mycompany.transformdemo;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

public class CustomContainer3 extends Container {
	private Triangle3 myTriangle ;
	public CustomContainer3 () {
		myTriangle = new Triangle3 (200, 200);
	}
	public void paint (Graphics g) {
		super.paint(g);
		Transform gXform = Transform.makeIdentity();
		g.getTransform(gXform);
		//move drawing coordinates back
		gXform.translate(getAbsoluteX(),getAbsoluteY()); 
		//apply translate associated with display mapping
		gXform.translate(0, getHeight());
		//apply scale associated with display mapping
		gXform.scale(1, -1);
		//gXform.translate(100, 200);
		//move drawing coordinates so that the local origin coincides with the screen origin
		gXform.translate(-getAbsoluteX(),-getAbsoluteY());
		g.setTransform(gXform);
		myTriangle.draw(g, new Point(getX(), getY()));
		//restore the original xform in g
		g.resetAffine();
	}

}

