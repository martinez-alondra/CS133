package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandTick extends Command {
	GameWorld gw;
	public CommandTick (GameWorld gw){
		super("Tick");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Tick is pressed");
		gw.gameClockTick();
		System.out.println();
	} 	
}