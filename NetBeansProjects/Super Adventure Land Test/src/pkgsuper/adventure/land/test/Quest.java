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
public class Quest implements MouseMotionListener{
    private String description;
    private int xCoordinate;
    private int yCoordinate;
    private TextField input = new TextField(50);
    private String [] answers = {"jamesgosling", "19", "thematch", "stopimagining", "oak", "210"};
    
    
    public Quest(String s, int x, int y){
    description=s;
    yCoordinate=y;
    xCoordinate=x;
    
    }
    
  
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString(description, xCoordinate, yCoordinate);
        
    }
    
    public void remove(Graphics g){
        g.clearRect(xCoordinate, yCoordinate, 700, 500);
    }
    
    public void mouseClicked(MouseEvent evt){
        int x = evt.getX();
        int y = evt.getY();

        if (evt.getClickCount() >= 2) {
          
        }
    }
    
    public void mouseMoved(MouseEvent evt) {
    int x = evt.getX();
    int y = evt.getY();

    
    if (true)
      return;
    else
      return;
  }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isCorrect(String s){
        for (String answer : answers){
            if (answer.equals(s))
                return true;
        }
        return false;
    }
    }
    
