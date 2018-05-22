package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */	
public class CommandNewAsteroid extends Command {

		private IGameWorld gw;
	
		public CommandNewAsteroid(IGameWorld gw) {
			super("Add Asteroid"); 
			this.gw = gw;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.gw.newAstroid();
		}
	
}