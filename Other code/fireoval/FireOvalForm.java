package com.mycompany.myapp;

import java.util.Vector;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Point;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BorderLayout;

public class FireOvalForm extends Form  {
	
	public FireOvalForm() {
		CustomContainer  centerContainer = new CustomContainer ();	
		setLayout(new BorderLayout());	
	    add(BorderLayout.CENTER,centerContainer);
        centerContainer.repaint();
	    this.show();
	}
}