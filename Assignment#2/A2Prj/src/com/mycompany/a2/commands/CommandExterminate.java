package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandExterminate extends Command {
	private IGameWorld gw;
	
	public CommandExterminate(IGameWorld gw) {
		super("Asteroids Collide"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.removeAsteroid();					
		gw.removeAsteroid();
	}

}
