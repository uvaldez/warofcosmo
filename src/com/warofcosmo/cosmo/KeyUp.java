package com.warofcosmo.cosmo;

import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyUp extends AbstractKeyEvent{
	
	public KeyUp(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_UP){
			p.setDy(-p.getSpeed());
			p.setGFX(p._shipimg.get(1).getImage());
		 }
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_UP){
			p.setDy(0);
			p.setGFX(p._shipimg.get(0).getImage());
		}
	  }
}
