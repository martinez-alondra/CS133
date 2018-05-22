package com.mycompany.transformdemo;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class CustomContainer2 extends Container {
	private Triangle2 myTriangle ;
	public CustomContainer2 () {
		myTriangle = new Triangle2 (200, 200) ;
	}
	public void paint (Graphics g) {
		super.paint (g);
		myTriangle.draw(g, new Point(this.getX(), this.getY()),400) ;
	}
}

