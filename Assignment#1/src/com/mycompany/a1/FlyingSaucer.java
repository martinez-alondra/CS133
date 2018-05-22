package com.mycompany.a1;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class FlyingSaucer extends MovableObject {
	
	/*----Data Variables----*/
	private Random r  = new Random();
	private int [] arr = {10, 20};
	private int size = r.nextInt(arr.length);
	
	/*----Getters and setters----*/
	public void setObjSize(int sz) {
		this.size = sz;
	}
	public int getObjSize() {
		return size;
	}
	
	/*----Asteroid Constructor----*/
	public FlyingSaucer() {
		this.setObjColor(ColorUtil.YELLOW);
		//location
		this.setXlocation(r.nextInt(1024));
		this.setYlocation(r.nextInt(768));
		//direction and speed
		this.setObjDir(r.nextInt(200));
		this.setObjSpeed(r.nextInt(7));
	}
	
	/*----String Method----*/
	public String toString(){
		String parentDesc = super.toString();
		String stats = parentDesc + ", size=" + size;
		return stats;
	}					
}
