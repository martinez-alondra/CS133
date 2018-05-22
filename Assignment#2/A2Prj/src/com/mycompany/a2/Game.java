package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.commands.CommandNewShip;
import com.mycompany.a2.commands.CommandNewStation;
import com.mycompany.a2.commands.CommandQuit;
import com.mycompany.a2.commands.CommandSound;
import com.mycompany.a2.commands.CommandTick;
import com.mycompany.a2.commands.CommandDecrease;
import com.mycompany.a2.commands.CommandIncrease;
import com.mycompany.a2.commands.CommandJump;
import com.mycompany.a2.commands.CommandEliminate;
import com.mycompany.a2.commands.CommandKillAsteroid;
import com.mycompany.a2.commands.CommandLeftTurn;
import com.mycompany.a2.commands.CommandRightTurn;
import com.mycompany.a2.commands.CommandLoadMissiles;
import com.mycompany.a2.commands.CommandWacked;
import com.mycompany.a2.commands.CommandNewMissile;
import com.mycompany.a2.commands.CommandHit;
import com.mycompany.a2.commands.CommandNewFlyingSaucer;
import com.mycompany.a2.commands.CommandCrashShip;
import com.mycompany.a2.commands.CommandExterminate;
import com.mycompany.a2.commands.CommandNewAsteroid;

/**
 * @author Ali H. Iqbal
 */
//This class builds a GameWorld
public class Game extends Form {

	private GameWorld gw; 

	private MapView mv; 
	private PointsView pv; 
	private Toolbar myToolbar;
	private GameWorldProxy gwproxy;
	private Container containerW;

	//Buttons
	private custButton WackedButton;
	private custButton CrashedButton;
	private custButton ExterminateButton;
	private custButton NewAsteroidButton;
	private custButton NewFlyingSaucerButton;
	private custButton NewMissileButton;
	private custButton NewShipButton;
	private custButton NewSpaceStationButton;
	private custButton DecreaseButton;
	private custButton IncreaseButton;
	private custButton JumpButton;
	private custButton KilledButton;
	private custButton EliminatedButton;
	private custButton LeftButton;
	private custButton RightButton;
	private custButton LoadMissilesButton;
	private custButton HitButton;
	private custButton tickButton;
	
