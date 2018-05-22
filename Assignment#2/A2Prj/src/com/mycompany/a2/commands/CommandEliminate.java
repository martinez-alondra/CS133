package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandEliminate extends Command {
	private IGameWorld gw;
	
	public CommandEliminate(IGameWorld gw) {
		super("Missile Kill Saucer"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.removeMissile();
		gw.removeFlyingSaucer();
		gw.setScore(gw.getScore()+25);
	}

}
