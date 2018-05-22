package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandNewShip extends Command {

	private IGameWorld gw;
	
	public CommandNewShip(IGameWorld gw) {
		super("Add Ship"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.gw.newShip();
	}

}