package com.mycompany.a3;

import com.mycompany.a3.Views.*;
import com.mycompany.a3.Commands.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.util.UITimer;
import java.io.InputStream;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.charts.util.ColorUtil;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
/**
 * @author Ali H. Iqbal
 */
//Game Class displays player controls
public class Game extends Form implements Runnable{

	private GameWorld gw;
	private GameWorldProxy pxy;
	private Media m;
	private PointsView ptv;
	private MapView mv; 
	
///Buttons for controls
	private Button btnShip = new Button();
	private Button btnAsteroid = new Button();
	private Button btnSaucer = new Button();
	private Button btnStation = new Button();
	private Button btnLeft = new Button();
	private Button btnRight = new Button();
	private Button btnIncrease = new Button();
	private Button btnDecrease = new Button();
	private Button btnLoadMissile = new Button();
	private Button btnKillasteroid = new Button();
	private Button btnFire = new Button();
	private Button btnJump = new Button();
	private Button btnCrash = new Button();
	private Button btnExt = new Button();
	private Button btnTick = new Button();
	private Button btnQuitgame = new Button();
	private static Button bRefuel = new Button(); 
	private static Button bPause = new Button();

	public Game(){
		//Below is code for command buttons
		//MapView, pointsView display
		gw = new GameWorld(); 
		gw.init();
		mv = new MapView(); //“Observer” for the map
		ptv = new PointsView();
		gw.addObserver(ptv); 
		gw.setinPlay(true);//set start of game

		setLayout(new BorderLayout()); // sets BorderLayout
		
		Toolbar tlb = new Toolbar();
		setToolbar(tlb);
		this.setTitle("CSC-133 Asteroid Game");
		
		/// Top
		Container topCtr = new Container();
		topCtr.add(ptv);
		topCtr.setLayout(new FlowLayout(Component.CENTER));
		add(BorderLayout.NORTH, topCtr);
		
		/// left
		Container leftCtr = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		add(BorderLayout.WEST,leftCtr);
		
		/// Bottom 
		Container bottomCtr = new Container(new FlowLayout(Component.CENTER));
		add(BorderLayout.SOUTH,bottomCtr);
		
		/// Center
		Container centerCtr = new Container();
		centerCtr.getAllStyles().setBgTransparency(255); 
		centerCtr.getAllStyles().setBgColor(ColorUtil.WHITE);
		centerCtr.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		add(BorderLayout.CENTER,centerCtr);
	
		Label cmd = new Label("Controls:  "); // command label
		cmd.getUnselectedStyle().setBgTransparency(255);
		leftCtr.add(cmd);
		
		//button for adding ship
		btnShip.getUnselectedStyle().setBgTransparency(255);
		btnShip.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnShip.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnShip.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnShip);
		btnShip.setCommand(new CommandAddShip(gw));
		
