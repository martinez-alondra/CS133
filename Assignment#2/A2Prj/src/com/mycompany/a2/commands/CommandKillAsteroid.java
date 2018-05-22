package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandKillAsteroid extends Command {
	private IGameWorld gw;
	
	public CommandKillAsteroid(IGameWorld gw) {
		super("Kill Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.removeMissile();
		gw.removeAsteroid();
		gw.setScore(gw.getScore()+10);
	}

}