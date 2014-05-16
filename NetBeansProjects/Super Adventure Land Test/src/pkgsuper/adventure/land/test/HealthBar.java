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
    private Integer secs;
    private final int total;
    private long timePass;
    private long currentTime;
    
    public HealthBar() {
        total=0;
        timePass = System.currentTimeMillis();
    }
    
    public HealthBar(int health){
        secs = new Integer(health);
        total = health;
        timePass = System.currentTimeMillis();
    }
    
    

    public void paint(Graphics g){
        //long timePass=System.currentTimeMillis();
        g.setColor(Color.BLACK);
        g.drawString("Time Left:", 10, 15);
        g.drawString(secs.toString(), 75, 15);
        
    }
    
    public void update(BallTest t){ 
        currentTime = System.currentTimeMillis();
        if (secs.intValue()==0)
        secs = new Integer(0);
            
        else if ((currentTime - timePass) >= 983 && (currentTime - timePass) <= 1017){
        secs = new Integer(secs.intValue() - 1);
        timePass = currentTime;
        currentTime = System.currentTimeMillis();
        } 
    }
    
    public static void main (String[] args){
        for (int ind = 0; ind < 5; ind++){
        System.out.println(System.currentTimeMillis());
        try{
        Thread.sleep(1000);}
        catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
}