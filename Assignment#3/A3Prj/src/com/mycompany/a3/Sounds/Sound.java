package com.mycompany.a3.Sounds;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
/**
 * @author Ali H. Iqbal
 */
public class Sound {
	private Media a;
	public Sound(String f) {
		try{
		InputStream in = Display.getInstance().getResourceAsStream(getClass(), "/"+f);
		a = MediaManager.createMedia(in, "audio/wav");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void play() {
		a.play();
	}
}