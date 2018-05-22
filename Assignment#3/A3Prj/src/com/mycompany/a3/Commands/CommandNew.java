package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandNew extends Command {
    GameWorld gw;
	
	public CommandNew (GameWorld gw){
		super("New");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		//not implemented
	} 	
}