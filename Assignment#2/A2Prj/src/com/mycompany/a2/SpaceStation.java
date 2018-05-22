package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class SpaceStation extends FixedObject {
	
	/*----Fixed Variables----*/
	private boolean status = false;
	private int blinkRate;

	/*----Methods----*/	
    public void setBlinkStatus(boolean stat) { 
    		this.status = stat; 
    	}
	public boolean getBlinkStatus() { 
		return this.status; 
	}
	public void setBlinkRate(int blinkRate) { 
		this.blinkRate = blinkRate; 
	}
	public int getBlinkRate() { 
		return this.blinkRate; 
	}
	
	/*----String Method----*/
	public String toString() {
		return ("SpaceStation: loc=" + Math.round(super.getXlocation())/1.0 + "," + Math.round(super.getYlocation())/1.0 +
				" color=" + "[" + ColorUtil.red(super.getObjColor()) + "," +
				ColorUtil.green(super.getObjColor()) + "," + ColorUtil.blue(super.getObjColor()) + "]" + 
				" rate=" + this.blinkRate + " blinkerOn=" + this.status);
	}
}
