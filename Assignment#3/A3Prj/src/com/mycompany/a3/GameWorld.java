package com.mycompany.a3;

import com.mycompany.a3.Interfaces.*;
import com.mycompany.a3.Sounds.Sound;
import com.mycompany.a3.GameObjects.*;
import java.util.Observable;
import java.util.Vector;
import com.codename1.ui.Dialog;
/**
 * @author Ali H. Iqbal
 */
//This class builds the gameWorld 
public class GameWorld  extends Observable implements IGameWorld {

///Local private data values
   private static int WidthX = 824; 
   private static int HeightY = 568;
   private static int lives = 3; 
   private static int cTimer = 0; 
   private static int gwScore = 0; 
   public static boolean inPlay;
   boolean rmShip = false;
   boolean rmMissile = false;
   boolean rmSaucer = false;
   boolean rmAstroid = false;
   private boolean sound;
    
   private Ships newShip = new Ships();
   //new game object collection 
   private static GameObjectCollection gwObjects  = new GameObjectCollection(); 
 	
   //Vector to track collisions
   private Vector<GameObject> CollisionShip = new Vector<GameObject>();
   private Vector<GameObject> CollisionMissile = new Vector<GameObject>();
   private Vector<GameObject> CollisionAstro = new Vector<GameObject>();
   private Vector<GameObject> CollisionSaucer = new Vector<GameObject>();
   
   public void init(){
   }
   
   public void proxy(){
    	this.setChanged();
        GameWorldProxy pxy = new GameWorldProxy(this);
        this.notifyObservers(pxy);
   }
   
   //set and get game play sound 
   public static boolean getinPlay(){
	   return inPlay; 
   }
   public void setinPlay(boolean inPlay){
	   this.inPlay = inPlay; 
   }

   //Alternate from pause to play
   public void inPlay(){
	   if(getinPlay() == false){
		   setinPlay(true);
	   }else{setinPlay(false);}
	  
	   proxy();
   }
   
   //from play to pause mode 
   public void inPlayGameOver(){
	   setinPlay(false);
	   proxy();
   }
   
   //method returns collection for mapView
   public static GameObjectCollection find(){
	   return gwObjects;
   }
   
   public boolean getSound(){
	   return sound; 
   }
   public void setSound(boolean s){
	   this.sound = s; 
   }
 ///Alternate sound on and off 
   public void changeSoundOnOff(){
	   
	   if(getSound() == true){
		   setSound(false);
	   }else{setSound(true);}
	   proxy();
   }
  
   //get the time of game
   public int getcTimer(){
	   return cTimer;
   }
   
   //set the game time
   public void setcTimer(int newcTimer){
	   cTimer = newcTimer;
   }
	
	//get player lives
	public int getPlayerlives(){
		return lives;
	}
	
	//set lives
	public void setPlayerlives(int newlives){
		lives = newlives;
	}
	//get the game score 
	public int getgwScore(){
		return gwScore;
    }
	
	//set the game score 
	public void setgwScore(int newgwScore){
		gwScore = newgwScore;
	}
	   
	//get game width  
   public static int getWidthX(){
		return WidthX;
	}
   
   //modify height and width of gameworld
   public void setDimension(int w, int h){
	   this.WidthX =  w;
	   this.HeightY = h;
   }

	//get width  
   public static int getHeightY(){
		return HeightY;
   }
   
	//disable while in paused
	public void disableRefuel(){
		Game.bRefuel().setEnabled(false);
	}
	
	//enable inPlay
	public void enableRefuel(){
		Game.bRefuel().setEnabled(true);
	}
	
	//play to pause
		public void playToPause(){
		    Game.bPause().setText("Pause");
		    setSound(false);
		    proxy();
		}
		
 //pause to play
	public void pauseToPlay(){
	    Game.bPause().setText("Play");
	    setSound(true);
	    proxy();
	}
   
   //locates ship in array list
   public boolean someShip(){
    	
    	boolean ship= false;

	    IIterator it = gwObjects.getIterator();
		while (it.hasNext())
			if (it.getNext() instanceof Ships){
				return true;
			}
		return ship;
    }
   
