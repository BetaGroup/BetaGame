/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.Random;


public class GamePlayEvent_EnemySpawn {

    private ObjectManager om;
    //private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public GamePlayEvent_EnemySpawn(ObjectManager om) {
        this.om = om;
        //this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        //if (scoreKeep >= 200) {
            scoreKeep = 0;
           // hud.setLevel(hud.getLevel() + 1);

       
               
           
    }
}
