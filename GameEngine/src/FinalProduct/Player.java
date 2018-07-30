/*
Code by Jonathan
*/
package FinalProduct;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import samuelCode.GameInfo;


public class Player extends GameObjects{
    ObjectManager om;
    
   
  
    private boolean[] keyDown = new boolean[4];
     
    public Player(int x, int y, Obj_ID id, ObjectManager om){
        super(x,y,id);
        this.om = om;
              
    }
    //i might refactor to player Update so its not confusing 
    public void update(){
        x += velX;
        y += velY;
          
        
        if(om.isUp()){
            velY = -6;
        } else if(!om.isDown()){
            velY = 0;
        }
        if(om.isDown()){
            velY = 6;
        } else if(!om.isUp()){
            velY = 0;
        }
        if(om.isRight()){
            velX = 6;
        } else if(!om.isLeft()){
            velX = 0;
        }
        if(om.isLeft()){
            velX = -6;
        } else if(!om.isRight()){
            velX = 0;
        }
        if(om.isSpace()){
     
            for (int i = 0; i < om.object.size(); i++) {
            GameObjects tempObject = om.object.get(i);

            if(tempObject.getID() == Obj_ID.Player){
                om.addObjects(new Bullet(tempObject.getX()+16, 
                        tempObject.getY()-30, Obj_ID.Bullet, om));
            }
       }
        }
        
        
        if (x >= GameLooper.WIDTH - 38){ // this will make player object not espcape screen
            x = GameLooper.WIDTH - 38;
        } 
        if (x <= 0) {
            x = 0;
        }
        if(y >= GameLooper.HEIGHT - 62){
            y = GameLooper.HEIGHT - 62;
        }
        if (y <= 0) {
            y = 0;
        }
        /*
       if(firing){
           long elapsed = (System.nanoTime() - fireTimer) / 1000000;
           if(elapsed > bullet_delay){
               GameLooper.bullets.add(new Bullet(270, x_cord, y_cord));
               fireTimer = System.nanoTime();
           }   
       }   
*/
        
        collision();
    }
    public void collision (){
        for(int i = 0; i < om.object.size(); i ++){
            GameObjects go = om.object.get(i);
            if(go.getID() == Obj_ID.TestTarget){
                if(getBounds().intersects(go.getBounds())){
                    GameInfo.life -= 1;
                }
            }
        }
    }
    
    public void render(Graphics g) {
         g.setColor(Color.green);
           g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
         return new Rectangle(x, y, 32, 32);
    }
}