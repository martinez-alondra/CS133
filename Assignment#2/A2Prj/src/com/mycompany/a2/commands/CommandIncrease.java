package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandIncrease extends Command {
	
		private IGameWorld gw;
		
		public CommandIncrease(IGameWorld gw) {
			super("Increase Speed"); 
			this.gw = gw;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.gw.shipSpeed(1);
		}

}