package com.mycompany.a3.GameObjects;

import com.mycompany.a3.GameWorld;
import com.mycompany.a3.Interfaces.*;
import java.util.Random;
/**
 * @author Ali H. Iqbal
 */
//Abstract class defines methods for movable objects
public abstract class MovableObjects extends GameObject implements IMovable{
	//data variables
	private int speed;
	private int dir; 
	
	MovableObjects(){
	    speed = ranSpeed();
		dir = randDirection();
		
	}
	//method for moving objects
	public void move(){
	
		int theta = 90 - dir;
		float dX =  (float)Math.cos(Math.toRadians(theta)) * speed;
		float dY =  (float)Math.sin(Math.toRadians(theta)) * speed;
		
		if ((dX + getxLocation() + (30/2) > GameWorld.getWidthX()) || (dX + getxLocation() - (30/2) < 0)){
			dX = -dX;
			setDirection(360-getDirection());
		}

		if ((dY + getyLocation() + (30/2) > GameWorld.getHeightY()) || (dY + getyLocation() - (30/2) < 0)){
			dY = -dY;
			setDirection(180-getDirection());
		}
		if(getxLocation()==0){
			dX = -dX;
			setDirection(360-getDirection());
		}
		
		if(getyLocation()==0){
			dY = -dY;
			setDirection(180-getDirection());
		}
	    float newxLoc= getxLocation() + dX;
		float newyLoc = getyLocation() + dY;
		setxLocation(Math.round(newxLoc));
		setyLocation(Math.round(newyLoc));
		
	}
	
	//set the movable object's speed 
	public void setSpeed(int newSped){
		speed = newSped;
	}
	
	//get movable object's speed 
		public int getSpeed(){
			return speed;
		}

	//Computes random speed for object
	public int ranSpeed(){
		int max =   10;
		int min =  0;
		Random rand = new Random();
		int randSpeed = rand.nextInt(max - min)  + min;
		return randSpeed;
		
	}
	
	//sets new object direction
		public void setDirection(int newDir){
			dir = newDir;
		}
		
	//get Movable object's direction 
	public int getDirection(){
		return dir;
	}

	//computes random direction
	public int randDirection(){
		int minDir =  0;
		int maxDir =   365;
		Random rand = new Random();
		int randDir = rand.nextInt(maxDir - minDir)  + minDir;
		return randDir;	
	}
	
	//Movable object string method
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Speed="+ getSpeed() + " " +  " dir="+ getDirection() ;
		return parentDesc + myDesc; 
	}
}
