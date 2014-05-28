/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author eleng6
 */
public class LevelLabel {
    private String l;
    
    public LevelLabel() {
        l = "";
    }
    
    /*
    Creates a label to display what the current level is.
    */
    public LevelLabel(String s){
        l = s;
    }
    
    
    /*
    Paints the label.
    */
    public void paint(Graphics g){
        //long timePass=System.currentTimeMillis();
        g.setColor(Color.WHITE);
        g.drawString("Level " + l, 370, 25);
    }
    
    
    
}
