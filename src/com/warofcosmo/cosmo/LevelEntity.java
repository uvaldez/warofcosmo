/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.warofcosmo.cosmo;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import sun.audio.AudioStream;

/**
 *
 * @author TOSHIBA
 */
public class LevelEntity {
    protected Image _bgfx;
    protected int _speed;
    protected int _length;
    protected int _dx;
    protected String _bgm;
    protected AudioStream as;
    
    public LevelEntity(String Ibg,String Ibgm,int ispeed,int ilength){
        System.out.println(Ibg);
        ImageIcon i = new ImageIcon(getClass().getResource("/"+Ibg));
        _bgfx= i.getImage(); 
        _bgm=Ibgm;
        _speed=ispeed;
        _length=ilength;
        
        LoadBGM(_bgm);
    }
    
    
    private void LoadBGM(String ibgm){
        try{
            String path = new java.io.File(".").getCanonicalPath();
            InputStream in = new FileInputStream(path+"/resources/"+ibgm);
            as = new AudioStream(in);
        }
        catch(Exception e){
            System.out.println("Error Loading media");
        }
        
    }
    public void Move(){
        _dx=_dx-_speed;
    }
    public int getX(){
        return _dx;
    }
    public AudioStream getBGM(){
        return as;
    }
    
    public Image getBG(){        
        return _bgfx;
    }
    
    public int getLength(){
        return _length;
    }

}
