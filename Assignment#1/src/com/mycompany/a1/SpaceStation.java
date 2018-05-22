package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class SpaceStation extends FixedObject {
	
	/*----Fixed Variables----*/
	private boolean light = true;
	private Random r = new Random();
	private int blinkRate = r.nextInt(5) + 1;

	/*----SpaceStation Constructor----*/	
	public SpaceStation() {
		this.setObjColor(ColorUtil.BLUE);
		//location
		this.setXlocation((float) (r.nextInt(1024) *1.0));
		this.setYlocation((float) (r.nextInt(768) *1.0));
	}

	/*----Methods----*/	
    public void light(boolean on) { 
    		this.light = on; 
    	}
	public boolean lightOn() { 
		return light; 
	}
	public void setBlinkRate(int blinkRate) { 
		this.blinkRate = blinkRate; 
	}
	public int getBlinkRate() { 
		return blinkRate; 
	}
	
	/*----String Method----*/
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Blink-Rate=" + blinkRate;
		return "Space-Station: " + parentDesc + myDesc;
	}
}
