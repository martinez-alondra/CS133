package com.mycompany.a2;
/**
 * @author Ali H. Iqbal
 */
public interface IGameWorld {
	
	public int getWidthX();
	public void setWidthX(int width);
	public void setHeightY(int height);
	public int getHeightY();
	public int getOriginX();
	public int getOriginY();
	public void setOriginX(int xOrigin);
	public void setOriginY(int yOrigin);
	public void setLives(int Lives);
	public int getLives();
	public int getTime();
	public void setScore(int Score);
	public int getScore();
	public void steerShip(int steerDir);
	public void shipSpeed(int speed);
    public void init();
	public void newAstroid();
	public void newFlyingSaucer();
	public void newStation();
	public void newShip();
	public void newMissile();
	public void jump();
	public void loadMissiles();
	public void tick();
	public void printMap();
	public void removeSpaceStation();
	public void removeAsteroid();
	public void removeFlyingSaucer();
	public void removeMissile();
	public void removeShip();
	public int getMissiles();
	public void print();
	public void setSound();
	public boolean getSound();
		
}
