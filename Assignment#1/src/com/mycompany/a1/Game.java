package com.mycompany.a1;
import java.lang.String;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label;
/**
 * @author Ali H. Iqbal
 */
//This class builds a GameWorld and sets up keyboard input.
public class Game extends Form {

	private GameWorld gw; 
	//boolean to quit game
	private boolean quit = false;
	

	//Game constructor builds GameWorld, initial state, runs play()
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	@SuppressWarnings("rawtypes")
	private void play() {
		// code here to accept and
		// execute user commands that
		// operate on the game world
		//(re/fer to ìAppendix - CN1
		//Notesî for accepting
		//keyboard commands via a text
		//field located on the form)
		System.out.println("The game has started!");
		Label myLabel=new Label ("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(quit) {						
					switch(sCommand.charAt(0)){
						case 'y' : System.exit(0); break;
						default: quit = false; break;
					}
				}
				else {
					switch (sCommand.charAt(0)){
					case 'a':	
					gw.newAstroid();
					break;
					case 'y':	
					gw.newFlyingSaucer();
					break;
					case 'b':	
					gw.newStation();
					break;
					case 's':	
					gw.newShip();
					break;
					case 'i':	
					gw.increaseAccel();
					break;
					case 'd':	
					gw.decreaseAccel();
					break;
					case 'l':	
					gw.leftTurn();
					break;
					case 'r':	
					gw.rightTurn();
					break;
					case 'f':	
					gw.fireMissile();
					break;	
					case 'j':	
					gw.jump();
					break;
					case 'n':	
					gw.newSupply();
					break;
					case 'k':	
					gw.killedAstroid();
					break;
					case 'c':
					gw.crashed();
					break;
					case 'h':
					gw.hit();
					break;
					case 'x':
					gw.exterminate();
					break;
					case 'w':
					gw.wacked();
					break;
					case 't':
					gw.tick();
					break;
					case 'p':
					gw.print();
					break;
					case 'm':
					gw.printMap(); 
					break;
					case 'q':	
					quit = true;
					System.out.println("Want to quit game? 'Y' or 'N'");
					break;
					default :	
					System.out.println("Invalid Keyboard Input");
					}
				}
			}
		});
	}
	
}
