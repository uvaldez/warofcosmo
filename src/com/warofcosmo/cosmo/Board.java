package com.warofcosmo.cosmo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import sun.audio.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel implements ActionListener, KeyListener {
	
	private Image bgimg;
        private Timer time;
        private Player p;
        private LevelEntity l;
        protected AudioStream as;
        private int level;
	
	// contructor method
	public Board(){
            
                level=1;
            
                if(level==1){
                l=new LevelEntity("bg2.png","project4.wav",1,2000);
                }else{
                l=new LevelEntity("mountains1.png","front-line.wav",1,2000);    
                }
                bgimg=l.getBG();
                as=l.getBGM();
                
                AudioPlayer.player.start(as);
                addKeyListener(this);
                setFocusable(true);
                setFocusTraversalKeysEnabled(false); 
                
                p = new Player(this);
                
                time = new Timer(5,this);
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
                p.move();
                l.Move();
		repaint();
	}
        
        @Override
        public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(bgimg,l.getX(),0,null);
                g2d.drawImage(p.getImage(),p.getX(),p.getY(),null);

        }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
	}
}
