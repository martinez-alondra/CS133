package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandExterminate extends Command{
	
	GameWorld gmw;
	
	public CommandExterminate(GameWorld gw) {
        super("Exterminate");
		this.gmw = gw;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Exterminate is pressed");
		gmw.astroCollidedastro();
		System.out.println();
	} 	
}