   //locates station in array list
   public boolean someStation(){
    	
    	boolean station = false;
 	    
    	IIterator it = gwObjects.getIterator();
 		while (it.hasNext())
 			if (it.getNext() instanceof SpaceStation){
 				return true;
 			}
 		return station;
    }
   
   //locates asteroid in array list
   public boolean someAsteroid(){
    	
    	boolean astro = false;

	    IIterator it = gwObjects.getIterator();
		while (it.hasNext())
			if (it.getNext() instanceof Asteroids){
				return true;
			}
		return astro;   
    }
   
   //locates two actroids 
   public boolean someTwoAstroids(){
    	
    	boolean twoAstros = false;
        int cnt = 0;  
  	    IIterator it = gwObjects.getIterator();
  		while (it.hasNext())
  			if (it.getNext() instanceof Asteroids){
  				cnt++;
  				if(cnt >= 2){
    				twoAstros = true;
  				}
  			}
  		return twoAstros; 
    }  
   
   
 //locates missle in array list
   public boolean someMissle(){
    	
       boolean missle = false;
 	   IIterator it = gwObjects.getIterator();
 		while (it.hasNext())
 			if (it.getNext() instanceof Missiles){
 				return true;
 			}
 		return missle; 
    }

	// returns place of ship
	public GameObject shipPlace(){
		IIterator it = gwObjects.getIterator();
		GameObject ship;
		while (it.hasNext()){
			ship = (GameObject) it.getNext();
			if (ship instanceof Ships)
				return ship;
		}
		return null;
	}
	
	//returns astroid place
	public GameObject astroPlace(){
		IIterator it = gwObjects.getIterator();
		GameObject asteroid;
		while (it.hasNext()){
			asteroid = (GameObject) it.getNext();
			if (asteroid instanceof Asteroids)
				return asteroid;
		}
		return null;
	}
	
	//return missle place
	public GameObject misslePlace(){ 
		IIterator it = gwObjects.getIterator();
		GameObject missile;
		while (it.hasNext()){
			missile = (GameObject) it.getNext();
			if (missile instanceof Missiles)
				return missile;
		}
		return null;
	}
	
	//station place
	public GameObject stationPlace(){
		IIterator it = gwObjects.getIterator();
		GameObject spStation;
		while (it.hasNext()){
			spStation = (GameObject) it.getNext();
			if (spStation instanceof SpaceStation)
				return spStation;
		}
		return null;
	}
	
	//new astroid
   public void newAstroid(){
	  //no use in pause
	  if(getinPlay()==false){
	      System.out.println("Game is Paused");
		  return;
	  }    
	  Asteroids astroAdd = new Asteroids();		  
	  gwObjects.add(astroAdd);
	  System.out.println("Adding asteroid to game world");
	  System.out.println(astroAdd.toString());
	  System.out.println("---------" + "\nAsteroid now in collection");
	  proxy();
   }
   
   //new space station
   public void newStation(){

	//no use in pause
	if(getinPlay()==false){
			System.out.println("Game is Paused");
			return;
	 }  //check if station exits
	  if(someStation() == false) {
		  SpaceStation stationAdd = new SpaceStation();	  
		  gwObjects.add(stationAdd);
		  System.out.println("Added space station to game world");
		  System.out.println(stationAdd.toString());
		  System.out.println("---------" + "\nSpace Station now in collection");
		  proxy();
	 
	   }else{
		  System.out.println("Already a Space Station in game world"); 
	  }
	  
   }
   
   //new ship
   public void newShip(){   
	   
		//no use in pause
		if(getinPlay()==false){
		      System.out.println("Game is Paused");
			  return;
		}
		
	   //check if ship exits  
	   if(someShip() == false){
		   
		   gwObjects.add(newShip);
		   System.out.println("Adding ship to game world");
		   newShip.setMissleCount(10); 
		   System.out.println(newShip.toString());
		   System.out.println("---------" + "\nShip now in collection.");
		   proxy();

	    }else{
	       System.out.println("Already a Ship in game world"); 
	    }
		 
   }
   
