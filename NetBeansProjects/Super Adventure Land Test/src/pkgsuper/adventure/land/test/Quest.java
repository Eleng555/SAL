/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author vrangan6
 */
public class Quest{
    private String description;
    private int xCoordinate;
    private int yCoordinate;
    private TextField input = new TextField(50);
    private String [] answers = {"jamesgosling", "19", "thematch", "stopimagining", "oak", "210"};
    private boolean completed=false;
    private int id;
    
    /*
    Creates a Quest with a question, an index, and x and y coordinates.
    */
    public Quest(String question, int x, int y, int z){
    description=question;
    yCoordinate=y;
    xCoordinate=x;
    id=z;
    }
    
    public int getId(){
        
        return id;
    }
  
    /*
    Paints a white Quest.
    */
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString(description, xCoordinate, yCoordinate);
        
    }
    

    public void update(int x,Graphics g ){
        if(x==id)
            paint(g);
    }
    
//    public void remove(Graphics g){
//        g.clearRect(xCoordinate, yCoordinate, 700, 500);
//    }
    

    public boolean isCompleted(){
        return completed;
        
    }
  
    /*
    Checks if user-inputted answer is correct.
    */
    public boolean isCorrect(String s){
        for (String answer : answers){
            if (answer.equals(s)){
                completed=true;
            for(QuestBox q:LevelOne.getBoxes()){
                if(this.getId()==q.getId())
                    q.deactivate();
            }
            }
                return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
    
     
    }
