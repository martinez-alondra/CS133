package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;


/** This class defines a Form containing a CustomContainer object that displays 
 * the FireOval. It uses a Timer to call updateLTs() which modify FireOval’s and 
 * its Flames’ local transformations. 
 * CustomContainer class looks exactly like the one used in static FireOval
 * example expect it also has a getFireOval() method that returns FireOval object.
 */
public class DynamicFireOvalForm extends Form implements Runnable {
	private CustomContainer myCustomContainer = new CustomContainer();
	public DynamicFireOvalForm () {
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, myCustomContainer);
		//...[set up GUI using border layout, add buttons to north, south, and 			
		//west containers, and CustomContainer object to the center container.]
		UITimer timer = new UITimer(this);
		timer.schedule(10, true, this);
		this.show();
	}
	public void run () {
		myCustomContainer.getFireOval().updateLTs() ;
		myCustomContainer.repaint() ;
	}
}
