package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandLoadMissiles extends Command {
	private IGameWorld gw;
	
	public CommandLoadMissiles(IGameWorld gw) {
		super("Reload Missiles"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.gw.loadMissiles();
	}

}
