package samuelCode;

import Engine.Bullet;
import Engine.GameLooper;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
    private int startingPositionX;
    private int startingPositionY;
    private int moveOnCoordX;
    private int moveOnCoordY;
    
    private int speed;
    private int lives;

    private boolean left, right, up, down, firing;
    private int widht, height, border, movement;
    private Color EnemyColor;
    private long fireTimer, bullet_delay;
    
    public Enemy(int startingPositionX, int startingPositionY,
            int speed, int lives, Color EnemyColor, int widht,
            int height){
        this.startingPositionX = startingPositionX;
        this.startingPositionY = startingPositionY;
        this.moveOnCoordX = startingPositionX;
        this.moveOnCoordY = startingPositionY;
        this.speed = 6;
        this.lives = lives;
        this.widht = widht;
        this.height = height;
        this.EnemyColor = EnemyColor;
        //set default values for now
        this.firing = false;
        this.fireTimer = System.nanoTime();
        this.bullet_delay = 100;
        this.border = 30;
        this.movement = 6;
    }
    //you can tell the enemy how to move by using the functions below.
    public void setLeft(boolean value){
        left = value;
    }
    public void setRight(boolean value){
        right = value;
    }
    public void setUp(boolean value){
        up = value;
    }
    public void setDown(boolean value){
        down = value;
    }  
    public void setFiring(boolean value){
        firing = value;
    }
    
    //the update function will cause the emeny to move in the direction
    // you specified
    
    public void update(){          
        System.out.println(GameLooper.WIDTH + ", " + startingPositionX);
        System.out.println(moveOnCoordX);
        System.out.println(moveOnCoordY);
        int bigCircle = 500;
        int medCricle = 300;
        int smCircle = 100;
       switch(movement){
            case 1: 
               //movement side to side
               moveOnCoordX += speed;
                if(moveOnCoordX >= GameLooper.WIDTH - border
                        || moveOnCoordX <= 0 - border){
                    speed *= -1;
                }
               break;
            case 2: 
               //movement up and down
               moveOnCoordY += speed;
                if(moveOnCoordY >= GameLooper.WIDTH - border
                        || moveOnCoordY <= 0 - border){
                    speed *= -1;
                }
               break;
            case 3: 
               //circle movement
                if(moveOnCoordX < bigCircle && moveOnCoordY < bigCircle && up == false){
                    moveOnCoordX += speed;
                } else if (moveOnCoordX >= bigCircle && moveOnCoordY < bigCircle){
                    moveOnCoordY += speed;
                } else if (moveOnCoordY >= bigCircle
                        && moveOnCoordX != startingPositionX){
                    moveOnCoordX -= speed;
                    up = true;
                } else if (up == true) {
                    moveOnCoordY -= speed;
                    if(moveOnCoordX <= startingPositionX && moveOnCoordY <= startingPositionY){
                        up = false;
                    }
                    //this part is laggy, I tryed for hours to fix it
                    //this will cuase the enemy to jump to where it started
                }
               break;
            case 4: 
               //movement sidewise
               moveOnCoordX += speed;
               moveOnCoordY += speed;
                if(moveOnCoordX >= GameLooper.WIDTH
                        || moveOnCoordX <= 0 
                        || moveOnCoordY >= GameLooper.WIDTH
                        || moveOnCoordY <= 0){
                    speed *= -1;
                }
               break;
            case 5: 
               //right triangle movement
               if(moveOnCoordX < medCricle && moveOnCoordY < medCricle){
                    moveOnCoordX += speed; //move right
                } else if (moveOnCoordX >= medCricle && moveOnCoordY < medCricle){
                    moveOnCoordY += speed; //move down
                } else if (moveOnCoordY >= medCricle
                        && moveOnCoordX != startingPositionX){
                    moveOnCoordX -= speed; // to go starting position
                    moveOnCoordY += speed;
                } else if (moveOnCoordX == startingPositionX
                        && moveOnCoordY != startingPositionY) {
                    //this part is laggy, I tryed for hours to fix it
                    //this will cuase the enemy to jump to where it started
                    moveOnCoordY -= speed;
                }

               break;
            case 6: 
               //right triangle movement
               if(moveOnCoordX < 250 && moveOnCoordY < 250 && up == false){
                    moveOnCoordX += speed; 
                    moveOnCoordY += speed;
                } else if( moveOnCoordY == 250 && moveOnCoordX > 0){
                    moveOnCoordX -= speed; 
                    up = true; //next move... go up after you gone to the eage
                }else if( up == true){
                    moveOnCoordY -= speed;
                    if(moveOnCoordX <= startingPositionX && moveOnCoordY <= startingPositionY){
                        up = false;
                    }
                } 
               break;
            case 7: 
                //random movement

               break;
       } 
       
    }
     public void draw(Graphics2D g){
        g.setColor(EnemyColor);
        g.fillRect(moveOnCoordX, moveOnCoordY, widht, height);
    }
}

