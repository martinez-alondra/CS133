package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandAddStation extends Command {
	
	GameWorld gw;
	
	public CommandAddStation (GameWorld gw){
		super("Add Space Station");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Add Space Station is pressed");
		gw.newStation();
		System.out.println();
		
	} 	
}
