package com.mycompany.a3.Interfaces;

import com.mycompany.a3.*;
/**
 * @author Ali H. Iqbal
 */
//Interface for game world methods
public interface IGameWorld {
	public int getgwScore();
	public int getMissleCnt();
	public boolean getSound();
	public void printWorldMap();
	public int getcTimer();
}