package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Image;
/**
 * @author Ali H. Iqbal
 */
public class custButton extends Button {

	public custButton(String text) {
		super(text);
		this.getAllStyles().setBgColor(ColorUtil.GREEN);
		this.getAllStyles().setFgColor(ColorUtil.BLACK);
		this.getAllStyles().setPadding(1, 1, 1, 1);
		this.getAllStyles().setBgTransparency(200);
		// TODO Auto-generated constructor stub
	}
	

}