package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;
/**
 * @author Ali H. Iqbal
 */
public class MapView extends Container implements Observer {

	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		((IGameWorld)observable).printMap();

	}
	public MapView() {
		this.getStyle().setBorder(Border.createLineBorder(3, ColorUtil.GREEN));
	}

}
