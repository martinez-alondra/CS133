package com.mycompany.a2;
/**
 * @author Ali H. Iqbal
 */
public abstract class FixedObject extends GameObject {
	
	/*----Fixed ID Variables----*/
	private int ident;
	private static int uniqueId = 0;
	private boolean xLocSet = false;
	private boolean yLocSet = false;
	

	/*----Getters and setters----*/
	
	public void setYlocation(double y) {
		if (!yLocSet) {
			super.setXlocation(y);
			yLocSet = true;
		}
	}
	
	public void setXlocation(double x) {
		if (!xLocSet) {
			super.setXlocation(x);
			xLocSet = true;	
		}
	}

	public int getIdent() { 
		return this.ident; 	
	}

	public FixedObject() {
		this.ident = uniqueId;
		uniqueId++;
	}
	
	
}
