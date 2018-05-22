package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandSpeedIncrease extends Command {
    GameWorld gw;
	public CommandSpeedIncrease (GameWorld gw){
		super("Increase Speed");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Increase Speed pressed");
		gw.speedIncrease();
		System.out.println();
	} 	
}
