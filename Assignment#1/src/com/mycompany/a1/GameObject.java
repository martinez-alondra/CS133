package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public abstract class GameObject {
	
	/*----Fixed GameObject Variables----*/
	private int color;
	private double xLocation;
	private double yLocation;
	
	/*----Getters and setters----*/
	public void setObjColor(int c) {
		this.color = c;
	}
	public int getObjColor() {
		return color; 
	}
	public void setXlocation(double x ) {
		this.xLocation = x;	
	}
	public double getXlocation() {
		return xLocation;
	}
	public void setYlocation(double y ) {
		this.yLocation = y;		
	}
	public double getYlocation() {
		return yLocation;
	}
	
	/*----String Method----*/
	public String toString() {
		String myDesc = "loc=" + Math.round(xLocation*10.0)/10.0 + "," + Math.round(yLocation*10.0)/10.0 + 
				"color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
		return myDesc;
	}	
}