  //increase the ships speed
   public void speedIncrease(){
	   
		//no use in pause
		if(getinPlay()==false){
		      System.out.println("Game is Paused");
			  return;
		}
	   
	   //chek does ship exits
	   if(someShip() == true){   
	    
		   if(newShip.getSpeed() < 10 & newShip.getSpeed() >= 0){
		     newShip.SpeedIncrease();
		     System.out.println("Ships speed increased");
		     System.out.println(newShip.toString());
		     System.out.println("---------" + "\nSpeed incresed in collection.");
		     proxy();
		  	 
	       }
	        else{
		     System.out.println("Speed not in range");
	       }
		
	   }else{
		   System.out.println("There is no ship in game world!");
	   }
	   
	   
   }
   //decrease ship speed
   public void speedDecrease(){
	  //no use in pause
		if(getinPlay()==false){
		      System.out.println("Game is Paused");
			  return;
		}
		//checks if ship exits
	   if(someShip() == true){   
	      if(newShip.getSpeed() <= 10 & newShip.getSpeed() > 0){ //in range
		     newShip.SpeedDecrease();
		     System.out.println("Ships speed decreased"); 
		     System.out.println(newShip.toString()); 
		     System.out.println("---------" + "\nSpeed decreased in collection.");
		     proxy();
	      }
	      else{
		     System.out.println("Speed not in range");
	      }
	   }else{ //no ship
		   System.out.println("There is no ship in game world!");
	   }
	   
   }

   //left turn
   public void leftTurn(){
	//no use in pause	
	if(getinPlay()==false){
		 System.out.println("Game is Paused");
		 return;
	}     
	//checks if ship exits 
	if(someShip() == true){   
		
	    if(newShip.getDirection() > 0 & newShip.getDirection() <= 360){ //in range
	       newShip.turnLeft();
	       System.out.println("Ship Turned Left");
	       System.out.println(newShip.toString());
		   System.out.println("---------" + "\nLeft Turn in collection.");
		   proxy();
	    }
	    else{
		    System.out.println("Left turn not in range");
	    } 
	 }else{
		   System.out.println("There is no ship in game world!"); 
	   }
	   
   }
   
 //right turn 
   public void rightTurn(){ 
	//no use in pause	
	if(getinPlay()==false){
			 System.out.println("Game is Paused");
			 return;
	 }    
	//check if ship exits
	if(someShip() == true){   
		
	    if(newShip.getDirection() >= 0 & newShip.getDirection() < 360){ //in range
	    		System.out.println("Ship Turned Right");
	    		newShip.turnRight();
		    	System.out.println(newShip.toString());
		    	System.out.println("---------" + "\nRight Turn in collection.");
		    	proxy();
	    }
	    else{
	    		System.out.println("Right turn not in range"); 
	     }
	   
     }else{
	    System.out.println("There is no ship in game world!"); 
     }
	
   }
   
  //fire ship missiles
   public void fireMissile(){
	   
	//no use in pause 	
	 if(getinPlay()==false){
				 System.out.println("Game is Paused");
				 return;
	 }  
	 //check if ship exists  
	   if(someShip() == true){
		  Missiles newMiss = new Missiles( (float) newShip.getxLocation(), (float) newShip.getyLocation(), newShip.getDirection());
		// ship out of missiles
		  if(newShip.getMissleCount() == 0){ 
		        System.out.println("Ship is out of Missiles");
	      }
	      else{
			    Sound boom = new Sound("missile.wav");
			    boom.play();
	        //change missile location
	    	    newMiss.setxLocation(newShip.getxLocation());
	    	    newMiss.setyLocation(newShip.getyLocation());
	    	    newMiss.SetFuel(100);

			    gwObjects.add(newMiss);
		        int currMiss = newShip.getMissleCount();
		        newShip.setMissleCount(currMiss-1);
		        System.out.println("Fired a Missile.");
		        newMiss.setDirection(newShip.getDirection());
		        newMiss.setSpeed(newShip.getSpeed()+1);
		        System.out.println(newMiss.toString());
		        System.out.println("Missiles left: " + newShip.getMissleCount());
		        System.out.println("---------" + "\nFire missile in collection.");
		        proxy();
	     }
		   
	   }else{
		    System.out.println("There is no ship in game world!"); 
	     }
   }
   
