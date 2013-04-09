package com.warofcosmo.cosmo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Player extends AbstractEntity{
	
	
	public Player(Board brd) {
		super(brd);
		
		_x=100;
		_y=500;
		
		
	}

	@Override
	public void move() {
		_x = _x+_dx;
		_y = _y+_dy;
		
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
            System.out.println("Action");
            if(_dy<0)
            _gfx=_shipimg.get(1).getImage();
            if(_dy>0)
            _gfx=_shipimg.get(2).getImage();
            
	}

	
	public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
           
            if(key == KeyEvent.VK_LEFT){
                _dx = -_speed;
           
            }
            if(key == KeyEvent.VK_RIGHT){
                _dx = _speed;
            }
            if(key == KeyEvent.VK_UP){
                _dy = -_speed;
                
                 _gfx = _shipimg.get(1).getImage();
            }
            if(key == KeyEvent.VK_DOWN){
                _dy = _speed;
                 _gfx = _shipimg.get(2).getImage();
            }
            if(key == KeyEvent.VK_SPACE){
      
            }
		
}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	    if(key == KeyEvent.VK_LEFT){
                _dx = 0;
           
            }
            if(key == KeyEvent.VK_RIGHT){
                _dx = 0;
            }
            if(key == KeyEvent.VK_UP){
                _dy = 0;
                 _gfx = _shipimg.get(0).getImage();
            }
            if(key == KeyEvent.VK_DOWN){
                _dy = 0;
                 _gfx = _shipimg.get(0).getImage();
            }
              
	}
	
}
