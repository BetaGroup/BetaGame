package FinalProduct;

import java.awt.Graphics;
import java.awt.Rectangle;
/*
@author Jonathan
*/
public abstract class GameObjects {
    protected int x;
    protected int y;
    protected Obj_ID id;
    protected int velX = 0;
    protected int velY = 0;
    
    //constructor 
    public GameObjects(int x, int y, Obj_ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
   public abstract void update();
   public abstract void render(Graphics g);
   public abstract Rectangle getBounds(); // for collision 
    
   /*
   Getters and setters for objects X/Y/ID/VelX/VelY
   */
   
    public void setID(Obj_ID id){
        this.id = id;
    }
    public Obj_ID getID(){
        return id;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
}

    
    