   //missile refuel
   public void missileRefuel(){
    	IIterator it = gwObjects.getIterator();
    	Object currObj= new Object();
    	while (it.hasNext()){
		    	currObj = it.getNext();
		    	if ((currObj instanceof Missiles)){
		    	  if(((Missiles) misslePlace()).getContainFlag()==false){
		    		   ((Missiles) misslePlace()).SetFuel(100);
		    	  }
		        }
     	}
   }
   
  //returns missle count
   public int getMissleCnt(){
	   return newShip.getMissleCount();
   }

   //ship jumps
    public void jump(){
   //no use in pause	
   if(getinPlay()==false){
    	System.out.println("Game is Paused");
    	return;
    }  	
    	
    //if ship exits
     if(someShip() == true){
    	 //set new location
    	  float xOrigin = getWidthX()/2;
    	  float yOrigin = getHeightY()/2;
    	  newShip.setxLocation(xOrigin);
    	  newShip.setyLocation(yOrigin);
    	  System.out.println("Ship Jumped");
    	  System.out.println(newShip.toString());

	     System.out.println("---------" + "\nShip jump in collection.");
	     proxy();
    	  
     }else{
		  System.out.println("There is no ship in game world!"); 
	     }
    	
    }
   
    //resupply missles (also in pause)
    public void loadMissiles(){
     //if ship exits
     if(someShip() == true){	
    	  if(newShip.getMissleCount() >=0 & newShip.getMissleCount() < 10){
    		  newShip.setMissleCount(newShip.getMissileCountMax());
    		  System.out.println("Max missiles loaded");
    		  System.out.println("Missiles: " + newShip.getMissleCount());
		     
		      System.out.println("---------" + "\nMissiles now 10 in collection");
		      proxy();
    	  }
    	  else{
    		  System.out.println("Missile limit is Max");
    	  }
      }else{
    	  	  System.out.println("There is no ship in game world!");
     }
    
    }
    
    //ship crashes into asteroid
    public void shipCrashastro(){
    	
    if(someAsteroid() == true && someShip() == true){	
    	
    	int decLives = getPlayerlives();
    	if(getPlayerlives()>0){
    			setPlayerlives(decLives - 1);
    			System.out.println("Player Lives: "+ getPlayerlives());
    			System.out.println("Ship crashed into astroid");
    	}else{
    		    setPlayerlives(4);
    	}
	     if(decLives > 0){
			gwObjects.remove(shipPlace());
			gwObjects.remove(astroPlace());
		    System.out.println("---------" + "\nShip crash into astroid in collection");
		    proxy();
			
	     }if(getPlayerlives() == 0){
	    	 System.out.println("No more lives, Game Over!");
	    	 Sound end = new Sound("end.wav");
	    	 System.out.println("Started New Game");
	    	 end.play();
	     }  
     }else{System.out.println("Add a ship or asteroid to game world!"); }
    }

    //Missile kills asteroid 
    public void missileKillastro(){
 
      if(someMissle() == true && someAsteroid() == true){	
    	  System.out.println("Missile killed an Asteroid!");
    	
    	  int score = getgwScore();
    	  setgwScore(score+1); //incrment score
    	  System.out.println("Score: " + getgwScore());
	      System.out.println("---------" + "\nMissile kills asteroid in collection");
	      proxy();

     	  Sound boom = new Sound("missilecollides.WAV");
     	  boom.play();
		  gwObjects.remove(astroPlace());
		  gwObjects.remove(misslePlace());
      }else{
	    	  System.out.println("There is no ship or asteroid in game world!"); 
      }

    }
    
    //restart game: remove game world objects
    public void gameRestart(){
	    IIterator it = gwObjects.getIterator();
		GameObject currObj;
		while (it.hasNext()){
			currObj = (GameObject) it.getNext();
			System.out.println(currObj);
			gwObjects.removeAll();
		}
    }
    
