package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandAddSaucer extends Command{
	
	GameWorld gw;
	
	public CommandAddSaucer(GameWorld gw) {
        super("Add Flying-Saucer");
		this.gw = gw;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Add Flying-Saucer is pressed");
		gw.newSaucer();
		System.out.println();
	}
		
	} 	