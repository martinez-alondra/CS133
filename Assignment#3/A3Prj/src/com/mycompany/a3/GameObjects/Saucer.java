package com.mycompany.a3.GameObjects;

import com.mycompany.a3.Interfaces.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import java.util.Random;
/**
 * @author Ali H. Iqbal
 */
//Class defines Flying Saucer characteristics
public class Saucer extends MovableObjects implements IDrawable, ISelectable, ICollider{

	private int sz;
	private boolean cFlag=true;
	//set asteroid color and size
	public Saucer() {
		setColor(ColorUtil.YELLOW);
		sz = randsize();
	}
	//returns ship size 
	public int getSize(){
		return sz;
	}
	//sets ship size
	public void setSize(int size){
		sz = size;
	}  
	//random size for asteroids 
	public int randsize(){
		int min =  35;
		int max =   45;
		Random rand = new Random();
		int sizeRand = rand.nextInt((max - min)  + 1) + min;
		return sizeRand;
	}
	//String method
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " size=" + getSize();
		String saucer = "Saucer: ";
		return saucer+ parentDesc + myDesc;
	}
	
	private boolean isSelect;
	public void setSelected(boolean select) { isSelect = select; }
	public boolean isSelected() { return isSelect; }

	//Asteroid object draw method
	public void draw(Graphics g, Point pCmpRelPrnt) {
	 	
		int x = (int)(pCmpRelPrnt.getX()+ this.getxLocation());
		int y = (int)(pCmpRelPrnt.getY()+ this.getyLocation());
		int startAng=360, arcAng=360;
		
		g.setColor(getColor()); 
		
	   if(isSelected()) {
		   g.drawArc(x, y, getSize(), getSize(), startAng, arcAng);
	   }
	   else{
		   g.fillArc(x, y, getSize(), getSize(), startAng, arcAng);
	   }
	   
	}
	public boolean getContainFlag(){
		return cFlag;
	}
	public void setContainFlag(boolean flag){
		this.cFlag = flag;
	}
	
    public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {

        int iShapeX=(int)this.getxLocation(); 
        int iShapeY=(int)this.getyLocation(); 
		int px = pPtrRelPrnt.getX(); 
		int py = pPtrRelPrnt.getY(); 
		int xLoc = (pCmpRelPrnt.getX())+iShapeX ;
		int yLoc = (pCmpRelPrnt.getY())+iShapeY ;
	
		if((xLoc<=px&&px<=xLoc+getSize())&&(yLoc<=py&&py<=yLoc+getSize())){
				setContainFlag(false);
		 }else{
				setContainFlag(true);
		 }
	    return getContainFlag();   
	}
    //boolean method check for collision
	public boolean collidesWith(ICollider obj) {
        
		boolean val = false;
		int xCenter = (int) (this.getxLocation());
		int yCenter = (int) (this.getyLocation()); 
		int xtwoCenter = (int) (((GameObject) obj).getxLocation()); 
		int ytwoCenter = (int) (((GameObject) obj).getyLocation());
		int dx = xCenter - xtwoCenter;
		int dy = yCenter - ytwoCenter;
		int centerDist = (dx*dx + dy*dy);
		//sum of radius
		int rad = this.getSize()/2;
		int radtwo = this.getSize()/2;
		int radSum = (rad*rad + 2*rad*radtwo + radtwo*radtwo);
		if (centerDist <= radSum) { 
			val = true ; 
		}
		return val ;
	}
}
