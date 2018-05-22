package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
	
public class CommandNewFlyingSaucer extends Command {

		private IGameWorld gw;
	
		public CommandNewFlyingSaucer(IGameWorld gw) {
			super("Add Flying-Saucer"); 
			this.gw = gw;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.gw.newFlyingSaucer();
		}
	
}