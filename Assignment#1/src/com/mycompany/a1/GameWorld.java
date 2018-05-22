package com.mycompany.a1;
import java.util.ArrayList;
/**
 * @author Ali H. Iqbal
 */
public class GameWorld {

	/*------Fixed Game World Variables------*/
	private final static float widthX = 1024;
	private final static float heightY = 768; 
	//Game World Stats
	private int timer = 0; 
	private int gwScore = 0;
	private int lives = 3; 
	private Ship ship; 
	//Array stores game objects
	private ArrayList<GameObject> worldObjects = new ArrayList<GameObject>(); 
	
	/*----Getters and setters----*/
	public void setGameScore(int s) { 
		this.gwScore = s; 
	}
	public int getGameScore() { 
		return gwScore; 
	}
	public double getWidthX() { 
		return widthX; 
	}
	public double getHeightY() { 
		return heightY; 
	}

	/*----Game World command methods----*/

	public void init(){
		ship = new Ship(widthX,heightY);
		worldObjects.add(ship);//adds ship  to GW
	}
	public void newAstroid() {
		worldObjects.add(new Asteroid());//adds newAsteroid to GW
	}
	public void newFlyingSaucer() {
		worldObjects.add(new FlyingSaucer());//adds newflyingSaucer to GW
	}
	public void newStation() {
		worldObjects.add(new SpaceStation());//adds newSpaceStation to GW
	}
	public void newShip() {//adds newShip to GW
		if (!(ship instanceof Ship)) {
			ship = new Ship(widthX,heightY);	
			worldObjects.add(ship);
		}
	}

	public void increaseAccel() { 
		if (ship instanceof Ship)
			ship.accel(1); //increases acceleration by 1
		else 
			System.out.println("Error: Unable to use 'increase'");
	}
	

	public void decreaseAccel() { 
		if (ship instanceof Ship)
			ship.accel(-1);//decrease acceleration
		else 
			System.out.println("Error: Unable to use 'decrease'");
	}
	
	public void rightTurn() { 
		if (ship instanceof Ship)
			ship.dir(1); //right turn ship by 1
		else 
			System.out.println("Error: Unable to use 'right' turn");	
	}
	
	public void leftTurn() { 
		if (ship instanceof Ship)
			ship.dir(-1); //left turn ship by 1
		else 
			System.out.println("Error: Unable to use 'left' turn");
	}
	
	public void jump() { //jump command move ship to start
		if (ship instanceof Ship) {
			ship.setXlocation(512.0);//X+Y location
			ship.setYlocation(384.0);
		}
		else
			System.out.println("Error: Unable to use 'jump'");
	}
	
	public void fireMissile() { //fires missile
		if (ship instanceof Ship) {
			//Assign maxMissiles to ship
			int maxMissiles = ship.getShipMissiles();
			//Add missile and decrement
			if (maxMissiles > 0) {
				worldObjects.add(new Missile(ship.getObjDir(),ship.getXlocation(),ship.getYlocation()));
				//decrement missile
				ship.setShipMissiles(maxMissiles - 1);
			}
			else //print statement when maxMissiles = 0
				System.out.println("No More Missiles!");	
		} else
			System.out.println("Error: Unable to use 'fire'");
	}
	
	public void newSupply() {  //newSupply missiles 12 count
		if (ship instanceof Ship)
			ship.setShipMissiles(12); 
		else 
			System.out.println("Error: Unable to use 'Supply'");	
	}
	
	public void killedAstroid() { //kills asteroid with missile
		//fields
		int missIndx = 0;
		int astroIndx = 0;
		boolean miss = false;
		boolean astro = false;
		int arr = worldObjects.size();
		
		//check if both boolean true
		for(int k = 0; k < arr; k++) {
			if (worldObjects.get(k) instanceof Asteroid) {
				astroIndx = k;
				astro = true; 
			}
			else if (worldObjects.get(k) instanceof Missile) {
				missIndx = k;
				miss = true;  
			}
			if (astro ==  true && miss == true)
				break;
		}
		if(astro == true && miss == true) {
			gwScore += 100;
			//remove missile and asteroid from Game World
			if (astroIndx > missIndx) { 	
				worldObjects.remove(astroIndx);
				worldObjects.remove(missIndx);	
			}
			else {
				worldObjects.remove(missIndx);
				worldObjects.remove(astroIndx);
			}
		}
		else
			System.out.println("Error: Unable to use 'Kill'");
	}
	
	
	public void crashed() { // ship crashes with an asteroid

		if (ship instanceof Ship ) {
			int astroIndx = 0;
			int shipIndx = 0;
			boolean ast = false;
			boolean shp = false;
			
			int arr = worldObjects.size();
			//check if both boolean true
			for (int c = 0; c < arr; c++) {
				if(worldObjects.get(c) instanceof Ship) {
					shipIndx = c;
					shp = true;
				}
				else if (worldObjects.get(c) instanceof Asteroid) {
					astroIndx = c;
					ast = true;
				}
				if (ast == true && shp == true)
					break;
			}
			if(ast == true && shp == true) {
				//remove objects if true
				if (astroIndx > shipIndx) {
					worldObjects.remove(astroIndx);
					worldObjects.remove(shipIndx);	
				}
				else {
					worldObjects.remove(shipIndx);
					worldObjects.remove(astroIndx);
				}
				ship = null;
				//decrement lives
				if(lives > 0) 
					lives--;
				else //Game over, lives=0
					System.out.println("Game is Over!");
			}
			else
				System.out.println("Error: Unable to use 'Crash'");
		}
	}
	
