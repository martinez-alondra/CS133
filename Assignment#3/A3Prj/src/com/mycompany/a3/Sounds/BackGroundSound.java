package com.mycompany.a3.Sounds;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
/**
 * @author Ali H. Iqbal
 */
public class BackGroundSound implements Runnable{
	private Media a;
	public BackGroundSound(String f){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+f);
			a = MediaManager.createMedia(is, "audio/wav", this);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	} //pause music
	public void pause(){ a.pause();}
	public void play(){ a.play();} 
	
	public void run() {
		//starts when time zero
		while(a.getTime()>0){ 
			a.setTime(0);
			a.play();
		}
    }
}