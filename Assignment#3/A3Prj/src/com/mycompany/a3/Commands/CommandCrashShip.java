package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandCrashShip extends Command{
	
	GameWorld gw;
	
	public CommandCrashShip(GameWorld gw) {
        super("Crash Ship");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Crash Ship is pressed");
		gw.shipCrashastro();
		System.out.println();
	} 	
}
