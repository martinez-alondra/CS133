package com.mycompany.myapp;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.util.UITimer;

/**This class creates a Media object which loops while playing the sound 
 */
public class BGSound implements Runnable{
	private Media m;

	public BGSound(String fileName){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), 
														"/"+fileName);
			//attach a runnable to run when media has finished playing 
			//as the last parameter
			m = MediaManager.createMedia(is, "audio/wav", this);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void pause(){ m.pause();} //pause playing the sound
	public void play(){ m.play();} //continue playing from where we have left off
	
	//entered when media has finished playing
	public void run() {
		//start playing from time zero (beginning of the sound file)
		m.setTime(0);
		m.play();
		}
}
