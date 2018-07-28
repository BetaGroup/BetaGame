/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GordonsCode;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Jonathan
 */
public class Player_Mouse extends MouseAdapter{
    private ObjectManager om;
    

    public Player_Mouse(ObjectManager om) {
        this.om = om;
    }
    

    public void mousePressed(MouseEvent e){
        int mx = (int)e.getX();
        int my = (int)e.getY();
        
       for (int i = 0; i < om.object.size(); i++) {
            GameObjects tempObject = om.object.get(i);

            if(tempObject.getID() == Obj_ID.Player){
                om.addObjects(new Bullet(tempObject.getX()+16, 
                        tempObject.getY()-30, Obj_ID.Bullet, om, mx, my));
            }
       }
    }
}