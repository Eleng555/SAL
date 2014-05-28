/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Emily Leng
 */
public class Character {
    private int x = 400;
    private int y = 25;
    private int radius = 20;
    private int dx = 0;
    private int dy = 0;
    private double gravity = 50;
    private double energyLoss = .85;
    private double changeInTime = .04;
    private double xFriction = .95;
    private int attack;
    private int health;
    private int currentHealth=0;

    public Character() {
    }
    
    /*
    Initializes a character with a certain x and y coordinate, gravity of the world, and attack and health.
    */
    public Character(int i, int j, int g, int a, int h) {
        x = i;
        y = j;
        gravity = g;
        attack = a;
        health = h;
    }
    
    /*
    Moves the character right.
    */
    public void moveRight(){
        if (dx+2 < 20)
        {
          dx += 2;
          dy = 0; 
        }
    }
    
    /*
    Moves the character left.
    */
    public void moveLeft(){
        if (dx-2 > -20)
        {
            dx -= 2;
            dy=0;
        }
        
    }
    
    /*
    Moves the character up.
    */
    public void moveUp(){
        if (dy+2 < 10)
        {
            dy *= 1.02;
            dx=0;
        }
    }
    
    /*
    Moves the character down.
    */
    public void moveDown(){
        if (dy-2 > -10)
        {
            dy -= 3;
            dx=0;
        }
    }
    
    /*
    Updates the direction of the character, implements realistic movements such as gravity and friction.
    */
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
    
    /*
    Paints a red Character that is in the shape of a ball.
    */
    public void paint(Graphics g){
        g.setColor(Color.RED);
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
   
