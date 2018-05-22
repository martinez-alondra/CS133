package com.mycompany.a3.Views;

import com.mycompany.a3.Sounds.*;
import com.mycompany.a3.Interfaces.*;
import com.mycompany.a3.GameWorld;
import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Label;
import com.codename1.ui.Container;
/**
 * @author Ali H. Iqbal
 */
//Class for game pointsView 
public class PointsView  extends Container implements Observer  {

	//Game labels
	private Label score;
	private Label gwScore;
	private Label missiles;
	private Label gwMissiles;
	private Label time;
	private Label gwTime;
	private Label sound;
	private Label gwSound;
	private GameWorld gw;
	
	//Game background music
	public BackGroundSound bg = new BackGroundSound("music.mp3");
	
	public PointsView(){ 
		
		score = new Label("Score:");
		gwScore = new Label("---");
		missiles = new Label("Missiles:");
		gwMissiles = new Label("----");
		time = new Label("Elapsed time:");
		gwTime = new Label("------");
		sound = new Label("Sound:");
		gwSound = new Label("ON");
		
		score.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwScore.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		missiles.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwMissiles.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		time.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwTime.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwTime.getAllStyles().setPaddingRight(2);
		gwTime.getAllStyles().setPaddingLeft(2);
		
		
		sound.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwSound.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		gwSound.getAllStyles().setPaddingRight(2);
		gwSound.getAllStyles().setPaddingLeft(2);
		
		
		this.add(score);
		this.add(gwScore);
		this.add(missiles);
		this.add(gwMissiles);
		this.add(time);
		this.add(gwTime);
		this.add(sound);
		this.add(gwSound);
		
        //BackGround Sound
		bg.play();

	}

	@SuppressWarnings("static-access")
	public void update(Observable ob, Object ar) {
	
		//label update
		gwScore.setText(Integer.toString(((IGameWorld)ar).getgwScore()));
		gwMissiles.setText(Integer.toString(((IGameWorld)ar).getMissleCnt()));
		gwTime.setText(Integer.toString(((IGameWorld)ar).getcTimer()));
	
			  if((((IGameWorld)ob).getSound() == true)){  //sound on-off 
				  gwSound.setText("OFF"); 
				  bg.pause();
			  }else{
				  if(gw.getinPlay()==true){  //sound on in play 
					  gwSound.setText("ON");
					  bg.play();
				  }
			  }	
	} 
}