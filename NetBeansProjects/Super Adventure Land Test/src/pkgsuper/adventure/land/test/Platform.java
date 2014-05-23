/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Emily Leng
 */
public class Platform {
    private int dx;
    private int x, y, width, height;

    public Platform() {
    dx = -5; 
    x = 300;
    y = 300;
    width = 100;
    height = 40;
    }
    
    public Platform(int x, int y){
        this.x = x;
        this.y = y;
        width = 120;
        height = 40;
        dx = -5;
    }
    
    public void update(Map t, Character b){
        //x += dx;
        checkForCollision(b);
        
    }
    
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        //g.drawRect(x,y,width,height); 
    }

    private void checkForCollision(Character b) {
        int ballX = b.getX();
        int ballY = b.getY();
        int radius = b.getRadius();
        
        //checks if ball is within platform, if yes, reposition and reverse direction
        if (ballX + radius >= x && ballX - radius <= x + width && ballY + radius > y+height/3 && ballY + radius < y + 2*height/3){
            double newDy = b.getDy();
            b.setY(y-radius-1);
            b.setDy((int)-newDy);
    }
        else if (ballX + radius >= x && ballX - radius <= x + width && ballY + radius > y && ballY + radius < y + height/2){
            double newDy = b.getDy();
            b.setY(y-radius-1);
            b.setDy((int)-newDy);
    }
        else if (ballX + radius >= x && ballX - radius <= x + width && ballY - radius > y + height/2 && ballY - radius < y + height){
            double newDy = b.getDy();
            b.setY(y+height+radius);
            b.setDy((int)-newDy);
    
    }
        
    }
}
