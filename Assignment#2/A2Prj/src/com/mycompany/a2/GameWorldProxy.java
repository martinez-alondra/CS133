package com.mycompany.a2;

import java.util.Observable;
/**
 * @author Ali H. Iqbal
 */

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		// TODO Auto-generated constructor stub
		this.gw = gw;
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public int getWidthX() {
		// TODO Auto-generated method stub
		return this.gw.getWidthX();
	}
	public void loadMissiles() {
		
	}
	
	public void shipSpeed(int speed) {
		// TODO Auto-generated method stub

	}

	public int getHeightY() {
		// TODO Auto-generated method stub
		return this.gw.getHeightY();
	}

	public void setWidthX(int width) {
		// TODO Auto-generated method stub
		
	}

	public void setHeightY(int height) {
		// TODO Auto-generated method stub
		
	}
	
	public int getOriginX() {
		// TODO Auto-generated method stub
		return this.gw.getOriginX();
	}

	public int getOriginY() {
		// TODO Auto-generated method stub
		return this.gw.getOriginY();
	}

	public void setOriginX(int xOrigin) {
		// TODO Auto-generated method stub
	}

	public void setOriginY(int yOrigin) {
		// TODO Auto-generated method stub
	}
	
	public void setLives(int playerLives) {
		// TODO Auto-generated method stub

	}

	public int getLives() {
		// TODO Auto-generated method stub
		return this.gw.getLives();
	}

	public int getTime() {
		// TODO Auto-generated method stub
		return this.gw.getTime();
	}

	public void setScore(int playerScore) {
		// TODO Auto-generated method stub

	}

	public int getScore() {
		// TODO Auto-generated method stub
		return this.gw.getScore();
	}

	public void tick() {
		// TODO Auto-generated method stub

	}

	public void newStation() {
		// TODO Auto-generated method stub

	}

	public void newAstroid() {
		// TODO Auto-generated method stub

	}

	public void newFlyingSaucer() {
		// TODO Auto-generated method stub

	}

	public void newMissile() {
		// TODO Auto-generated method stub

	}

	public void newShip() {
		// TODO Auto-generated method stub

	}

	public void steerShip(int steeringDirection) {
		// TODO Auto-generated method stub

	}

	public void adjustSpeed(int speed) {
		// TODO Auto-generated method stub

	}

	public void jump() {
		// TODO Auto-generated method stub

	}

	public void newSupply() {
		// TODO Auto-generated method stub

	}

	public void removeSpaceStation() {
		// TODO Auto-generated method stub

	}

	public void removeAsteroid() {
		// TODO Auto-generated method stub

	}

	public void removeFlyingSaucer() {
		// TODO Auto-generated method stub

	}

	public void removeMissile() {
		// TODO Auto-generated method stub

	}

	public void removeShip() {
		// TODO Auto-generated method stub

	}

	public int getMissiles() {
		// TODO Auto-generated method stub
		return this.gw.getMissiles();
	}

	public void printMap() {
		// TODO Auto-generated method stub

	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	public void setSound() {
		// TODO Auto-generated method stub
		
	}

	public boolean getSound() {
		// TODO Auto-generated method stub
		return this.gw.getSound();
	}

}