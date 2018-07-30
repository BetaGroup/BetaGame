package FinalProduct;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import java.util.Random;
import java.awt.image.BufferStrategy;
import samuelCode.GameInfo;
/*
@author Jonathan
 */


public class GameLooper extends Canvas implements Runnable{
    public static int HEIGHT = 800;
    public static int WIDTH = 800;
    private Thread thread;
    private boolean running = false;
    private ObjectManager om;
    private Random r;
    private GameInfo gameInfo;
    private Menu menu;
    
    public enum STATE
    {
        Menu,
        Game,
        Help,
        HighScore,
        Credits,
        Quit
    }
    
    public STATE gamestate = STATE.Menu;
   s
    //constructor
    public GameLooper() {   
      om = new ObjectManager(); 
      gameInfo = new GameInfo();
      
     
 
      menu = new Menu(this, om);
       
       this.addKeyListener(new PlayerInput(om)); 
       this.addMouseListener(menu);
       
       new GameWindow(this);
      
      
      
     // start();
      
       
       //this is how you can bound object to the screen in random location
         
        }
 
    public synchronized void start() {
         running = true;
        thread = new Thread(this);// this is going to call the run method, thats what thread(this) does
        thread.start();
    }
    public synchronized void stop() {
        
         running = false;
        try {
            thread.join();
           
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //this is where our game loop is located 
    public void run(){
        //mindcraft game loop!
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                ticking();
                delta--;
            }
            if (running) 
                render();
            
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
     private void ticking() { //updates everything
        om.OM_update();
    }
    
     private void render() {
     BufferStrategy bs = this.getBufferStrategy(); 
        if(bs == null){
            this.createBufferStrategy(3); //pre loading frames, no need to go beyound 3
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        ////render screen ////
        g.setColor(Color.white);
        g.fillRect(0,0,WIDTH, HEIGHT);
        //om.render(g);
        
        
        
        
         if(gamestate == STATE.Game)
         {
             om.render(g);
             gameInfo.render(g);
         }
         else if(gamestate == STATE.Menu || gamestate == STATE.Help || gamestate == STATE.HighScore || gamestate == STATE.Credits || gamestate == STATE.Quit)
                 {
                     menu.render(g);
                 }
         g.dispose();
         bs.show();
        
     }
     
    public static void main(String[] args) {
        new GameLooper();
    }
}
 