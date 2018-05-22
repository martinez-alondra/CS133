package com.mycompany.transformdemo;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

/** This class defines an isosceles triangle with a specified base and height. The triangle points are defined in “local space”, and the local space axis orientation is X to the right and Y upward. Local origin coincides with the container origin to draw the triangle on the container. That is why, we pass “triangle point + pCmpRelPrnt” as a drawing coordinate to the drawLine() method.*/
public class Triangle3 {
	private Point top, bottomLeft, bottomRight ;
	private int color ;
	public Triangle3 (int base, int height) {
		top = new Point (0, height/2);
		bottomLeft = new Point (-base/2, -height/2);
		bottomRight = new Point (base/2, -height/2);
		color = ColorUtil.BLACK;
	}
	public void draw (Graphics g, Point pCmpRelPrnt) {
		g.setColor(color);
		g.drawLine (pCmpRelPrnt.getX()+ top.getX(), pCmpRelPrnt.getY()+top.getY(),pCmpRelPrnt.getX()+bottomLeft.getX(), 											pCmpRelPrnt.getY()+bottomLeft.getY());  
		g.drawLine (pCmpRelPrnt.getX()+bottomLeft.getX(), pCmpRelPrnt.getY()+bottomLeft.getY(), pCmpRelPrnt.getX()+bottomRight.getX(), 											pCmpRelPrnt.getY()+bottomRight.getY());
		g.drawLine (pCmpRelPrnt.getX()+bottomRight.getX(),pCmpRelPrnt.getY()+bottomRight.getY(),pCmpRelPrnt.getX()+top.getX(), 												pCmpRelPrnt.getY()+top.getY());	
	}
}


