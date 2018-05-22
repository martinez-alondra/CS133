package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandHit extends Command {


	private IGameWorld gw;
	
	public CommandHit(IGameWorld gw) {
		super("Ship Hit Saucer"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.removeFlyingSaucer();
		gw.removeShip();
		gw.setLives(gw.getLives()-1);
		if (gw.getLives() <= 0) {
			System.out.println("No More lives!");
		}
	}


}
