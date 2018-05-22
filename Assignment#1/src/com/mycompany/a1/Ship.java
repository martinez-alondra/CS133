package com.mycompany.a1;
import com.codename1.charts.util.ColorUtil;
/**
 * @author Ali H. Iqbal
 */
public class Ship extends MovableObject implements ISteerable {

		/*----Fixed Variables----*/
		private int maxMissiles = 12;

		/*----Ship Constructor----*/	
		public Ship(double width, double height) {
			this.setObjColor(ColorUtil.GREEN);
			//location
			this.setXlocation(width/2);
			this.setYlocation(height/2);
			//direction and speed
			this.setObjDir(0);
			this.setObjSpeed(0);
		}
		
		/*----Methods----*/
		public void accel(int change) {
			int currSpeed = this.getObjSpeed();
			if (currSpeed > 0) { //decrease speed
				this.setObjSpeed(currSpeed - 1);
			} //increase speed if<max
			else if (change >= 0 && currSpeed < 10)	
				this.setObjSpeed(currSpeed + 1);
		}
		public void dir(int change) {
			double currDir = this.getObjDir();
			//left-turn
			if (change < 0 && currDir >= 10)  	
				this.setObjDir((float) (currDir - 10));
			//360-turn
			else if (change >= 0 && currDir >= 350)
				this.setObjDir(0);
			//right-turn
			else if (change >= 0 && currDir < 350) 
				this.setObjDir((float) (currDir + 10));
			else
				this.setObjDir(350); 
		}
		
		/*----Getters and setters----*/
		public int getShipMissiles() {
			return this.maxMissiles;
		}
		public void setShipMissiles(int missiles) {
			maxMissiles = missiles;
		}
	
		/*----String Method----*/
		public String toString() {
			String parentDesc = super.toString();
			String myDesc = " Missiles=" + maxMissiles;
			return "Ship: " + parentDesc + myDesc;
		}

	
}
