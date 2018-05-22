package com.mycompany.transformdemo;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class CustomContainer extends Container {
	private Triangle1 myTriangle ;
	public CustomContainer () {
		myTriangle = new Triangle1 (200, 200) ;
	}
	public void paint (Graphics g) {
		super.paint (g);
		myTriangle.draw(g, new Point(this.getX(), this.getY())) ;
	}
}

