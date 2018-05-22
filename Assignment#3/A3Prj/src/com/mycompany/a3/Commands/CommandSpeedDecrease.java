package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandSpeedDecrease extends Command {
    GameWorld gw;
	
	public CommandSpeedDecrease (GameWorld gw){
		super("Decrease Speed");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Decrease Speed is pressed");
		gw.speedDecrease();
		System.out.println();
		
	} 	

}

