package com.mycompany.a2;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Dialog;
/**
 * @author Ali H. Iqbal
 */
public class GameWorld extends Observable implements IGameWorld {

	/*------Fixed Game World Variables------*/
	private int widthX = 1024;
	private int heightY = 768; 
	private int originX = 0;
	private int originY = 0;
	
	//Game World Stats
	private int timer = 0; 
	private int gwScore = 0;
	private int lives = 3; 
	private int missiles = 0;
	private Ship ship;
	private boolean sound = true;
	private Random ran = new Random();
	
	private GameObjectCollection gwCollection = new GameObjectCollection();
	
	//Array stores game objects
	//	private ArrayList<GameObject> worldObjects = new ArrayList<GameObject>(); 
	
	/*----Getters and setters----*/
	
	public void setWidthX(int width) {
		this.widthX = width;
	}
	
	public void setHeightY(int height) {
		this.heightY = height;
	}
	
	public int getWidthX() { 
		return widthX; 
	}
	public int getHeightY() { 
		return heightY; 
	}
	
	
	
	public void setOriginX(int originX) {
		this.originX = originX;
	}
	
	public void setOriginY(int originY) {
		this.originY = originY;
	}
	
	public int getOriginX() { 
		return originX; 
	}
	public int getOriginY() { 
		return originY; 
	}
	
	public void setLives(int lives) {
		this.lives = lives;
		this.setChanged();
		this.notifyObservers();
	}
	
	public int getLives() {
		return lives;
	}
	
	public int getMissiles() {
		return this.missiles;
	}
	public boolean getSound() {
		return this.sound;
	}
	
	public void setSound() {
		this.sound = !this.sound;
		this.setChanged();
		this.notifyObservers();
		
	}
	
	public int getTime() {
		return timer;
	}
	public int getScore() { 
		return this.gwScore; 
	}
	public void setScore(int s) { 
		this.gwScore = s;
		this.setChanged();
		this.notifyObservers();
	}
	

	
	public GameWorld() {
		init();
	}

	/*----Game World command methods----*/

	
	public void init(){
		this.newAstroid();
		this.newFlyingSaucer();
		this.newStation();
		this.notifyObservers();
		
	}

	
	public void newAstroid() {
		Asteroid as = new Asteroid();
		as.setObjColor(ColorUtil.YELLOW);
		as.setObjDir(ran.nextInt(360));
		as.setObjSize(ran.nextInt(25) + 6); // size between 6..30
		as.setObjSpeed(ran.nextInt(11));
		as.setXlocation(ran.nextInt(this.widthX));
		as.setYlocation(ran.nextInt(this.heightY));
		gwCollection.add(as);
		this.setChanged();
		this.notifyObservers();
	}
	
	
	
	
	public void newFlyingSaucer() {
		FlyingSaucer fly = new FlyingSaucer();
		fly.setObjColor(ColorUtil.GREEN);
		fly.setObjDir(ran.nextInt(360));
		int size = (ran.nextInt(2) + 1) * 10; // size is either 10 or 20
		fly.setObjSize(size);
		fly.setObjSpeed(ran.nextInt(11));
		fly.setXlocation(ran.nextInt(this.widthX));
		fly.setYlocation(ran.nextInt(this.heightY));
		gwCollection.add(fly);
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public void newStation() {
		SpaceStation s = new SpaceStation();
		s.setBlinkRate(ran.nextInt(6));
		s.setObjColor(ColorUtil.LTGRAY);
		s.setXlocation(ran.nextInt(this.widthX));
		s.setYlocation(ran.nextInt(this.heightY));
		gwCollection.add(s);
		this.setChanged();
		this.notifyObservers();
	}
	public void newShip() {
		if (ship == null) {
			ship = new Ship();
			ship.setObjColor(ColorUtil.BLUE);
			ship.setObjDir(0);
			ship.setShipMissiles(12);
			this.missiles = ship.getShipMissiles();
			ship.setObjSpeed(0);
			ship.setXlocation(this.widthX/2);
			ship.setYlocation(this.heightY/2);
			gwCollection.add(ship);
		}
		else {
			System.out.println("There's already a Ship!");
		}
		this.setChanged();
		this.notifyObservers();
	}
	public void newMissile() {
		if (this.missiles > 0) {
			Missile m = new Missile();
			m.setObjColor(ColorUtil.CYAN);
			m.setObjDir(ship.getObjDir()); // set to the ships direction
			m.setObjFuel(10);
			m.setObjSpeed(ship.getObjSpeed() + 5); // set to the ships speed + constant
			m.setXlocation(ship.getXlocation());
			m.setYlocation(ship.getYlocation());
			gwCollection.add(m);
			ship.setShipMissiles(ship.getShipMissiles()-1);
			this.missiles = ship.getShipMissiles();
		}
		else {
			System.out.println("Out of Missiles!");
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void loadMissiles() {
		ship.setShipMissiles(12);
		this.missiles = ship.getShipMissiles();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void steerShip(int dir) {
		ship.steer(dir);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void shipSpeed(int spd) {
		int newSpd = ship.getObjSpeed() + spd;
		if (newSpd > 10) {
			ship.setObjSpeed(10);
		}
		else {
			ship.setObjSpeed(newSpd);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void jump() {
		ship.setXlocation(this.widthX/2);
		ship.setYlocation(this.heightY/2);
		this.setChanged();
		this.notifyObservers();
	}

	public void removeSpaceStation() {
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			if (o instanceof SpaceStation) {
				it.remove();
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeAsteroid() {
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			if (o instanceof Asteroid) {
				it.remove();
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeFlyingSaucer() {
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			if (o instanceof FlyingSaucer) {
				it.remove();
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeMissile() {
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			if (o instanceof Missile) {
				it.remove();
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void removeShip() {
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			if (o instanceof Ship) {
				it.remove();
				this.ship = null;
				this.missiles = 0;
				break;
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	

	public void tick() { //update time, object position, decrements fuel
		this.timer++;
		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject obj = it.getNext();
			if (obj instanceof IMoveable) {
				if (obj instanceof Missile) {
					((Missile)obj).setObjFuel(((Missile)obj).getObjFuel() -1);
					if (((Missile) obj).getObjFuel() <= 0) {
						it.remove();
					}
					else {
						((IMoveable) obj).moving();
					}
				}
				else {
					((IMoveable)obj).moving();
				}
			}
			else if (obj instanceof SpaceStation) {
				int r = ((SpaceStation)obj).getBlinkRate();
				if (r != 0) {
					if (this.timer % r == 0) {
						if (((SpaceStation) obj).getBlinkStatus() == true) {
							((SpaceStation) obj).setBlinkStatus(false);
						}
						else {
							((SpaceStation) obj).setBlinkStatus(true);
						}
					}
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	//prints out score, missiles, and elapsed time
	public void print() {
		System.out.println("\nScore: " + this.getScore() +
				"  Missiles: " + this.getMissiles() +
				"  Time: " + this.getTime() +
				"  Lives: " + this.getLives());
	}
	
    //prints out game objects in world
    public void printMap() {
    		System.out.print("\n\n");
    		IIterator it = this.gwCollection.getIterator();
		while (it.hasNext()) {
			GameObject o = it.getNext();
			System.out.println(o.toString());
		}
    }
	


	public void about() {
		Dialog.show("About", "Creator: Ali Iqbal \n"
				+ "CSc 133 \nVersion: 2", "OK", null);
	}




}