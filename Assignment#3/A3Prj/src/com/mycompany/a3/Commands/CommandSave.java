package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandSave  extends Command {
    GameWorld gw;
	public CommandSave (GameWorld gw){
		super("Save");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		//not implemented
	} 	
}