package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.UITimer;


/** This class defines a Form containing a CustomContainer object that displays 
 * the WindMill. It uses a Timer to call updateLTs() which modify WindMill ’s and 
 * its Flames’ local transformations. 
 * CustomContainer class looks exactly like the one used in static WindMill
 * example expect it also has a getWindMill() method that returns WindMill object.
 */
public class DynamicWindMillForm extends Form implements Runnable {
	private CustomContainerWindMill myCustomContainer = new CustomContainerWindMill();
	public DynamicWindMillForm () {
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, myCustomContainer);
		//...[set up GUI using border layout, add buttons to north, south, and 			
		//west containers, and CustomContainer object to the center container.]
		UITimer timer = new UITimer(this);
		timer.schedule(10, true, this);
		this.show();
	}
	public void run () {
		myCustomContainer.getWindMillFireOval().updateLTs();
		myCustomContainer.getWindMill2FireOval().updateLTs();
		myCustomContainer.repaint() ;
	}
}
