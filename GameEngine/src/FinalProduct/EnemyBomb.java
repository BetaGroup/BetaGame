/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Jonathan
 */
public class EnemyBomb extends GameObjects{

    Random r = new Random();
    
    public EnemyBomb(int x, int y, Obj_ID id) {
        super(x, y, id);
        
        velX = r.nextInt(5) +1;
        velY = r.nextInt(5) +1;
    }

    @Override
    public void update() {
        x+= velX;
        y+= velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, 15, 15);
    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
