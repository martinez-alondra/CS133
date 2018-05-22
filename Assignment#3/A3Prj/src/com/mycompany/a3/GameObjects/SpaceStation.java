package com.mycompany.a3.GameObjects;

import com.mycompany.a3.Interfaces.*;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Ali H. Iqbal
 */
//Class defines Space station object in game world
public class SpaceStation extends FixedObjects implements IDrawable, ICollider{
   
	//Station data variables
	private boolean blink;
	private int blinkRt;
	
	//Station constructor
	public SpaceStation() {
		setColor(ColorUtil.rgb(0,255,0)); 
		blink = true;
		blinkRt = randBlinkRate();
	}
	
	//set and get blink rate
	public void setBlinkRate(int newB){
		blinkRt = newB;
	}
	public int getBlinkRate(){
		return blinkRt;
	}

	public boolean getBlink(){
		return blink;
	}
	
	public void setBlink(boolean newB){
		blink = newB;
	}
	
	//method for station blink
	public void Blink(){
		if(getBlink()==true){
			setBlink(false);
		}else{
			setBlink(true);
		}
	}
	
	//compute a random blink rate
	public int randBlinkRate(){
		int minBlink =  0;
		int maxBlink =   42;
		Random ran = new Random();
		int randBlink = ran.nextInt((maxBlink - minBlink) + 1)  + minBlink;
		return randBlink;
	}
	//Station string method
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " rate=" + getBlinkRate();
		String station  = "Station:"; 
		return station + parentDesc + myDesc ;
	}
	//station draw method
	public void draw(Graphics g, Point pCmpRelPrnt) {
		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getxLocation()) + mapOriginX;
		int currentY = ((int)this.getyLocation());
		int width=60, height=60;

		g.setColor(this.getColor());
		
		if(this.blink) {
			g.fillRoundRect(currentX, currentY, width, height, 20, 10);
		}
		g.drawRoundRect(currentX, currentY, width, height, 20, 10);
	
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

		int rad = 15/2;
		int radtwo = 15/2;
		//sum of radius
		int radsum = (rad*rad + 2*rad*radtwo + radtwo*radtwo);
		if (centerDist <= radsum) { 
			val = true ; 
		}
		return val ;
   }  
}
