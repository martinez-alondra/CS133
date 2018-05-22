package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class FlyingSaucer extends MovableObject {
	
	/*----Data Variables----*/
	private int size;
	
	/*----Getters and setters----*/
	public void setObjSize(int sz) {
		this.size = sz;
	}
	public int getObjSize() {
		return this.size;
	}
	
	/*----String Method----*/
	public String toString() {
		return ("Flying Saucer: loc=" + Math.round(super.getXlocation())/1.0 + "," + Math.round(super.getYlocation())/1.0 +
				" color=" + "[" + ColorUtil.red(super.getObjColor()) + "," +
				ColorUtil.green(super.getObjColor()) + "," + ColorUtil.blue(super.getObjColor()) + "]" + 
				" speed=" + super.getObjSpeed() +
				" dir=" + super.getObjDir() + " size=" + this.size);
	}
						
}
