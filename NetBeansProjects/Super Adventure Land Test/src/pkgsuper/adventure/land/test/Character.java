/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Emily Leng
 */
public class Character extends Applet{
    private int x = 400;
    private int y = 25;
    private int radius = 15;
    private int dx = 1;
    private int dy = 1;
    private double gravity = 50;
    private double energyLoss = 1;
    private double changeInTime = .1;
    private double xFriction = .95;
    private final int upMAX = radius;
    private boolean fin = true;
    private int attack;
    private int health;
    private int currentHealth=0;
    //private final String filename = "Resources//stickRun.gif";  
    private Image chara;  
    
    public Character() {
       
    }
    
    public Character(int i, int j, double g, int a, int h) {
        x = i;
        y = j;
        gravity = g;
        attack = a;
        health = h;
        //java.net.URL appletBaseURL = getCodeBase();
        //chara = getImage(appletBaseURL, filename);
    }
    
    public void moveRight(){
        if (dx+2 < 30)
        {
          dx += 1;
        }
    }
    
    public void moveLeft(){
        if (dx-2 > -30)
        {
            dx -= 1;
        }
        
    }
    
    public void moveUp(){
        
    }   
    public void moveDown(){
        if (dy-2 > -120)
        {
            dy -= 1;
            dx=0;
        }
    }
    
    public void update(Map t){
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
                dy = -dy;
            }
            else if (y < 0 + radius + 1){
                y = radius + 1;
                dy = -dy;
            }
            else {
                dy *= energyLoss;
                dy += gravity * changeInTime; //velocity formula
                y += dy * changeInTime + .5*gravity*changeInTime*changeInTime; //physics equation for position
            
            }
            
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x-radius,y-radius,radius*2,radius*2);
        //g.drawImage(chara, 50, 100, 28, 28, this);
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

    public int getRadius() {
        return radius;
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
    
    public int getHealth()
    {
        return currentHealth;
    }
    
    
    }
   
