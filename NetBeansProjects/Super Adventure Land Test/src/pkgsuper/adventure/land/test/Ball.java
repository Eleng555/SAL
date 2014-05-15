/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Tutorial: https://www.youtube.com/watch?v=OPz1X9aQURc&list=PL87AA2306844063D2
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Emily Leng
 */
public class Ball {
    private int x = 400;
    private int y = 25;
    private int radius = 20;
    private int dx = 0;
    private int dy = 0;
    private double gravity = 16;
    private double energyLoss = .9;
    private double changeInTime = .2;
    private double xFriction = .95;

    public Ball() {
    }
    
    public Ball(int i, int j) {
        x = i;
        y = j;
    }
    
    public void moveRight(){
        if (dx+2 < 30)
        dx += 2;
    }
    
    public void moveLeft(){
        if (dx-2 > -30)
            dx -= 2;
    }
    
    public void moveUp(){
        if (dy+2 < 30)
        dy *= 1.7;
    }
    
    public void moveDown(){
        if (dy-2 > -30)
            dy -= .5;
    }
    
    public void update(BallTest t){
        if (x + dx > t.getWidth() - radius - 1){
                x = t.getWidth() - radius - 1;
                dx = -dx;}
            else if (x + dx < 0 + radius){
                x = 0 + radius;
                dx = -dx;
            }
            else{
                x += dx;
            }
            
            //friction
            if (y == t.getHeight() - radius - 1){//bottom of applet
                dx *= xFriction;
                if (Math.abs(dx) < .8){
                    dx = 0;
                }
            }
            
            if (y > t.getHeight() - radius - 1){
                y = t.getHeight() - radius - 1;
                dy *= energyLoss;
                dy = -dy;
            }
            else if (y < 0 + radius + 1){
                y = radius + 1;
                dy = -dy;
            }
            else {
                dy += gravity * changeInTime; //velocity formula
                y += dy * changeInTime + .5*gravity*changeInTime*changeInTime; //physics equation for position
            }
}

    public void paint(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x-radius,y-radius,radius*2,radius*2);
           
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public double getEnergyLoss() {
        return energyLoss;
    }

    public void setEnergyLoss(double energyLoss) {
        this.energyLoss = energyLoss;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
    
    
    }
   

