package com.mycompany.a3.Views;

import com.mycompany.a3.Interfaces.*;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.GameObjects.*;
import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Ali H. Iqbal
 */
//Class for game MapView display
public class MapView extends Container implements Observer {

	private GameWorld gw;
	
	public MapView(){
		this.gw = gw;
	}
	
	public void update(Observable observable, Object arg) {    
        setWidth(gw.getWidthX());
        setHeight(gw.getHeightY());
		this.repaint();//call repaint 
		
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		IIterator itr =  GameWorld.find().getIterator();
		
		 while(itr.hasNext()) {
			 GameObject obj = (GameObject) itr.getNext();
			 ((IDrawable) obj).draw(g, pCmpRelPrnt); 
	
	    }
	}
	
	public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
	  
	  if(GameWorld.getinPlay()==false){
		 System.out.println("Currently in Pause mode"); //Game is in pause mode 
		 IIterator itr =  GameWorld.find().getIterator();
		 while(itr.hasNext()) {
			 
			 GameObject obj = (GameObject) itr.getNext();
			 			    
			 if (obj instanceof Asteroids){
				 	if (((Asteroids) obj).contains(pPtrRelPrnt, pCmpRelPrnt)){
				 		    ((Asteroids) obj).setSelected(true);
				 		 
				 		  
				 	}else{
				 			((Asteroids) obj).setSelected(false);
				 			
				 	}
			 }	 	
			 if (obj instanceof Missiles){ 	
			        if (((Missiles) obj).contains(pPtrRelPrnt, pCmpRelPrnt)){
			 				((Missiles) obj).setSelected(true);
			 	    }else{
			 				((Missiles) obj).setSelected(false);
			        }
			 }      
			 repaint(); 
	    }
	  }else{System.out.println("No action, Game is paused!");}
		 
	 }
}
