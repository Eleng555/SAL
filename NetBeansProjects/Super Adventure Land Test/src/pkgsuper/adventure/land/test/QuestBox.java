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
public class QuestBox extends Platform{
    
    private int dx;
    private int x, y, width, height;
    private Character ch;
    private boolean collide = false, passable = true;
    private int id;
    private boolean activation;
    public QuestBox() {
    dx = -5; 
    x = 300;
    y = 300;
    width = 75;
    height = 110;
    id=0;
    activation=false;
    }
    
    public QuestBox(int x, int y, Character c,int i){
        this.x = x;
        this.y = y;
        width = 75;
        height = 110;
        dx = -5;
        ch = c;
        id=i;
        activation=false;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x,y,width,height);
        if(activation==true){
            for(Quest q:LevelOne.getQuests()){
                if(q.getId()==this.getId())
                    q.paint(g);
            }
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
    
    public boolean checkForCollision(Character c){
        int ballX = c.getX();
        int ballY = c.getY();
        int radius = c.getRadius();
        if (passable){
        //checks if ball is within platform, if yes, reposition and reverse direction
        if (ballX + radius  >= x && ballX <= x + width/2 && ballY >= y && ballY + radius + radius <= y + height ){
            double newDx = c.getDx();
            if (c.getDx () < 0)
            c.setX(x - radius - 1);
            c.setDx((int)-newDx);
            collide = true;
    }
        if (ballX + radius  >= x + width/2 && ballX <= x + width && ballY >= y && ballY + radius + radius <= y + height ){
            double newDx = c.getDx();
            c.setX(x + radius + width + 1);
            c.setDx((int)-newDx);
            collide = true;
    }
}
            
    
        return collide;
    }
}
