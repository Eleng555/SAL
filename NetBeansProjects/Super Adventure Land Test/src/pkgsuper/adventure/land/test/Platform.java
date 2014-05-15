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
 * @author Emily Leng
 */
public class Platform {
    private int dx;
    private int x, y, width, height;

    public Platform() {
    dx = -10; 
    x = 300;
    y = 300;
    width = 120;
    height = 40;
    }
    
    public void update(BallTest t){
        
            
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        //g.drawRect(x,y,width,height); 
    }
}
