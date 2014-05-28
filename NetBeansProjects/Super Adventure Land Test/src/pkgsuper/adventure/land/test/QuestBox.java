/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author Emily Leng
 */
public class QuestBox extends Platform{
    private int x, y, width, height;
    private Character ch;
    private boolean collide = false;
    private int id;
    private boolean activation;
    public QuestBox() {
    x = 300;
    y = 300;
    width = 75;
    height = 110;
    id=0;
    activation=false;
    }
    
    /*
    Creates a Quest box with height, width, index, and x and y coordinates.
    */
    public QuestBox(int x, int y, Character c,int i){
        this.x = x;
        this.y = y;
        width = 75;
        height = 110;
        ch = c;
        id=i;
        activation=false;
    }
    
    /*
    Paints the QuestBox and allows user input for answers.
    */
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x,y,width,height);
        if(activation==true){
            
        }
            
    }
    public void deactivate(){
        activation=false;
        
    }
    public void update(Map m, Character ch){
        super.update(m,ch);
        if (checkForCollision(ch)){
            activation=true;
            ch.setDx(0);
        }
    }
    public int getId(){
        return id;
    }
    /*
    Checks if the Character collides with the QuestBox, and reverses its direction so it bounces off it.
    */
    public boolean checkForCollision(Character c){
        int ballX = c.getX();
        int ballY = c.getY();
        int radius = c.getRadius();
        //checks if ball is within platform, if yes, reposition and reverse direction
        if (ballX + radius -15  >= x && ballX <= x + width/2 && ballY >= y && ballY + radius + radius <= y + height ){
            double newDx = c.getDx();
            //if (c.getDx () < 0)
            //c.setX(x - radius - 1);
            c.setDx((int)-newDx);
            collide = true;
    }
        if (ballX + radius  >= x + width/2 && ballX <= x + width && ballY >= y && ballY + radius + radius <= y + height ){
            double newDx = c.getDx();
            //c.setX(x + radius + width + 1);
            c.setDx((int)-newDx);
            collide = true;
}
            
    
        return collide;
    }

    public int getWidth() {
        return width;
    }
    
    
}
