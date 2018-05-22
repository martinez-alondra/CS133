package com.mycompany.a2;

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
		return this.color; 
	}
	public void setXlocation(double x ) {
		this.xLocation = x;	
	}
	public double getXlocation() {
		return this.xLocation;
	}
	public void setYlocation(double y ) {
		this.yLocation = y;		
	}
	public double getYlocation() {
		return this.yLocation;
	}
		
}
