/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import static pkgsuper.adventure.land.test.Map.thread1;

/**
 *
 * @author Emily Leng
 */
public class LevelOne extends Map {
    private Character c1;
    private Platform plat [] = new Platform[24]; //array of 28 platforms for game
    private KeepTime t;
    private HealthBar h;
    private LevelLabel l;
    
    public void start() {
        c1 = new Character();
        int ctr = 0;
        int num = 0;
        for (int i = 0; i < plat.length; i++){ 
            if (ctr < 6)
                plat[i] = new Platform(100 * num, getHeight() - 40);
            else if (ctr < 12)
                plat[i] = new Platform(100 * num + 200, getHeight() - 190);
            else if (ctr < 18)
                plat[i] = new Platform(100 * num, getHeight() - 340);
            else
                plat[i] = new Platform(100 * num + 200, getHeight() - 490);
            ctr++;
            num++;
            if (num == 6)
                num = 0;
            
        }
        
        t = new KeepTime(60);
        h = new HealthBar(c1);
        l = new LevelLabel("1");
        thread1 = new Thread(this); //this refers to the run method defined below
        thread1.start();
    }
    
    public void run() {
        //thread information
        while(true){ //restrict x and y to be within window size, bonces off walls
            c1.update(this);
            for (int i = 0; i < plat.length; i++){
                plat[i].update(this, c1);
            }
            t.update(this);
            h.update(this);
            repaint();
            try{ //if it can't sleep, print an exception
            Thread.sleep(17); //repaints about 64 frames per second, sleep for 17 milliseconds
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void paint(Graphics g) {
        for (int i = 0; i < plat.length; i++){
                plat[i].paint(g);
            }
        h.paint(g);
        t.paint(g);
        c1.paint(g);
        l.paint(g);
    }
    
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){ //KeyCode returns int of key pressed
                case KeyEvent.VK_LEFT: //left arrow key
                    c1.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    c1.moveRight();
                    break;
                case KeyEvent.VK_UP:
                    c1.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    c1.moveDown();
                    break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    switch(e.getKeyCode()){
        case KeyEvent.VK_LEFT:
            c1.setDx(0);
            break;
        case KeyEvent.VK_RIGHT:
            c1.setDx(0);
            break;
        case KeyEvent.VK_UP:
            c1.setDy(0);
            break;
        case KeyEvent.VK_DOWN:
            c1.setDy(0);
            break;
        }
    }
}
