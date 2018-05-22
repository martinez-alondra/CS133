package com.mycompany.a3.Interfaces;

import com.mycompany.a3.*;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
/**
 * @author Ali H. Iqbal
 */
public interface ISelectable {
	 public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	 public void draw(Graphics g,Point pCmpRelPrnt);
	 public void setSelected(boolean select);
	 public boolean isSelected();
}
