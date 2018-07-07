/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Jonathan
 */
public class TestTarget extends GameObjects{
      
    private final ObjectManager om;
    
      public TestTarget(int x, int y, Obj_ID id, ObjectManager om) {
      super(x, y, id);
           velX = 5;
        this.om = om;
        velX = 5;
    
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 100, 100);
    }


    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 100, 100);
    }

    @Override
    public void update() {
        x += velX; // location update
        y += velY;
        
         if (y <= 0 || y >= GameLooper.HEIGHT) {
            velY *= -1; //when object hits wall velocity is reversed 
        }
        if (x <= 0 || x >= GameLooper.WIDTH -100 ) {
            velX *= -1; //when object hits wall velocity is reversed
        }
        
    }
}

    