		//button for adding station
		btnStation.getUnselectedStyle().setBgTransparency(255);
		btnStation.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnStation.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnStation.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnStation);
		btnStation.setCommand(new CommandAddStation(gw));
		
		//button for adding asteroid
		btnAsteroid.getUnselectedStyle().setBgTransparency(255);
		btnAsteroid.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnAsteroid.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnAsteroid.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnAsteroid);
		btnAsteroid.setCommand(new CommandAddAsteroid(gw));
		
		//button for adding flying saucer
		btnSaucer.getUnselectedStyle().setBgTransparency(255);
		btnSaucer.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnSaucer.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnSaucer.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnSaucer);
		btnSaucer.setCommand(new CommandAddSaucer(gw));
		
		//button for speed decrease
		btnDecrease.getUnselectedStyle().setBgTransparency(255);
		btnDecrease.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnDecrease.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnDecrease.getAllStyles().setMargin(leftCtr.BOTTOM, 2);;
		leftCtr.add(btnDecrease);
		CommandSpeedDecrease spdDecrease = new CommandSpeedDecrease(gw);
		btnDecrease.setCommand(spdDecrease);
		addKeyListener('d', spdDecrease);
		
		//button for speed increase
		btnIncrease.getUnselectedStyle().setBgTransparency(255);
		btnIncrease.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnIncrease.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnIncrease.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnIncrease);
		CommandSpeedIncrease spdIncrease = new CommandSpeedIncrease(gw);
		btnIncrease.setCommand(spdIncrease);
		addKeyListener('i', spdIncrease);
		
		//button for right turn
		btnRight.getUnselectedStyle().setBgTransparency(255);
		btnRight.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnRight.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnRight.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnRight);
		CommandTurnRight rightTurn = new CommandTurnRight(gw);
		btnRight.setCommand(rightTurn);
		addKeyListener('r', rightTurn);
		
		//button for left turn
		btnLeft.getUnselectedStyle().setBgTransparency(255);
		btnLeft.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnLeft.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnLeft.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnLeft);
		CommandTurnLeft leftTurn = new CommandTurnLeft(gw);
		btnLeft.setCommand(leftTurn);
		addKeyListener('l', leftTurn);
		
		//button for jump
		btnJump.getUnselectedStyle().setBgTransparency(255);
		btnJump.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnJump.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnJump.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnJump);
		CommandJump jump = new CommandJump(gw);
		btnJump.setCommand(jump);
		addKeyListener('j', jump);
		
		//button for missile fire
		btnFire.getUnselectedStyle().setBgTransparency(255);
		btnFire.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnFire.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnFire.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnFire);
		CommandFireMissile fire = new CommandFireMissile(gw);
		btnFire.setCommand(fire);
		addKeyListener('f', fire);
		
		//Map command
		CommandPrintMap map = new CommandPrintMap(gw);
		addKeyListener('m', map);
		
		//button for loading missile
		btnLoadMissile.getUnselectedStyle().setBgTransparency(255);
		btnLoadMissile.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnLoadMissile.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		addKeyListener('o', new CommandLoadMissiles(gw));
		
		
		//button for kill asteroid
		btnKillasteroid.getUnselectedStyle().setBgTransparency(255);
		btnKillasteroid.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnKillasteroid.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		addKeyListener('k', new CommandKillsAsteroid(gw));

		//button for ship crash
		btnCrash.getUnselectedStyle().setBgTransparency(255);
		btnCrash.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnCrash.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		addKeyListener('c', new CommandCrashShip(gw));
 
		//button for exterminate
		btnExt.getUnselectedStyle().setBgTransparency(255);
		btnExt.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnExt.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		addKeyListener('x', new CommandExterminate(gw));
		
		//button for tick
		btnTick.getUnselectedStyle().setBgTransparency(255);
		//add style
		btnTick.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnTick.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		addKeyListener('t', new CommandTick(gw));
		
		//button for refuel
		bRefuel.getUnselectedStyle().setBgTransparency(255);
		bRefuel.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bRefuel.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		bRefuel.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(bRefuel);
		bRefuel.setCommand(new CommandRefuel(gw));
		bRefuel.setEnabled(false);
		
		//button for pausing
		bPause.getUnselectedStyle().setBgTransparency(255);
		bPause.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bPause.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		bPause.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(bPause);
		bPause.setCommand(new CommandPause(gw));
		
		
		//button for quitting game
		btnQuitgame.getUnselectedStyle().setBgTransparency(255);
		btnQuitgame.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		btnQuitgame.getUnselectedStyle().setBgColor(ColorUtil.GRAY);
		btnQuitgame.getAllStyles().setMargin(leftCtr.BOTTOM, 2);
		leftCtr.add(btnQuitgame);
		btnQuitgame.setCommand(new CommandExit(gw));
		Command mnu = new Command("Main Menu");
		
		tlb.addCommandToLeftBar(mnu);
		
		Command sideMnu = new Command("Back");
		//sound checkbox
		CheckBox sideMnuChk = new CheckBox("Sound ON/OFF");
		sideMnuChk.getAllStyles().setBgTransparency(255); 
		sideMnuChk.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		sideMnu.putClientProperty("SideComponent", sideMnuChk);
		tlb.addCommandToSideMenu(sideMnu);
		sideMnuChk.setCommand(new SoundCheckBox(gw));
		
		///other menu commands
		tlb.addCommandToSideMenu(new CommandNew(gw));
		tlb.addCommandToSideMenu(new CommandUndo(gw));
		tlb.addCommandToSideMenu(new CommandSave(gw));
		tlb.addCommandToSideMenu(new CommandExit(gw));
		
		tlb.addCommandToOverflowMenu(new CommandAbout(gw));
		
		//display all
		this.show();
		
		//sets width/height dimensions 
		gw.setDimension((int)centerCtr.getWidth(),(int)centerCtr.getHeight());
	
		
		mv.setWidth(centerCtr.getWidth());
		mv.setHeight(centerCtr.getHeight());
		
		gw.addObserver(mv);
		centerCtr.add(mv);
		
		///set timer
		UITimer tmr = new UITimer (this);
		tmr.schedule(100, true, this);
		
		this.show();
	
	}
	public static Button bPause(){
		return bPause;
	}
	public static Button bRefuel(){
		return bRefuel;
	}
	
	public void run() {
       if(gw.getinPlay()==true){
		  gw.gameClockTick();
		  mv.repaint();
       }

	}
}
