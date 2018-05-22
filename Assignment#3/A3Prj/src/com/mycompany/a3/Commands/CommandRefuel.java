package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameWorld;
/**
 * @author Ali H. Iqbal
 */
public class CommandRefuel extends Command {
    GameWorld gw;
	public CommandRefuel (GameWorld gw){
		super("Refuel");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
        System.out.println("Refuel pressed");
        if(gw.getinPlay()==false){
           gw.missileRefuel();
		}
	} 	
}