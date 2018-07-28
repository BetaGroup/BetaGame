package GordonsCode;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.image.BufferStrategy;
/*
@author Jonathan
 */
public class Betablocks extends Canvas implements Runnable{
    public static int HEIGHT = 900;
    public static int WIDTH = 800;
    private Thread thread;
    private boolean running = false;
    private ObjectManager om;
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
   
    //constructor
    public Betablocks() {

       om = new ObjectManager(); 
 
       menu = new Menu(this, om);
       this.addKeyListener(new PlayerInput(om)); 
       this.addMouseListener(menu);
   
       new GameWindow(this);
       
       
       
          // om.addObjects(new Player(WIDTH/2, HEIGHT/2,
           //         Obj_ID.Player, om));    
           
          //om.addObjects(new TestTarget(100, 100,
            //        Obj_ID.TestTarget ,om));  
       
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
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);
         om.render(g);
         if(gamestate == STATE.Game)
         {
             
             om.render(g);
         }
         else if(gamestate == STATE.Menu || gamestate == STATE.Help || gamestate == STATE.HighScore || gamestate == STATE.Credits || gamestate == STATE.Quit)
                 {
                     menu.render(g);
                 }
         
        //////////////////////
        g.dispose();
        bs.show();
     }
     
    public static void main(String[] args) {
        new Betablocks();
    }
}
