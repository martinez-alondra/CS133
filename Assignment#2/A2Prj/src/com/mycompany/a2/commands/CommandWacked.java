package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandWacked extends Command {
	private IGameWorld gw;
	
	public CommandWacked(IGameWorld gw) {
		super("Asteroid Wacks Saucer"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.removeAsteroid();
		gw.removeFlyingSaucer();
	}

}
