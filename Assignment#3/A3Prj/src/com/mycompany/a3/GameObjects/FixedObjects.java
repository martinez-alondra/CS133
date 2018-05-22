package com.mycompany.a3.GameObjects;
/**
 * @author Ali H. Iqbal
 */
//Class defines id number for fixed objects
public abstract class FixedObjects extends GameObject{
	
	private static int idNum = 1;
	FixedObjects(){
		newIdNumber();
	}
	public int getIdNumber(){
		return idNum;
	} 
	public void setIdnumber(int newNum){
		idNum =  newNum;
	}
	public void newIdNumber(){
		idNum++;
	}
	public String toString() {
		String parentDesc = super.toString();
		return parentDesc;
	}   
}
 