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
public class HealthBar {
    private final Integer health;
    private Character ch;
    private final int width, height;
    private double amountRed;
    
    public HealthBar() {
        health = new Integer(0);
        ch = new Character();
        width = 100;
        height = 50;
    }
    
    public HealthBar(Character c){
        health = new Integer(c.getHealth());
        ch = c;
        width = 150;
        height = 25;
    }
    
    

    public void paint(Graphics g){
        //long timePass=System.currentTimeMillis();
        g.setColor(Color.WHITE);
        g.drawString("Health:", 590, 25);
        g.setColor(Color.GREEN);
        g.fillRect(640, 10, width, height);
        g.setColor(Color.RED);
        g.fillRect(640, 10, (int) (amountRed * width), height);
    }
    
    public void update(Map t){ 
        amountRed = (1-((double)ch.getHealth()/health));
         
    }
    
    
}
