package com.mycompany.a3.GameObjects;

import com.mycompany.a3.Interfaces.*;
import java.util.ArrayList;
import java.util.Collection;
/**
 * @author Ali H. Iqbal
 */
//This class contains object collection methods
public class GameObjectCollection implements ICollection{

	private ArrayList<GameObject> collection; 
	
	public GameObjectCollection(){
		collection = new ArrayList<GameObject>();
	}
	
    //remove object method 
	public void remove(GameObject obj) {
		collection.remove(obj);
	}
	
	//add object method
    public void add(GameObject obj) {
	    collection.add(obj);
    }

	//remove all elements in from the ArrayList 
		public void removeAll(){
			collection.clear();
		}
		
		  //remove end method to add to the collection 
		public void removeEnd(GameObject obj) {
			collection.remove(collection.lastIndexOf(obj));
		}
	
	//get itterator method 
	public IIterator getIterator() {

		return new objCollectionIter();
	}
	
	//implement iterator as a private inner class
	private class objCollectionIter implements IIterator
	{
		private int currIndx;
		
		public objCollectionIter()
		{
			currIndx = -1;
		}
		
		public Object getNext() {
			currIndx++;
			return(collection.get(currIndx));
		}
		
		public boolean hasNext() {
			if(collection.size() <= 0) 
				return false;
			
			if(currIndx == collection.size() - 1)
				return false;
			
			return true;
		}
	}

}
