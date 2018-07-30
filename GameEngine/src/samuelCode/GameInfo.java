//display the life, timer and score
package samuelCode;

import JonathansCode.GameLooper;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;

public class GameInfo {
    public static int life = 250; //update health
    public static int totalLife = 250;
    private int secondsPassed = 0;
    private int gameTime = 300; //300 seconds equals 5 minuts
    private int timeLeft = gameTime;
    private int score = 0;
    private String clock = "0:00";
    
    Timer myTimer =  new Timer();
    TimerTask task = new TimerTask(){
        public void secondsToMinuts(int numOfSeconds){
            int minuts = numOfSeconds / 60;
            int seconds = numOfSeconds % 60; 
            //if seconds are less than 10 display a 0 in front for formating
            if(seconds < 10){
                clock = minuts + ":0" + seconds;
            } else {
                clock = minuts + ":" + seconds;
            }
        };
        public void run (){
            secondsPassed++;
            timeLeft = gameTime - secondsPassed;
            secondsToMinuts(timeLeft); //call the function to display the clock
        };
    };
    
    public int getScore(){
        return score;
    }
    
    public void increseScore(int points){
        score = score + points;
    }
     
    public GameInfo (){
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public void tick(int amount){
        life = life - amount;
    }
    public void render (Graphics graphics){
        //display the container for the life
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, totalLife + 10, 50 + 10);
        
        //display life taken
        graphics.setColor(Color.black);
        graphics.fillRect(5, 5, totalLife, 50);
        
         //this is the actuall life of the player object
        graphics.setColor(Color.green);
        graphics.fillRect(5, 5, life, 50);
        
        //if life is half way then change color to yellow
        if(life <= (totalLife / 2)){
            graphics.setColor(Color.yellow);
            graphics.fillRect(5, 5, life, 50);
        }
        //if the player is about to die change the color to red
        if (life <= (totalLife / 4)){
            graphics.setColor(Color.red);
            graphics.fillRect(5, 5, life, 50);
        }
         //dispaly life bar
         Font lifeFont = new Font("ariel", 1, 50);
         graphics.setFont(lifeFont);
         graphics.setColor(Color.black);
         graphics.drawString("Life",80,50);
         
         //display timer
         Font timeFont = new Font("ariel", 1, 50);
         graphics.setFont(timeFont);
         graphics.setColor(Color.black);
         graphics.drawString("" + clock, (GameLooper.WIDTH / 2 ) - 70 ,50);
         //display timer in red as a way to notify the player that time is
         //about to expired
         Font checkPoint = new Font("ariel", 1, 50);
         graphics.setFont(timeFont);
            graphics.setColor(Color.green);
         if(new String(clock).equals("0:30")){
           graphics.setColor(Color.red);
           increseScore(5);
           graphics.drawString("Final Round", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("1:00")){
            increseScore(4); 
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("1:30")) {
            increseScore(3);  
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("2:00")) {
            increseScore(3);  
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("2:30")){
            increseScore(2);
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("3:00")){
            increseScore(1);
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("3:30")){
            increseScore(1);
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("4:00")){
            increseScore(1);
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         } else if (new String(clock).equals("4:30")){
            increseScore(1);
            graphics.drawString("Round Completed!", (GameLooper.WIDTH / 2 ) - 200 ,GameLooper.HEIGHT / 2);
         }
         
         //display score points
         Font scoreFont = new Font("ariel", 1, 50);
         graphics.setFont(scoreFont);
         graphics.setColor(Color.black);
         graphics.drawString(score + "", (GameLooper.WIDTH) - 300,50);
         
         //display game over message if timer or life reaches zero 
         if(timeLeft <= 0 || life <= 0){
            Font goFont = new Font("ariel", 1, 50);
            graphics.setFont(goFont);
            graphics.setColor(Color.black);
            graphics.drawString("Game Over", (GameLooper.WIDTH / 2 ) - 100  ,GameLooper.HEIGHT /2);
            myTimer.cancel(); //stop timer countdown
            timeLeft = 0;
            life = 0;
        }
    }
}