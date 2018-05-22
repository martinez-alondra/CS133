package com.mycompany.a2;

/**
 * @author Ali H. Iqbal
 */
public abstract class MovableObject extends GameObject implements IMoveable {

	/*----Fixed Variables----*/
	private int speed;
	private int dir;
	
	/*----Getters and setters----*/

	public void setObjSpeed(int s) {
		if (speed < 0) {
			this.speed = 0;
		} else {
			this.speed = s;	
		}
	}
	public int getObjSpeed() { 
		return this.speed; 
	}
	
	public void setObjDir(int dir) {
		this.dir = dir%360;
		if (this.dir < 0) { 
			this.dir += 360;
		}
	}
	public int getObjDir() { 
		return this.dir; 
	}
	
	/*----Methods----*/
	
	public void moving() {
		
		int ang = 90 - this.dir;
		double dX = Math.cos(ang) * this.speed;
		double dY = Math.sin(ang) * this.speed;
		super.setXlocation(super.getXlocation() + dX);
		super.setYlocation(super.getYlocation() + dY);
	}
	
	
}
