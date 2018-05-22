package com.mycompany.transformdemo;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

/** This class defines an isosceles triangle with a specified base and height. The triangle points are defined in “local space”, and the local space axis orientation is X to the right and Y upward. Local origin coincides with the container origin to draw the triangle on the container. That is why, we pass “triangle point + pCmpRelPrnt” as a drawing coordinate to the drawLine() method.*/
public class Triangle2 {
	private float[] top = new float[3];
	private float[] bottomLeft = new float[3];
	private float[] bottomRight = new float[3];
	private int color ;
	public Triangle2 (int base, int height) {
		//top = new Point (0, height/2);
		top[0] = 0; 
		top[1] = height/2;
		// bottomLeft = new Point (-base/2, -height/2);
		bottomLeft[0] = -base/2;
		bottomLeft[1] = -height/2;
		// bottomRight = new Point (base/2, -height/2);
		bottomRight[0] = base/2;
		bottomRight[1] = -height/2;
		color = ColorUtil.BLACK;
}
	public void draw (Graphics g, Point pCmpRelPrnt, int height) {
		// create an displayXform to map triangle points to “display space”
		Transform displayXform = Transform.makeIdentity();
		displayXform.translate (0, height);
		displayXform.scale (1, -1);
		// apply the display mapping transforms to the triangle points
		displayXform.transformPoint(top,top);
		displayXform.transformPoint(bottomLeft,bottomLeft);
		displayXform.transformPoint(bottomRight,bottomRight);

		// draw the (transformed) triangle
		g.setColor(color);
		g.drawLine(pCmpRelPrnt.getX()+(int)top[0], pCmpRelPrnt.getY()+(int)top[1],pCmpRelPrnt.getX()+(int)bottomLeft[0], 							pCmpRelPrnt.getY()+(int)bottomLeft[1]); // left side
		g.drawLine(pCmpRelPrnt.getX()+(int)bottomLeft[0],pCmpRelPrnt.getY()+(int)bottomLeft[1], pCmpRelPrnt.getX()+ 						(int)bottomRight[0], pCmpRelPrnt.getY()+ (int)bottomRight[1]); // bottom
		g.drawLine(pCmpRelPrnt.getX()+(int)bottomRight[0],pCmpRelPrnt.getY()+(int)bottomRight[1], pCmpRelPrnt.getX()+(int)top[0], 					pCmpRelPrnt.getY()+(int)top[1]); // right side
	}
}

