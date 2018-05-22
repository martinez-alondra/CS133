package com.mycompany.a3.GameObjects;
import com.mycompany.a3.Interfaces.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Ali H. Iqbal
 */
//Class defines missile object in game world
public class Missiles extends MovableObjects implements IDrawable, ISelectable, ICollider{
	
	private int fuelAmt;
	private boolean cFlag=true;
	private int width=5;
	private int height=60;

	//missile constructor method
	public Missiles(float x,float y, int dir) { 
		fuelAmt = 100;
		setColor(ColorUtil.rgb(255,0,0));
		setxLocation(x); 
		setyLocation(y); 	
		setDirection(dir);
		setSpeed(5);
	}
	
	//sets more fuel
	public void SetFuel(int morefuel){
		fuelAmt = morefuel;
	}
	
	//return fuel amount
	public int getFuelLevel(){
			return fuelAmt;
	}
	//Missile string method
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " fuel=" + getFuelLevel() ;
		String missile =  "Missile"; 
		return missile + parentDesc + myDesc ;
	}

	private boolean isSelect;
	public void setSelected(boolean select) { isSelect = select; }
	public boolean isSelected() { return isSelect; }

	
	public void draw(Graphics g, Point pCmpRelPrnt) {

		move();
		g.setColor(this.getColor());
		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getxLocation()) + mapOriginX;
		int currentY = ((int)this.getyLocation()) + mapOriginY;
		int width=5, height = 30;
		
		g.fillRect(currentX, currentY, width, height);
		
	}
	
	public void setContainFlag(boolean flag){
		this.cFlag = flag;
	}
	
	public boolean getContainFlag(){
		return cFlag;
	}
    public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {

        int iShapeX=(int)this.getxLocation(); 
    		int iShapeY=(int)this.getyLocation(); 
		int px = pPtrRelPrnt.getX(); 
		int py = pPtrRelPrnt.getY(); 
		int xLoc = (pCmpRelPrnt.getX())+iShapeX ;
		int yLoc = (pCmpRelPrnt.getY())+iShapeY ;
		
		if((xLoc<=px&&px<=xLoc+width)&&(yLoc<=py&&py<=yLoc+height)){
				setContainFlag(false);
		 }else{
				setContainFlag(true);
		 }
	    return getContainFlag();   
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
		
		// find square of sum 
		int rad = 32/2;
		int radtwo = 32/2;
		//sum of radius
		int radsum = (rad*rad + 2*rad*radtwo + radtwo*radtwo);
		if (centerDist <= radsum) { 
			val = true ; 
		}
		return val ;
	}

}
