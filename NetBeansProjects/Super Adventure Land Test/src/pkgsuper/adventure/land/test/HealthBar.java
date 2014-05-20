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
    private double amountRed;
    private final int width, height;
    
    public HealthBar() {
        width = 100; 
        height = 50;
        health = new Integer(0);
        ch = new Character();
    }
    
    public HealthBar(Character c){
        width = 100;
        height = 50;
        ch = c;
        health = new Integer(c.getHealth());
    }
    
    

    public void paint(Graphics g){
        //long timePass=System.currentTimeMillis();
        g.setColor(Color.BLACK);
        g.drawString("Health:", 625, 15);
        g.drawString(ch.getHealth().toString()+ " / " + health.toString(), 650, 15);
        g.setColor(Color.GREEN);
        g.drawRect(675,15,width,height);
        g.setColor(Color.RED);
        g.drawRect(675,15,amountRed, height);
        
    }
    
    public void update(Map t){ 
        amountRed = ((1-((double)ch.getHealth()/health))*width);
        } 
    
    }
      
    
