package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;
import java.util.Random;
/**
 * @author Ali H. Iqbal
 */
public class Asteroid extends MovableObject {
	
	/*----Data Variables----*/
	private Random r  = new Random();
	private int size = r.nextInt(31) + 6;
	
	/*----Getters and setters----*/
	public void setObjSize(int sz) {
		this.size = sz;
	}
	public int getObjSize() {
		return size;
	}
	
	/*----Asteroid Constructor----*/
	public Asteroid() {
		this.setObjColor(ColorUtil.GRAY);
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