	public void hit() { // ship and flyingSaucer collide
		if (ship instanceof Ship ) {
			//fields
			int flysIndx = 0;
			int shipIndx = 0;
			boolean flys = false;
			boolean shp = false; 
			int arr = worldObjects.size();	
			
			//check if both booleans true
			for (int h = 0; h < arr; h++) {
				if(worldObjects.get(h) instanceof Ship) {
					shipIndx = h;
					shp = true;
				}
				else if (worldObjects.get(h) instanceof FlyingSaucer) {
					flysIndx = h;
					flys = true;
				}
				if (flys ==  true && shp == true)
					break;
			}
			if(flys == true && shp == true) {
				//remove objects if booleans true
				if (flysIndx > shipIndx) {
					worldObjects.remove(flysIndx);
					worldObjects.remove(shipIndx);	
				}
				else {
					worldObjects.remove(shipIndx);
					worldObjects.remove(flysIndx);
				}
				ship = null;
				//decrement lives
				if(lives > 0) 
					lives--;
				else //Game over, lives=0
					System.out.println("Game is Over!");
			}
			else
				System.out.println("Error: Unable to use 'Hit'");
		}
	}
	
	@SuppressWarnings("unused")
	public void wacked() { // Asteroid and flying saucer collide
		int astro1=0;
		int flys1=0;
		int ctr = 0;
		int arr = worldObjects.size();
		
		//Check for one asteroids, one flyingSaucer in Game World
		for(int w = 0; w < arr; w++) {
			if(worldObjects.get(w) instanceof Asteroid) {
				ctr++;
				if( ctr == 1)
					astro1 = w;
					break;
				}
			else if(worldObjects.get(w) instanceof FlyingSaucer) {
				ctr++;
				if( ctr == 1)
					flys1 = w;
					break;
			}
			else break;
		} // remove both flyingSaucer and asteroid
		if(ctr >= 2) {
			worldObjects.remove(flys1);
			worldObjects.remove(astro1);
		}
		else
			System.out.println("Error: Unable to use 'Wacked'");
	}
	
	public void exterminate() { //two Asteroids collide
		int astro1=0;
		int astro2=0;
		int ctr = 0;
		int arr = worldObjects.size();
		
		//Check for both asteroids 
		for(int e = 0; e < arr; e++) {
			if(worldObjects.get(e) instanceof Asteroid) {
				ctr++;
				if( ctr == 2)
					astro2 = e;	
				else if( ctr == 1) {
					astro1 = e;
					break;
				}
				else break;
			}
		} // remove both the asteroids
		if(ctr >= 2) {
			worldObjects.remove(astro2);
			worldObjects.remove(astro1);
		}
		else
			System.out.println("Error: Unable to use 'Exterminate'");
	}
	

	public void tick() { //update time, object position, decrements fuel
		timer++;
		int arr = worldObjects.size();
		if(arr > 0) { 
			for( int t = arr-1; t >= 0; t--) {
				//update object position
				if (worldObjects.get(t) instanceof IMovable) {
					IMovable pos = (IMovable)worldObjects.get(t);
					//update
					pos.moving();
				} // reduce missile fuel 
				if (worldObjects.get(t) instanceof Missile) {
					Missile miss = (Missile)worldObjects.get(t);
					int fuel = miss.getObjFuel();
					if( fuel > 1)
						//decrement fuel
						miss.setObjFuel(fuel - 1);
					else {  // remove missile if fuel is zero
						miss = null;
						worldObjects.remove(t);
					}
				} // Toggle blink light if rate is zero
				if (worldObjects.get(t) instanceof SpaceStation) {
					SpaceStation spc = (SpaceStation)worldObjects.get(t);
					if(timer % spc.getBlinkRate() == 0) {
						//turn off 
						if (spc.lightOn())
							spc.light(false);	
						else //turn on
							spc.light(true);
					}
				}
		
			}
		}
		else
			System.out.println("Error: Unable to use 'Tick'");
	}
	
	//prints out score, missiles, and elapsed time
	public void print() {
		System.out.println("Game-score=" + gwScore + " Missiles=" + ship.getShipMissiles() + " Time:"+ timer);
	}
	
	//prints out game objects in world
	public void printMap() {
		int arr = worldObjects.size();
		//output world objects
		for(int m = 0; m < arr; m++)
			System.out.println(worldObjects.get(m));
	}
	
}