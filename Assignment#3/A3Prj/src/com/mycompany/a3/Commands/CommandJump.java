package com.mycompany.a3.Commands;

import com.codename1.ui.Command;
import com.mycompany.a3.*;
import com.codename1.ui.events.ActionEvent;
/**
 * @author Ali H. Iqbal
 */
public class CommandJump extends Command {
    GameWorld gmw;
	
	public CommandJump (GameWorld gw){
		super("Jump");
		this.gmw = gw; 
	}
	public void actionPerformed(ActionEvent e){
		System.out.println("Jump is pressed");
		gmw.jump();
		System.out.println();	
	} 	
}