	//Commands
	private CommandCrashShip commandCrashShip;
	private CommandExterminate commandExterminate;
	private CommandNewAsteroid commandNewAsteroid;
	private CommandNewFlyingSaucer commandNewFlyingSaucer;
	private CommandNewMissile commandNewMissile;
	private CommandNewShip commandNewShip;
	private CommandNewStation commandNewSpaceStation;
	private CommandDecrease commandDecrease;
	private CommandIncrease commandIncrease;
	private CommandJump commandJump;
	private CommandHit commandHit;
	private CommandKillAsteroid commandKillAsteroid;
	private CommandEliminate commandEliminate;
	private CommandLeftTurn commandLeftTurn;
	private CommandRightTurn commandRightTurn;
	private CommandLoadMissiles commandLoadMissiles;
	private CommandWacked commandWacked;
	private CommandTick commandTick;
	private CommandQuit commandQuit;
	private CommandSound commandSound;
	
	
	////GameWorld initial state
	public Game() {
	
				this.gw = new GameWorld();
				this.mv = new MapView();
				this.pv = new PointsView();
				this.gwproxy = new GameWorldProxy(this.gw);
				gw.init();
				this.setTitle("CSC 133 - Asteroid Game");
				
				this.setLayout(new BorderLayout());
		
				
				this.add(BorderLayout.CENTER, mv);
				this.gw.addObserver(mv);
				this.add(BorderLayout.NORTH, pv);
				this.gw.addObserver(pv);

				this.containerW = new Container();
				this.containerW.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
				this.containerW.getStyle().setBorder(Border.createLineBorder(3, ColorUtil.GREEN));
				
				// left 
				this.LeftButton = new custButton("Move Left");
				this.commandLeftTurn = new CommandLeftTurn(this.gw);
				this.LeftButton.setCommand(this.commandLeftTurn);
				this.addKeyListener('l', this.commandLeftTurn);
				this.containerW.add(this.LeftButton);
				//right
				this.RightButton = new custButton("Move Right");
				this.commandRightTurn = new CommandRightTurn(this.gw);
				this.RightButton.setCommand(this.commandRightTurn);
				this.addKeyListener('r', this.commandRightTurn);
				this.containerW.add(this.RightButton);
				
				// decrease ship speed button
				this.DecreaseButton = new custButton("Decrease Ship Speed");
				this.commandDecrease = new CommandDecrease(this.gw);
				this.DecreaseButton.setCommand(this.commandDecrease);
				this.addKeyListener('d', this.commandDecrease);
				this.containerW.add(this.DecreaseButton);
				// increase ship speed button
				this.IncreaseButton = new custButton("Increase Ship Speed");
				this.commandIncrease = new CommandIncrease(this.gw);
				this.IncreaseButton.setCommand(this.commandIncrease);
				this.addKeyListener('i', this.commandIncrease);
				this.containerW.add(this.IncreaseButton);
				
				// tick button
				this.tickButton = new custButton("Tick");
				this.commandTick = new CommandTick(this.gw);
				this.tickButton.setCommand(this.commandTick);
				this.addKeyListener('t', this.commandTick);
				this.containerW.add(this.tickButton);
				
				// asteroid killing saucer button
				this.WackedButton = new custButton("Asteroid Kill Flying-Saucer");
				this.commandWacked = new CommandWacked(this.gw);
				this.WackedButton.setCommand(this.commandWacked);
				this.addKeyListener('w', this.commandWacked);
				this.containerW.add(this.WackedButton);
				
				// asteroid collide button
				this.ExterminateButton = new custButton("Asteroids Collide");
				this.commandExterminate = new CommandExterminate(this.gw);
				this.ExterminateButton.setCommand(this.commandExterminate);
				this.addKeyListener('x', this.commandExterminate);
				this.containerW.add(this.ExterminateButton);
				
				// saucer kill ship button
				this.CrashedButton = new custButton("Asteroid Kill Ship");
				this.commandCrashShip = new CommandCrashShip(this.gw);
				this.CrashedButton.setCommand(this.commandCrashShip);
				this.addKeyListener('c', this.commandCrashShip);
				this.containerW.add(this.CrashedButton);
				
				// asteroid hit ship
				this.HitButton = new custButton("Saucer Kill ship");
				this.commandHit = new CommandHit(this.gw);
				this.HitButton.setCommand(this.commandHit);
				this.addKeyListener('h', this.commandHit);
				this.containerW.add(this.HitButton);
				
				// kill saucer
				this.EliminatedButton = new custButton("Missile Kill Flying-Saucer");
				this.commandEliminate = new CommandEliminate(this.gw);
				this.EliminatedButton.setCommand(this.commandEliminate);
				this.addKeyListener('e', this.commandEliminate);
				this.containerW.add(this.EliminatedButton);
				
				// kill asteroid
				this.KilledButton = new custButton("Missile Kill Asteroid");
				this.commandKillAsteroid = new CommandKillAsteroid(this.gw);
				this.KilledButton.setCommand(this.commandKillAsteroid);
				this.addKeyListener('k', this.commandKillAsteroid);
				this.containerW.add(this.KilledButton);
				
				// missile 
				this.NewMissileButton = new custButton("Missile Fired");
				this.commandNewMissile = new CommandNewMissile(this.gw);
				this.NewMissileButton.setCommand(this.commandNewMissile);
				this.addKeyListener('f', this.commandNewMissile);
				this.containerW.add(this.NewMissileButton);
				// refill missiles 
				this.LoadMissilesButton = new custButton("Reload Missiles");
				this.commandLoadMissiles = new CommandLoadMissiles(this.gw);
				this.LoadMissilesButton.setCommand(this.commandLoadMissiles);
				this.addKeyListener('n', this.commandLoadMissiles);
				this.containerW.add(this.LoadMissilesButton);
				// jump
				this.JumpButton = new custButton("Jump");
				this.commandJump = new CommandJump(this.gw);
				this.JumpButton.setCommand(this.commandJump);
				this.addKeyListener('j', this.commandJump);
				this.containerW.add(this.JumpButton);
				
				//ship button
				this.NewShipButton = new custButton("Add Ship");
				this.commandNewShip = new CommandNewShip(this.gw);
				this.NewShipButton.setCommand(this.commandNewShip);
				this.addKeyListener('s', this.commandNewShip);
				this.containerW.add(this.NewShipButton);
				// asteroid 
				this.NewAsteroidButton = new custButton("Add Asteroid");
				this.commandNewAsteroid = new CommandNewAsteroid(this.gw);
				this.NewAsteroidButton.setCommand(this.commandNewAsteroid);
				this.addKeyListener('a', this.commandNewAsteroid);
				this.containerW.add(this.NewAsteroidButton);
				// create flying saucer button
				this.NewFlyingSaucerButton = new custButton("Add Flying Saucer");
				this.commandNewFlyingSaucer = new CommandNewFlyingSaucer(this.gw);
				this.NewFlyingSaucerButton.setCommand(this.commandNewFlyingSaucer);
				this.addKeyListener('y', this.commandNewFlyingSaucer);
				this.containerW.add(this.NewFlyingSaucerButton);
				// create space station button
				this.NewSpaceStationButton = new custButton("Add Station");
				this.commandNewSpaceStation = new CommandNewStation(this.gw);
				this.NewSpaceStationButton.setCommand(this.commandNewSpaceStation);
				this.addKeyListener('b', this.commandNewSpaceStation);
				this.containerW.add(this.NewSpaceStationButton);
				
				// side menu
				Toolbar side = new Toolbar();
				this.setToolbar(side);
				side.setTitle("CSC133-Asteroids Game");
				this.commandQuit = new CommandQuit(this.gw);
				this.commandSound = new CommandSound(this.gw);
				CheckBox soundCheckBox = new CheckBox();
				soundCheckBox.setSelected(true);
				soundCheckBox.setCommand(this.commandSound);
				commandSound.putClientProperty("SideComponent", soundCheckBox);
				side.addCommandToSideMenu(this.commandNewAsteroid);
				side.addCommandToSideMenu(this.commandNewSpaceStation);
				side.addCommandToSideMenu(this.commandNewShip);
				side.addCommandToSideMenu(this.commandLoadMissiles);
				side.addCommandToSideMenu(this.commandKillAsteroid);
				side.addCommandToSideMenu(this.commandCrashShip);
				side.addCommandToSideMenu(this.commandExterminate);
				side.addCommandToSideMenu(this.commandTick);
				side.addCommandToSideMenu(this.commandSound);
				side.addCommandToSideMenu(this.commandQuit);
				
				
				this.add(BorderLayout.WEST, this.containerW);
				this.gw.notifyObservers();
	
				this.show();
			} 

	
	}
		