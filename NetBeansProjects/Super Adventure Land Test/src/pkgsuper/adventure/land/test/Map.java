/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package pkgsuper.adventure.land.test;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 *
 * @author eleng6
 */
    

public class Map extends Applet implements Runnable, KeyListener{ 
    private static Character c;
    private Platform p [] = new Platform[4]; //array of 4 platforms for game
    private KeepTime t;
    private Image i;
    private LevelLabel l;
    private HealthBar h;
    static Thread thread1;
    private Graphics doubleBuffer;
    
    @Override
    //initializes applet, called first
    public void init() {
        setSize(800, 600); //sets window size
        setBackground(Color.DARK_GRAY);
        addKeyListener(this);
    }

    //called after init method
    public void start() {
        c = new Character();
        for (int i = 0; i < p.length; i++){ //randomly places the 7 platforms
            Random r = new Random();
            p[i] = new Platform(200 * i, getHeight() - 40 - r.nextInt(400));
        }
        h = new HealthBar(c);
        t = new KeepTime(60);
        l = new LevelLabel("#");
        thread1 = new Thread(this); //this refers to the run method defined below
        thread1.start();
    }
    
    //used in the start method for the thread
    @Override
    public void run() {
        //thread information
        while(true){ //restrict x and y to be within window size, bonces off walls
            c.update(this);
            for (int i = 0; i < p.length; i++){
                p[i].update(this, c);
            }
            h.update(this);
            t.update(this);
            repaint();
            try{ //if it can't sleep, print an exception
            Thread.sleep(16); //repaints about 64 frames per second, sleep for 17 milliseconds
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void update(Graphics g) { //double buffering, prevents flickering when painting
        if(i == null){
            i = createImage(this.getSize().width, this.getSize().height);
            doubleBuffer = i.getGraphics();
        }
        doubleBuffer.setColor(getBackground());
        doubleBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);
        doubleBuffer.setColor(getForeground());
        paint(doubleBuffer);
        g.drawImage(i, 0, 0, this);
    }

    
    
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < p.length; i++){
                p[i].paint(g);
            }
        l.paint(g);
        h.paint(g);
        t.paint(g);
        c.paint(g);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){ //KeyCode returns int of key pressed
                case KeyEvent.VK_LEFT: //left arrow key
                    c.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    c.moveRight();
                    break;
                case KeyEvent.VK_UP:
                    c.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    c.moveDown();
                    break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    switch(e.getKeyCode()){
        case KeyEvent.VK_LEFT:
            c.setDx(0);
            break;
        case KeyEvent.VK_RIGHT:
            c.setDx(0);
            break;
        case KeyEvent.VK_UP:
            c.setDy(0);
            break;
        case KeyEvent.VK_DOWN:
            c.setDy(0);
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    
    
    }