    //increment game world score
    public void gwScoreInc(){
  	  int score = getgwScore();
  	  setgwScore(score+1); //increment score
  	  System.out.println("Score: " + getgwScore());
    }
    
    //game end dialog
    public void gameEndDialog(){
    	Dialog.show("No more lives left, Game Over!", "Score: "+Integer.toString(getgwScore()), "Restart Game", null);
    }
    
    //decrement player lives
    public void decLives(){
    	int lives = getPlayerlives();
    	if(getPlayerlives()>0){
    			setPlayerlives(lives - 1); //decrement
    			System.out.println("Lives left: "+ getPlayerlives());
    	}else{
    		    setPlayerlives(3);
    	}   
	     if(lives > 0) {
	    	 proxy();

	     } if(getPlayerlives() == 0){
	    	 System.out.println("No more lives left, Game Over!");
	    	 Sound end = new Sound("end.wav");
	    	 end.play();
	    	 System.out.println("New Game Has Started.");
	    	 setcTimer(0);
	    	 setgwScore(0);
	    	 newShip.setMissleCount(0);
	    	 gameEndDialog();
	    	 setPlayerlives(3);//new lives given
	    	 gameRestart();//restart game
	     }
    }

    
    //asteroids have collided
    public void astroCollidedastro(){
    	
     if(someTwoAstroids()==true){
			System.out.println("An Asteroid has collided an Asteroid");
			gwObjects.remove(astroPlace());
			gwObjects.remove(astroPlace());
		    System.out.println("---------" + "\nAstroids have Collided in collection");
		    proxy();
    		   
    	}else{
  	  	  System.out.println("More Asteroids Needed!"); 
        }
    }

	//remove after collision
	public void CollisionAstroShip(){
		while(!CollisionShip.isEmpty()){
			gwObjects.remove((GameObject)CollisionShip.firstElement());
			CollisionShip.remove(0);
		}
		decLives();
		
		if(getPlayerlives()>0){
		   newShip();
		}
	}
    
    	//remove after collision
	public void AsteroidStationCollideteroids(){
		while(!CollisionAstro.isEmpty()){
			gwObjects.remove((GameObject)CollisionAstro.firstElement());
			CollisionAstro.remove(0);
		}
	}
	
  	//remove after collision
	public void SaucerCollideSaucer(){
		while(!CollisionSaucer.isEmpty()){
			gwObjects.remove((GameObject)CollisionSaucer.firstElement());
			CollisionSaucer.remove(0);
		}
	}

	//remove after collision
	public void rmMissileissile(){
		while(!CollisionMissile.isEmpty()){
			gwObjects.remove((GameObject)CollisionMissile.firstElement());
			CollisionMissile.remove(0);
			gwScore+=1;
		}
	}
    
