package Engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerInput extends KeyAdapter {

ObjectManager om;

    public PlayerInput(ObjectManager om) {
        this.om = om;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < om.object.size(); i++) {
            GameObjects tempObject = om.object.get(i); // use temp object for base

            if (tempObject.getID() == Obj_ID.Player) {
            //key events for player

                if (key == KeyEvent.VK_W) {
                    om.setUp(true);
                }
                if (key == KeyEvent.VK_S) {
                         om.setDown(true);
                }
                if (key == KeyEvent.VK_A) {
                 om.setLeft(true);
                }
                if (key == KeyEvent.VK_D) {
                    om.setRight(true);
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){ // this will close the program pres esc
            System.exit(1);
        }

        //System.out.println(key); when you run code, you can see the printed ascii value for each key
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        for (int i = 0; i < om.object.size(); i++) {
            GameObjects tempObject = om.object.get(i); // use temp object for base

            if (tempObject.getID() == Obj_ID.Player) {
            //key events for player

                if (key == KeyEvent.VK_W) {
                    om.setUp(false);
                }
                if (key == KeyEvent.VK_S) {
                         om.setDown(false);
                }
                if (key == KeyEvent.VK_A) {
                 om.setLeft(false);
                }
                if (key == KeyEvent.VK_D) {
                    om.setRight(false);
                }
            }
        }
    }
}