package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class Missile extends MovableObject {
	
	/*----Data variables----*/
	private int fuelLevel;

	/*----Getters and setters----*/
	public void setObjFuel(int fuelLevel) { 
		if (fuelLevel < 0) {
			this.fuelLevel = 0;
		}
		else {
			this.fuelLevel = fuelLevel;
		}
	}
	
	public int getObjFuel() { 
		return this.fuelLevel; 
	}
	
	/*----String Method----*/
	public String toString() {
		return ("Missile: loc=" + Math.round(super.getXlocation())/1.0 + "," + Math.round(super.getYlocation())/1.0 + 
				" color=" + "[" + ColorUtil.red(super.getObjColor()) + "," +
				ColorUtil.green(super.getObjColor()) + "," + ColorUtil.blue(super.getObjColor()) + "]" + 
				" speed=" + super.getObjSpeed() + 
				" dir=" + super.getObjDir() + " fuel=" + this.fuelLevel);
	}
}
