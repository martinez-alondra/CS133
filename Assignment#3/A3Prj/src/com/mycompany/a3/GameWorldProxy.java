package com.mycompany.a3;

import com.mycompany.a3.Interfaces.*;
import java.util.Observable;
/**
 * @author Ali H. Iqbal
 */
//Class provided public methods used in game world
public class GameWorldProxy extends Observable implements IGameWorld  {
	
	private GameWorld game;
	
	public GameWorldProxy (GameWorld gw){ 
		game = gw; 
		this.setChanged();
	}
	//methods to return 
	public int getgwScore(){
		return game.getgwScore();
	}
	public int getMissleCnt(){
		return game.getMissleCnt();
	}
	public int getcTimer(){
		return game.getcTimer();
	}
	public boolean getSound(){
		return game.getSound();
	}
	public void printWorldMap(){
		game.printWorldMap();
	}
}