package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.mycompany.a3.Views.PointsView;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandPause extends Command {
    GameWorld gw;
	
	public CommandPause(GameWorld gw){
		super("Pause");
		this.gw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Pause is pressed");
		gw.inPlay();
		System.out.println("Game is Playing: "+ gw.getinPlay());
		//make pause to play
		if(gw.getinPlay()==true){
			gw.playToPause();
		}else{
		    gw.pauseToPlay();
		}
		//enable fuel inPlay, disable in pause
        if(gw.getinPlay()==false){
            gw.enableRefuel();           
            
 		}else{
 			gw.disableRefuel();
 		}
	} 	
}