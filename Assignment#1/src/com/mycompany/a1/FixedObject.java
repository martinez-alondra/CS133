package com.mycompany.a1;
/**
 * @author Ali H. Iqbal
 */
public abstract class FixedObject extends GameObject {
	
	/*----Fixed ID Variables----*/
	private static int uniqueId = 21; 
	private int ident;

	/*----Getters and setters----*/
	public void setIdent(int id) { 
		this.ident = id; 
	}
	public int getIdent() { 
		return ident; 	
	}
	public static void setUniqId(int id) {
		FixedObject.uniqueId = id;
	}
	public static int getUniqId() { 
		return uniqueId;
	}
	public FixedObject() {
		this.ident = uniqueId;
		uniqueId++;
	}
	
	/*----String Method----*/
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " ID=" + ident;
		return parentDesc + myDesc;
	}
	
}
