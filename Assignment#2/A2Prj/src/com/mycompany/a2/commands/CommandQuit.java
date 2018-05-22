package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.IGameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandQuit extends Command {
private IGameWorld gw;
	
	public CommandQuit(IGameWorld gw) {
		super("Exit"); 
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (Dialog.show("Quit Menu", "Exit Game?", "Yes", "No")) {
			Display.getInstance().exitApplication();
		}
	}

}