	//tick tells game world game clock has ticked, object collision handling
    public void gameClockTick(){
    	
    	int cnt = 0;
    	int timeInc = getcTimer()+1; //incremnt
    	setcTimer(timeInc);

    	IIterator it = gwObjects.getIterator();
		IIterator itr = gwObjects.getIterator();
		Object obj = new Object();
		
		if (it.hasNext() == false){
			System.out.println("No objects in Game");
		}else{
			while (it.hasNext()){
				obj = it.getNext();
				if (obj instanceof IMovable){
					IMovable objM = (IMovable) obj;
					objM.move();
					cnt++;   
					if(cnt == 1){
						//do nothing
	      			    }
				}
			}
			while (itr.hasNext()){
				obj = itr.getNext();
				if (obj instanceof Missiles){
					if(((Missiles) misslePlace()).getFuelLevel() > 0){
    		     		int decFuel = ((Missiles) misslePlace()).getFuelLevel();
    		     		((Missiles) misslePlace()).SetFuel(decFuel-1);
    		     		proxy();
    		       }else if(((Missiles) misslePlace()).getFuelLevel() == 0){
					    Missiles m = (Missiles) obj;
					    gwObjects.removeEnd(m);
					    break;
    			}	
					
				}
			}
    	  }		
    	
    	if(someStation()==true){
    		if(getcTimer() % ((SpaceStation) stationPlace()).getBlinkRate() == 0){
    			((SpaceStation) stationPlace()).Blink();
    	    }
    	}
    	
    	//Object collison handeling
    	IIterator iter = gwObjects.getIterator();
		while(iter.hasNext()){
			ICollider crnt = (ICollider)iter.getNext();
			IIterator iit = gwObjects.getIterator();

			while(iit.hasNext()){
				ICollider obj2 = (ICollider) iit.getNext();
				
				if(crnt instanceof Asteroids && obj2 instanceof Asteroids && crnt!=obj2){ //Asteroid collied asteroid
					if(crnt.collidesWith(obj2))
						System.out.println("Collsion in game world");
					
					if(crnt.collidesWith(obj2) && !(CollisionAstro.contains(crnt) && CollisionAstro.contains(obj2))){
						System.out.println(crnt);
						System.out.println(obj2);
						CollisionAstro.add((GameObject)crnt);
						CollisionAstro.add((GameObject)obj2);
						System.out.println("Asteroids have collided");
				        Sound boom1 = new Sound("missilecollides.WAV");
				     	boom1.play();
						rmAstroid = true;
					}
				}else if(crnt instanceof Saucer && obj2 instanceof Saucer && crnt!=obj2){ //Saucer collides saucer
					if(crnt.collidesWith(obj2))
						System.out.println("Collsion in game world");
					
					if(crnt.collidesWith(obj2) && !(CollisionSaucer.contains(crnt) && CollisionSaucer.contains(obj2))){
						System.out.println(crnt);
						System.out.println(obj2);
						CollisionSaucer.add((GameObject)crnt);
						CollisionSaucer.add((GameObject)obj2);
						System.out.println("Saucers have collided");
				        Sound boom4 = new Sound("missilecollides.WAV");
				     	boom4.play();
						rmSaucer = true;
					}
				} else if((crnt instanceof Asteroids && obj2 instanceof Ships || obj2 instanceof Ships && crnt instanceof Asteroids) // Asteroids collides ship
						&& !(CollisionShip.contains(crnt) && CollisionAstro.contains(obj2))){
					if(crnt.collidesWith(obj2)){
						if(crnt instanceof Ships){
							CollisionShip.add((GameObject)crnt);
							CollisionAstro.add((GameObject)obj2);
						}else{
							CollisionShip.add((GameObject)obj2);
							CollisionAstro.add((GameObject)crnt);
						}
						System.out.println("An Asteroid has collided with Ship");
						Sound boom5 = new Sound("missilecollides.WAV");
				     	boom5.play();
						rmAstroid = true;
						rmShip = true;
					}
				} else if((crnt instanceof Saucer && obj2 instanceof Ships || obj2 instanceof Ships && crnt instanceof Saucer) // Saucer collides ship
						&& !(CollisionShip.contains(crnt) && CollisionSaucer.contains(obj2))){
					if(crnt.collidesWith(obj2)){
						if(crnt instanceof Ships){
							CollisionShip.add((GameObject)crnt);
							CollisionSaucer.add((GameObject)obj2);
						}else{
							CollisionShip.add((GameObject)obj2);
							CollisionSaucer.add((GameObject)crnt);
						}
						System.out.println("An Saucer has collided with Ship");
						Sound boom5 = new Sound("missilecollides.WAV");
				     	boom5.play();
						rmSaucer = true;
						rmShip = true;
					}
				} else if((crnt instanceof Asteroids && obj2 instanceof Missiles) || (obj2 instanceof Missiles && crnt instanceof Asteroids) //Missile collides Asteroid
						&& !(CollisionMissile.contains(crnt) && CollisionMissile.contains(obj2))){
					if(crnt.collidesWith(obj2)){
						if(crnt instanceof Asteroids){
							CollisionAstro.add((GameObject)crnt);
							CollisionMissile.add((GameObject)obj2);
						}else{
							CollisionAstro.add((GameObject)obj2);
							CollisionMissile.add((GameObject)crnt);
						}
						System.out.println("A Missile and Asteroid has collided");
						  Sound boom2 = new Sound("missilecollides.WAV");
					     boom2.play();
						rmAstroid = true;
						rmMissile= true;
					}
				} else if((crnt instanceof Saucer && obj2 instanceof Missiles) || (obj2 instanceof Missiles && crnt instanceof Saucer) //Missile collides saucer
						&& !(CollisionMissile.contains(crnt) && CollisionMissile.contains(obj2))){
					if(crnt.collidesWith(obj2)){
						if(crnt instanceof Saucer){
							CollisionSaucer.add((GameObject)crnt);
							CollisionMissile.add((GameObject)obj2);
						}else{
							CollisionSaucer.add((GameObject)obj2);
							CollisionMissile.add((GameObject)crnt);
						}
						System.out.println("A Missile and Saucer has collided");
						  Sound boom2 = new Sound("missilecollides.WAV");
					     boom2.play();
						rmSaucer = true;
						rmMissile= true;
					}
				} else if((crnt instanceof Saucer && obj2 instanceof Asteroids) || (obj2 instanceof Asteroids && crnt instanceof Saucer) //Asteroid collides saucer
						&& !(CollisionAstro.contains(crnt) && CollisionAstro.contains(obj2))){
					if(crnt.collidesWith(obj2)){
						if(crnt instanceof Saucer){
							CollisionSaucer.add((GameObject)crnt);
							CollisionAstro.add((GameObject)obj2);
						}else{
							CollisionSaucer.add((GameObject)obj2);
							CollisionAstro.add((GameObject)crnt);
						}
						System.out.println("A Asteroid and Saucer have collided");
						  Sound boom2 = new Sound("missilecollides.WAV");
					     boom2.play();
						rmSaucer = true;
						rmAstroid= true;
					}
				} else if((crnt instanceof SpaceStation && obj2 instanceof Ships) || (crnt instanceof Ships && obj2 instanceof SpaceStation)){ //ship collide station
					if(crnt.collidesWith(obj2)){
						System.out.println("Ship has collided with Space Station");
						
						if(crnt instanceof Ships){
							newShip.setMissleCount(10);
						}else{
							newShip.setMissleCount(10);
						}
					}
				}
			}
		}
	
	if (rmMissile){
		rmMissileissile();
		rmMissile = false;
	}
	else if (rmAstroid){ 
		AsteroidStationCollideteroids(); 
	    rmAstroid = false;
	} else if (rmSaucer){
		SaucerCollideSaucer();
		rmSaucer = false;
	}
	else if (rmShip){
		CollisionAstroShip();
		rmShip = false;
	}
	    proxy();
    }
    
