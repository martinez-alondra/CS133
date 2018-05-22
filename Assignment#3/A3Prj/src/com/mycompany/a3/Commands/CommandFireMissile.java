package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.*;
/**
 * @author Ali H. Iqbal
 */
public class CommandFireMissile extends Command {
    GameWorld gmw;
	
	public CommandFireMissile (GameWorld gw){
		super("Fire missile");
		this.gmw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Fire missile is pressed");
		gmw.fireMissile();
		System.out.println();
	} 	
}