package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class Missile extends MovableObject {
	
	/*----Data variables----*/
	private int fuelLevel = 10;

	/*----Missile Constructor----*/	
	public Missile(double dir, double x, double y) {
		this.setObjColor(ColorUtil.MAGENTA);
		//location
		this.setXlocation(x);
		this.setYlocation(y);
		//direction and speed
		this.setObjDir(dir);
		this.setObjSpeed(20);
	}
	
	/*----Getters and setters----*/
	public void setObjFuel(int f) { 
		this.fuelLevel = f; 
	}
	public int getObjFuel() { 
		return fuelLevel; 
	}
	
	/*----String Method----*/
	public String toString() {
		String parentDesc = super.toString();
		String myDesc =  " fuel=" + fuelLevel;
		return "Missile: " + parentDesc + myDesc;
	}
}
