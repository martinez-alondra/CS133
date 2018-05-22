package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandAddAsteroid extends Command{
	
	GameWorld gw;
	
	public CommandAddAsteroid(GameWorld gw) {
        super("Add Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Add Asteroid is pressed");
		gw.newAstroid();
		System.out.println();
		
	} 	
}
