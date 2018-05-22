package com.mycompany.transformdemo;
/** This class defines a container containing a triangle.  
 * It applies a simple set of transformations to the triangle (by calling the triangle’s transformation methods when the triangle is created).  The container’s paint() method applies the “display mapping” transformation to the Graphics object, and tells the triangle to “draw itself”.  The triangle applies its LTs to the Graphics object in its draw() method.
 */
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;

public class CustomContainer4 extends Container {
	 private Triangle4 myTriangle ;
	 public CustomContainer4 () {
	    myTriangle = new Triangle4 (200, 200) ;     //construct a Triangle
		//apply some transformations to the triangle 	
		myTriangle.translate (300, 300); 
		myTriangle.rotate (180);   
		myTriangle.scale (1, 1);
	 }
	 public void paint (Graphics g) {
	  super.paint (g);
		//...[apply the “Display mapping” transformation to the Graphics object as before. But,         	
	    //again as before, first move the drawing coordinates so that the local origin coincides with 	
	    //the screen origin. After display mapping is applied, move the drawing coordinates back.]
		
		//origin location of the component (CustomContainer) relative to its parent container origin
		Point pCmpRelPrnt = new Point(getX(),getY());
		//origin location of the component (CustomContainer) relative to the screen origin
		Point pCmpRelScreen = new Point(getAbsoluteX(),getAbsoluteY());
		//tell the triangle to draw itself
		myTriangle.draw(g, pCmpRelPrnt, pCmpRelScreen);
		}
	} 


