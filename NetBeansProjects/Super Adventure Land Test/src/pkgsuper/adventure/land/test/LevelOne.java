/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.ArrayList;
import static pkgsuper.adventure.land.test.Map.thread1;

/**
 *
 * @author Emily Leng
 */
public class LevelOne extends Map {
    private Character c1;
    private Platform plat [] = new Platform[24]; //array of 28 platforms for game
    private QuestBox q [] = new QuestBox[5];
    private ArrayList<Quest> quests = new ArrayList<Quest>();
    private KeepTime t;
    private HealthBar h;
    private LevelLabel l;
    
    public void start() {
        c1 = new Character(getWidth() - 20,getHeight(),50,0,0);
        int ctr = 0;
        int num = 0;
        //makes all the platforms for the map
        for (int i = 0; i < plat.length; i++){ 
            if (ctr == 0)
                plat[i] = new StartPlatform(100 * num, getHeight() - 40);
            else if (ctr < 6)
                plat[i] = new Platform(100 * num, getHeight() - 40);
            else if (ctr < 12)
                plat[i] = new Platform(100 * num + 200, getHeight() - 190);
            else if (ctr < 18)
                plat[i] = new Platform(100 * num, getHeight() - 340);
            else if (ctr == 24)
                plat[i] = new ExitPlatform(100 * num + 200, getHeight() - 490);
            else
                plat[i] = new Platform(100 * num + 200, getHeight() - 490);
            ctr++;
            num++;
            if (num == 6)
                num = 0;
            
}
        //makes five QuestBoxes
        for (int i = 0; i < 5; i++){
            if (i == 0)
                q[i] = new QuestBox(100 * i + 500, getHeight() - 600, c1);
            else if (i == 1)
                q[i] = new QuestBox(100 * i + 200, getHeight() - 150, c1);
            else if (i == 2)
                q[i] = new QuestBox(100 * i + 300, getHeight() - 300, c1);
            else if (i == 3)
                q[i] = new QuestBox(100 * i - 50, getHeight() - 450, c1);
            else if (i == 4)
                q[i] = new QuestBox(100 * i + 120, getHeight() - 450, c1);
        }
        
        //makes an ArrayList of five Quests
        for (int ind = 0 ; ind < 5; ind++){
           if (ind == 0)
               quests.add(new Quest("How many sides does a Enneadecagon have?", 25, 25));
           else if(ind == 1)
               quests.add(new Quest("You are in a cabin and it is pitch black. You have one match on you. Which do you light first, the newspaper, the lamp, the candle or the fire?", 25, 25));
           else if (ind == 2)
               quests.add(new Quest("Imagine you are in a room, no doors windows or anything, how do you get out?", 25, 25));
           else if (ind == 3)
               quests.add(new Quest("What was Java called before it was Java?", 25, 25));
           else if (ind == 4)
               quests.add(new Quest("Given two hex values, 2E and A4, what is the decimal value when they are added?", 25, 25));
           
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
            for (int i = 0; i < q.length; i++){
                q[i].update(this, c1);
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
        for (int i = 0; i < q.length; i++){
                q[i].paint(g);
            }
        h.paint(g);
        t.paint(g);
        c1.paint(g);
        l.paint(g);
        int ctr = 0;
        if (ctr == 0 && q[ctr].checkForCollision(c1)){
                quests.get(ctr).paint(g);
            }
        //add for other quests
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
    
    }
}
