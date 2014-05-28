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
    /*
    Initializes the applet, is called first.
    */
    public void init() {
        setSize(800, 600); //sets window size
        setBackground(Color.DARK_GRAY);
        addKeyListener(this);
    }

    /*
    Is called after the init method.
    */
    public void start() {
        c = new Character();
        for (int i = 0; i < p.length; i++){ //randomly places the 7 platforms
            Random r = new Random();
            p[i] = new Platform(200 * i, getHeight() - 40 - r.nextInt(400));
        }
        h = new HealthBar(c);
        t = new KeepTime(5);
        l = new LevelLabel("#");
        thread1 = new Thread(this); //this refers to the run method defined below
        thread1.start();
    }
    
    /*
    Used to update the Thread and everything it contains.
    */
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

    /*
    Implements double buffering to get rid of the flickering when painting.
    */
    @Override
    public void update(Graphics g) {
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

    
    /*
    Paints all the objects.
    */
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
    /*
    Keyboard controls, used to move the Character around the map with the arrow keys.
    */
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
   
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    
    
    }
