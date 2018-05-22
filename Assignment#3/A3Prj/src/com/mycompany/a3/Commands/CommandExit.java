package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandExit extends Command{
	
	GameWorld gmw;
	
	public CommandExit(GameWorld gw){	
		super("Quit");
		gmw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent ew){
		gmw.quit();
		System.out.println("Quit is pressed");
		System.out.println();	
	}
}
