package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class Ship extends MovableObject implements ISteerable {

		/*----Fixed Variables----*/
		private int maxMissiles;
		
		/*----Methods----*/
	
		public void steer(int Dir) { 
			super.setObjDir(super.getObjDir() + Dir);
		}
		
		/*----Getters and setters----*/
		public int getShipMissiles() {
			return this.maxMissiles;
		}
		
		public void setShipMissiles(int maxMissiles) {
			if (maxMissiles < 0) {
				this.maxMissiles = 0;
			}
			else {
				this.maxMissiles = maxMissiles;
			}
		}
	
		/*----String Method----*/
		public String toString() {
			return ("Ship: loc=" + Math.round(super.getXlocation())/1.0 + "," + Math.round(super.getYlocation())/1.0 +
					" color=" + "[" + ColorUtil.red(super.getObjColor()) + "," +
					ColorUtil.green(super.getObjColor()) + "," + ColorUtil.blue(super.getObjColor()) + "]" + 
					" speed=" + super.getObjSpeed() +
					" dir=" + super.getObjDir() + " missiles=" + this.maxMissiles);
		}
	
}
