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
	
	// contructor method
	public Board(){
		//ImageIcon i = new ImageIcon(getClass().getResource("/bg1.png"));
		//bgimg = i.getImage();
                l=new LevelEntity("bg1.png","/resources/project4.wav",1,2000);
                
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
