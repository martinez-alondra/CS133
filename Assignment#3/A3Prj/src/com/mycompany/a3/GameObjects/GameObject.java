package com.mycompany.a3.GameObjects;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.mycompany.a3.GameWorld;
/**
 * @author Ali H. Iqbal
 *
 */
//Class defines methods used for game objects
public abstract class GameObject {
	//set object location
	private float xLocation;
	private float yLocation;
	private int color;
   
	//GameObject constuctor
	GameObject(){
		xLocation = randXloc(); 
		yLocation = randYloc();
	}
	
	//get object xLocation
	public float getxLocation(){
		return xLocation;
	}
	
	//set the object x location
	public void setxLocation(float newX){
		xLocation = newX;
	}

	// random x location
	public float randXloc(){
		int xLocationMax =  GameWorld.getWidthX();
		int xLocationMin =   0;
		Random ran = new Random();
		float randXLoc = ran.nextInt(xLocationMax - xLocationMin)  + xLocationMin;
		return randXLoc;
	}
	
	//get the object's current location y
	public float getyLocation(){
		return yLocation;
	}
	
	//set the object's current location y
	public void setyLocation(float newY){
		yLocation = newY;
	}
		
	// Random y location
	public float randYloc(){
		int yLocationMax =  GameWorld.getHeightY();
		int yLocationMin =   0;
		Random ran = new Random();
		float randYLoc = ran.nextInt(yLocationMax - yLocationMin)  + yLocationMin;
		return randYLoc;
	}
	//get color method
	public int getColor(){
		return color;
	}
	//set color method
	public void setColor(int colorObj){
		color = colorObj;
	}
	//String method
	public String toString() {

		String myDesc = " loc=" + getxLocation()+ "," + getyLocation()+ " " + "color: " + "[" + ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor()) + "," + ColorUtil.blue(getColor()) + "]";
		return myDesc; 
	}
	
		
}
