/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgsuper.adventure.land.test;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
/**
 *
 * @author Emily Leng
 */
public class BallTest extends Applet implements Runnable, KeyListener{ 
    private Ball b,b2;
    private Platform p [] = new Platform[7]; //array of 7 platforms for game
    private KeepTime t;
    private Image i;
    static Thread thread1;
    private Graphics doubleBuffer;
    
    @Override
    //initializes applet, called first
    public void init() {
        setSize(800, 600); //sets window size
        addKeyListener(this);
    }

    //called after init method
    public void start() {
        b = new Ball();
        //b2 = new Ball(250,250);
        for (int i = 0; i < p.length; i++){ //randomly places the 7 platforms
            Random r = new Random();
            p[i] = new Platform(getWidth() + 200 * i, getHeight() - 40 - r.nextInt(400));
        }
        
        t = new KeepTime(10);
        thread1 = new Thread(this); //this refers to the run method defined below
        thread1.start();
    }
    
    //used in the start method for the thread
    @Override
    public void run() {
        //thread information
        while(true){ //restrict x and y to be within window size, bonces off walls
            b.update(this);
            //b2.update(this);
            for (int i = 0; i < p.length; i++){
                p[i].update(this, b);
            }
            t.update(this);
            repaint();
            try{ //if it can't sleep, print an exception
            Thread.sleep(17); //repaints about 64 frames per second, sleep for 17 milliseconds
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
    public void paint(Graphics g) { //prints cyan circle
        b.paint(g);
        //b2.paint(g);
        for (int i = 0; i < p.length; i++){
                p[i].paint(g);
            }
        t.paint(g);
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){ //KeyCode returns int of key pressed
                case KeyEvent.VK_LEFT: //left arrow key
                    b.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    b.moveRight();
                    break;
                /*case KeyEvent.VK_UP:
                    b.moveUp();
                    break;
                case KeyEvent.VK_DOWN:
                    b.moveDown();
                    break;*/
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    
    
    }
