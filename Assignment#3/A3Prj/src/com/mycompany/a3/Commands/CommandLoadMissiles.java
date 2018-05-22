package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandLoadMissiles extends Command {
    GameWorld gw;
	
	public CommandLoadMissiles(GameWorld gw){
		super("Load missiles");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Load missiles is pressed");
		gw.loadMissiles();
		System.out.println();	
	} 	
}
