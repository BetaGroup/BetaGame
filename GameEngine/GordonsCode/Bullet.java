package GordonsCode;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
/**
 *
 * @author Jonathan
 */
public class Bullet extends GameObjects{
   private  ObjectManager om;
   
   
   public Bullet(int x, int y, Obj_ID id, ObjectManager om, int mx, int my){
       super(x, y, id);
       this.om = om;
       
       velX = (mx - x) / 10;//speed
       velY = (my-y)/ 10;
   }
      

    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
    }
  
    public void update() {
        x+= velX;
        y+=velY;
        
        for(int i = 0; i < om.object.size(); i++){
            GameObjects tempObject = om.object.get(i);
            if(tempObject.getID() == Obj_ID.TestTarget){
                if(getBounds().intersects(tempObject.getBounds())){
                om.removeObject(this);
                }
             }
            if (x >= Betablocks.WIDTH - 38){ // this will make player object not espcape screen
             om.removeObject(this);
        } 
        if (x <= 0) {
            om.removeObject(this);
        }
        if(y >= Betablocks.HEIGHT - 62){
             om.removeObject(this);
        }
        if (y <= 0) {
            om.removeObject(this);
        }
        }
        
        
        
    }

    public void render(Graphics g) {
g.setColor(Color.red);
g.fillOval(x, y, 8, 8);
    }
   
}