package com.mycompany.transformdemo;

/** This class defines a triangle with Local Transformations (LTs). Client
 *  code can apply arbitrary transformations to the triangle by invoking methods to      
 *  update/modify the LTs; when the triangle is drawn it automatically 
 *  applies its current LTs to drawing coordinates. */
import java.util.Vector;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.layouts.BorderLayout;
public class Triangle4 {
	private Point top, bottomLeft, bottomRight ;
	private int myColor ;
	private Transform myRotation, myTranslation, myScale ;
	public Triangle4 (int base, int height) {
		top = new Point (0, height/2);
		bottomLeft = new Point (-base/2, -height/2);
		bottomRight = new Point (base/2, -height/2);
		myColor = ColorUtil.BLACK ;
		myRotation = Transform.makeIdentity();
		myTranslation = Transform.makeIdentity();
		myScale = Transform.makeIdentity();
	}
	public void rotate (float degrees) {
		//pivot point (rotation origin) is (0,0), this means the rotation will be applied about 		//the screen origin
		myRotation.rotate ((float)Math.toRadians(degrees),0,0);
	}
	public void translate (float tx, float ty) {
		myTranslation.translate (tx, ty);
	}
	public void scale (float sx, float sy) {
		//remember that like other transformation methods, scale() is also applied relative to 		//screen origin
		myScale.scale (sx, sy);
	}
	/* This method applies the triangle’s LTs to the received Graphics object’s xform, then uses this xform (with the additional transformations) to draw the triangle. Note that we pass getAbsoluteX() and getAbsoluteY() values of the container as pCmpRelScrn*/
	public void draw (Graphics g, Point pCmpRelPrnt, Point pCmpRelScrn) {
		  // set the drawing color for the triangle
			g.setColor(myColor);
			//append the triangle’s LTs to the xform in the Graphics object. But first move the drawing 	//coordinates so that the local origin coincides with the screen origin. After LTs are applied, 	//move the drawing coordinates back.
		 	Transform gXform = Transform.makeIdentity(); 
			g.getTransform(gXform);
			Transform gOrigXform = gXform.copy(); 
			gXform.translate(pCmpRelScrn.getX(),pCmpRelScrn.getY());
			gXform.translate(myTranslation.getTranslateX(), myTranslation.getTranslateY());
			gXform.concatenate(myRotation);
			gXform.scale(myScale.getScaleX(), myScale.getScaleY());
			gXform.translate(-pCmpRelScrn.getX(),-pCmpRelScrn.getY()); 
			g.setTransform(gXform);
			//draw the lines as before
			
			g.drawLine (pCmpRelPrnt.getX()+ top.getX(), pCmpRelPrnt.getY()+top.getY(),pCmpRelPrnt.getX()+bottomLeft.getX(),	pCmpRelPrnt.getY()+bottomLeft.getY());  
			g.drawLine (pCmpRelPrnt.getX()+bottomLeft.getX(), pCmpRelPrnt.getY()+bottomLeft.getY(), pCmpRelPrnt.getX()+bottomRight.getX(), pCmpRelPrnt.getY()+bottomRight.getY());
			g.drawLine (pCmpRelPrnt.getX()+bottomRight.getX(),pCmpRelPrnt.getY()+bottomRight.getY(),pCmpRelPrnt.getX()+top.getX(), pCmpRelPrnt.getY()+top.getY());
			g.setTransform(gOrigXform); 
		}
	 } //end of Triangle class

