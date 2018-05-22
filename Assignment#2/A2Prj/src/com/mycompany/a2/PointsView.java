package com.mycompany.a2;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

import java.util.Observable;
import java.util.Observer;
/**
 * @author Ali H. Iqbal
 */
public class PointsView extends Container implements Observer {
	

		private Label score = new Label(" ");
		private Label lives = new Label(" ");
		private Label missiles = new Label(" ");
		private Label sound = new Label(" ");
		private Label time = new Label(" "); 
		

		/*----PointsView Constructor----*/
		public PointsView() {

			this.setLayout(new FlowLayout(Component.CENTER));
			
			this.add(new Label("Score: "));
			this.add(score);
			this.add(new Label("Lives: "));
			this.add(lives);
			this.add(new Label("Missiles: "));
			this.add(missiles);
			this.add(new Label("Sound:"));
			this.add(sound);
			this.add(new Label("Time: "));
			this.add(time);
			
		}	

		/*----Update Variables----*/
		public void update(Observable observable, Object data) {
			// TODO Auto-generated method stub
			this.score.setText("" + ((IGameWorld)observable).getScore());
			this.missiles.setText("" + ((IGameWorld)observable).getMissiles());
			this.time.setText("" + ((IGameWorld)observable).getTime());
			this.lives.setText("" + ((IGameWorld)observable).getLives());
			if ( ((IGameWorld)observable).getSound()) {
				this.sound.setText("Sound: ON");
			}
			else {
				this.sound.setText("Sound: OFF");
			}
			this.repaint();
		}
	
}
