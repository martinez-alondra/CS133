package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandTurnLeft extends Command {
    GameWorld gw;
	public CommandTurnLeft (GameWorld gw){
		super("Turn Left");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Turn left pressed");
		gw.leftTurn();
		System.out.println();
		
	} 	
}
