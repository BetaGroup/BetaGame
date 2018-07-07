/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Graphics;
import java.util.LinkedList;
/*
  @author Jonathan
*/
public class ObjectManager {

    //creating a list of GameObjects
    LinkedList<GameObjects> object = new LinkedList<>();
    
   boolean up = false;
   boolean down = false;
   boolean left = false;
   boolean right = false;

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
    
    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
    
    
    public void OM_update(){
        for (int i = 0; i < object.size(); i++) {
            GameObjects tempObject = object.get(i);
            tempObject.update();
        }
    }
    public void render(Graphics g){
        for (int i = 0; i <object.size(); i++){
            GameObjects tempObject = object.get(i);        
            tempObject.render(g);
        }
    }
    
    public void addObjects(GameObjects object){
        this.object.add(object);
    }
    
    public void removeObject(GameObjects object){
        this.object.remove(object);
    }
}