   //Displays game stats: score, elapsed time, and missiles 
    public void printStats(){
    	System.out.println("Current Score: " + getgwScore());
    	System.out.println("Current Elapsed Time: " + getcTimer());
    	System.out.println("Current Missiles in Ship: "+ newShip.getMissleCount());
    }
    
    //prints map of current game state
    public void printWorldMap(){
    	
		IIterator it = gwObjects.getIterator();
		Object currObj = new Object();
		
		if (it.hasNext() == false)
			System.out.println("No objects in collection");
		else{
		      while(it.hasNext() ){
		      	currObj = it.getNext();
		        System.out.println(currObj.toString() );
		      }
		}
		
    }
    
    //about dialog box menu bar 
    public void about() {
 		Dialog.show("About", "Creator: Ali Iqbal \n"			
 				+ "CSC 133 \nVersion: 3", "OK", null);
 	}
    
    //quit game dialog box 
    public void quit(){
    	Boolean quit = Dialog.show("Confirm Quit", "Do you want to quit game?", "Yes", "No");
    	if (quit){
    		System.exit(0);
    	}
    }

	public void newSaucer() {
		  //no use in pause
		  if(getinPlay()==false){
		      System.out.println("Game is Paused");
			  return;
		  }    
		  Saucer saucerAdd = new Saucer();		  
		  gwObjects.add(saucerAdd);
		  System.out.println("Adding sacuer to game world");
		  System.out.println(saucerAdd.toString());
		  System.out.println("---------" + "\nSaucer now in collection");
		  proxy();
		
	}

}