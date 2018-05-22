package com.mycompany.a3.GameObjects;

import com.mycompany.a3.Interfaces.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Ali H. Iqbal
 */
//Class defines ship object in game world
public class Ships extends MovableObjects implements ISteerable, IDrawable,IMovable, ICollider{
    
	private int missCnt;
	private final int maxMissCnt = 10;
	private int width=15;
	private int height=20;
	
	//Ship constructor
	public Ships() {
		setColor(ColorUtil.rgb(0,0,128)); 
		setxLocation(414);
		setyLocation(384); 
		setDirection(0);
		setSpeed(0);
	}
	
	//set a new missile count
		public void setMissleCount(int newMiss){
			missCnt = newMiss;	
		}
		
	//return ship missile count
	public int getMissleCount(){
		return missCnt;
	}

	//decrease ship speed
	public void SpeedDecrease(){
		int dec = getSpeed() - 1;
		setSpeed(dec);
	}
			
	//increase ship speed
	public void SpeedIncrease(){	
		int inc = getSpeed() + 1;
		setSpeed(inc);
	}
	
	//Right turn method
	public void turnRight(){
		int right = getDirection() + 10;;//in right direction
		setDirection(right);
	}
	
	//Left turn method
	public void turnLeft(){
		int left = getDirection() - 10; //in left direction
		setDirection(left);
	}

	//return max missiles
	public int getMissileCountMax(){
		return maxMissCnt;
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		
		int x = (int)(pCmpRelPrnt.getX()+ this.getxLocation());
		int y = (int)(pCmpRelPrnt.getY()+ this.getyLocation());
		int startAngle=360, arcAngle=360;
		g.setColor(getColor()); 
		   g.drawArc(x, y, 50, 50, startAngle, arcAngle);
		   g.fillArc(x-4, y-4, width+40, height+40, startAngle, arcAngle);
	}

	public boolean collidesWith(ICollider obj) {
        
		boolean val = false;
		//both object center points
		int xCenter = (int) this.getxLocation(); 
		int yCenter = (int) this.getyLocation();
		
		int xTwoCenter = (int) ((GameObject) obj).getxLocation();
		int yTwoCenter = (int) ((GameObject) obj).getyLocation();
		
		int dx = xCenter - xTwoCenter;
		int dy = yCenter - yTwoCenter;
		int centerDist = (dx*dx + dy*dy);
		
		// find square of sum of radii
		int rad = 32/2;
		int radtwo = 32/2;
		//sum of radius
		int radsum = (rad*rad + 2*rad*radtwo + radtwo*radtwo);
		if (centerDist <= radsum) { 
			val = true ; 
		}
		return val ;
	}
	
	//Ship string method
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Missiles=" + getMissleCount();
		String ship = "ship:";
		return ship + parentDesc + myDesc; 
	}

}