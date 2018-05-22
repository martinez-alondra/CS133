package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandAddShip extends Command {
    GameWorld gw;
	
	public CommandAddShip (GameWorld gw){
		super("Add Ship");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Add Shhip is pressed");
		gw.newShip();
		System.out.println();
		
	} 	
}
