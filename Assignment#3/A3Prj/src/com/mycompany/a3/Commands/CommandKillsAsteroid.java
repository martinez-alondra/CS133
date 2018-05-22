package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandKillsAsteroid extends Command {
    GameWorld gmw;

	public CommandKillsAsteroid(GameWorld gw){
		super("Kill Asteroid");
		this.gmw = gw;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Kill Asteroid is pressed");
		gmw.missileKillastro();
		System.out.println();


	}
}
