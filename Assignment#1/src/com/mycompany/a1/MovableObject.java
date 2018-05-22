package com.mycompany.a1;
import java.util.Random;
/**
 * @author Ali H. Iqbal
 */
public abstract class MovableObject extends GameObject implements IMovable {

	/*----Fixed Variables----*/
	private Random r = new Random();
	private double dir = r.nextInt(360) * 1.0;
	private int objSpeed = r.nextInt(10);
	
	/*----Getters and setters----*/
	
	public void setObjSpeed(int s) { 
		this.objSpeed = s; 
	}
	public int getObjSpeed() { 
		return objSpeed; 
	}
	public void setObjDir(double dir) { 
		this.dir = dir; 
	}
	public double getObjDir() { 
		return dir; 
	}
	
	/*----Methods----*/
	public void moving() {
		double ang = Math.PI * ((90 - this.getObjDir()) / 180 );
		double dX = Math.cos(ang) * objSpeed;
		double dY = Math.sin(ang) * objSpeed;
		this.setXlocation((float) (this.getXlocation() + dX));
		this.setYlocation((float) (this.getYlocation() + dY));
	}
	
	/*----String Method----*/
	public String toString(){
		String parentDesc = super.toString();
		String myDesc = " Direction=" +  Math.round(dir*10.0)/10.0 + " Speed=" + objSpeed;
		return parentDesc + myDesc;
	}	
	
}
