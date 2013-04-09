package com.warofcosmo.cosmo;

import java.awt.event.KeyEvent;

/**
 *
 * @author dev <blitzkriegdevelopment.com>
 */
public class KeyDown extends AbstractKeyEvent{
	
	public KeyDown(Player p){
		super(p);
	}
	
	@Override
	 public void pressAction(int key) {
		if(key == KeyEvent.VK_DOWN){
			p.setDy(p.getSpeed());
			p.setGFX(p._shipimg.get(2).getImage());
		 }
	 }
	 
	@Override
	  public void releaseAction(int key ) {
		if(key == KeyEvent.VK_DOWN){
			p.setDy(0);
			p.setGFX(p._shipimg.get(0).getImage());
		}
	  }
}
