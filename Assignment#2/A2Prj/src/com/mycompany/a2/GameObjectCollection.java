package com.mycompany.a2;

import java.util.ArrayList;
/**
 * @author Ali H. Iqbal
 */
public class GameObjectCollection implements ICollection {
	private ArrayList<GameObject> gwCollection = new ArrayList<GameObject>();;
	
	public void add(GameObject o) {
		// TODO Auto-generated method stub
		this.gwCollection.add(o);
	}

	public IIterator getIterator() {
		// TODO Auto-generated method stub
		return new GameObjectCollectionIterator();
	}
	
	private class GameObjectCollectionIterator implements IIterator {
		private int currIndex = -1;
		
		public boolean hasNext() {
			if (gwCollection.size() <= 0) {
				return false;
			}
			else if (this.currIndex == gwCollection.size()-1) {
			
				return false;
			}
			else {
				return true;
			}
		}

		public GameObject getNext() {
			// TODO Auto-generated method stub
			this.currIndex++;
			return gwCollection.get(this.currIndex);
		}

		public void remove() {
			// TODO Auto-generated method stub
			gwCollection.remove(this.currIndex);
			this.currIndex--;
		}		
	} 
}
