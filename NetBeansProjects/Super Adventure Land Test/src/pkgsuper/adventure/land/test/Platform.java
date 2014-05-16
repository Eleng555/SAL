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
    width = 120;
    height = 40;
    }
    
    public Platform(int x, int y){
        this.x = x;
        this.y = y;
        width = 120;
        height = 40;
        dx = -5;
    }
    
    public void update(BallTest t, Ball b){
        //x += dx;
        checkForCollision(b);
        /*
        //if the platform scrolls off to map to the left, reposition at right with random y coordinate
        if (x < 0 - width){ 
            Random r = new Random();
            x = t.getWidth() + r.nextInt(300);
                
        }    */
    }
    
    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        //g.drawRect(x,y,width,height); 
    }

    private void checkForCollision(Ball b) {
        int ballX = b.getX();
        int ballY = b.getY();
        int radius = b.getRadius();
        
        //checks if ball is within platform, if yes, reposition to above and reverse direction
        if (ballY + radius > y && ballY + radius < y + height){ 
            if (ballX > x && ballX < x + width){
            double newDy = b.getGameDy();
            b.setY(y-radius);
            b.setDy(newDy);
            }
        }
        
    }
}
