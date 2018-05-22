package com.mycompany.a3.Interfaces;

import com.mycompany.a3.GameObjects.*;;
/**
 * @author Ali H. Iqbal
 */
public interface ICollection {
	void remove(GameObject newObj);
	void removeEnd(GameObject newObj);
	void add(GameObject newObj);
	IIterator getIterator();
}
