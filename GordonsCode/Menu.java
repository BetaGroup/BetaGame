/*
 * Welcome to the World of Tomrrow!
 * Jul 22, 2018 
 */
package GordonsCode;

import static GordonsCode.Betablocks.HEIGHT;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import GordonsCode.Betablocks.STATE;
import static GordonsCode.Betablocks.WIDTH;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.awt.event.*;
/**
 *
 * @author KnightLife
 */


public class Menu implements MouseListener 
{
    public boolean hover = false;
    static int height = 800;
    static int width = 800;
    public boolean running = true;
    
    private Betablocks game;
    private ObjectManager om;
    
    
    //Joel's Variabnles
    Font f = new Font("Dialog", Font.ITALIC, 50);
    Font b = new Font("Dialog", Font.BOLD, 20); 
    Font a = new Font("Dialog", Font.CENTER_BASELINE, 12);
    //Font sam = new ImageIcon("sam.png").getImage();

    Menu(Betablocks game, ObjectManager om)
    {
        this.game = game;
        this.om = om;
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println("X = " + mx);
        System.out.println("Y = " + my) ;

        //if mouse is pressed in play
        if (mouseOver(mx, my, 300, 25, 200, 100)) {
            om.addObjects(new Player(WIDTH/2, HEIGHT/2,
                  Obj_ID.Player, om)); 
            game.gamestate = STATE.Game;     
        }

        if (mouseOver(mx, my, 300, 175, 200, 100)) {
            game.gamestate = STATE.Help;
        }

        if (mouseOver(mx, my, 300, 325, 200, 100)) {
            game.gamestate = STATE.HighScore;
        }

        if (mouseOver(mx, my, 300, 475, 200, 100)) {
            
            game.gamestate = STATE.Credits;
            
            if (mouseOver(mx, my, 50, 730, 50, 40))
            {
                game.gamestate = STATE.Menu;
            }
        }

        if (mouseOver(mx, my, 300, 625, 200, 100)) {
            game.gamestate = STATE.Quit;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        hover = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hover = false;
    }

    protected void render(Graphics g) {
        //super.paintComponent(g);

        if (game.gamestate == STATE.Menu) 
        {
            // draw the rectangle here
            g.setColor(java.awt.Color.BLACK);
            g.fillRect(0, 0, 800, 800);

            //draw the rectangles; size 200x100
            g.setColor(java.awt.Color.BLUE);

            g.fillRect(300, 25, 200, 100);

            g.fillRect(300, 175, 200, 100);

            g.fillRect(300, 325, 200, 100);

            g.fillRect(300, 475, 200, 100);

            g.fillRect(300, 625, 200, 100);

            //draw the borders
            g.setColor(java.awt.Color.WHITE);

            //draw left border
            g.fillRect(293, 25, 7, 100);
            g.fillRect(293, 175, 7, 100);
            g.fillRect(293, 325, 7, 100);
            g.fillRect(293, 475, 7, 100);
            g.fillRect(293, 625, 7, 100);

            //draw right border
            g.fillRect(500, 25, 7, 100); //left
            g.fillRect(500, 175, 7, 100); //left
            g.fillRect(500, 325, 7, 100); //left
            g.fillRect(500, 475, 7, 100); //left
            g.fillRect(500, 625, 7, 100); //left

            //draw the top border
            g.fillRect(293, 18, 214, 7);
            g.fillRect(293, 168, 214, 7);
            g.fillRect(293, 318, 214, 7);
            g.fillRect(293, 468, 214, 7);
            g.fillRect(293, 618, 214, 7);

            //draw the bottom border
            g.fillRect(293, 125, 214, 7);
            g.fillRect(293, 275, 214, 7);
            g.fillRect(293, 425, 214, 7);
            g.fillRect(293, 575, 214, 7);
            g.fillRect(293, 725, 214, 7);

            //draw strings
            g.setFont(new Font("ARIAL", Font.BOLD, 50));
            g.drawString("Play", 350, 90);
            g.drawString("Help", 350, 240);

            g.setFont(new Font("ARIAL", Font.BOLD, 35));
            g.drawString("High Score", 310, 390);

            g.setFont(new Font("ARIAL", Font.BOLD, 50));
            g.drawString("Credits", 315, 540);
            g.drawString("Quit", 350, 690);
        }
      
      if(game.gamestate == STATE.Credits)
      {
          //JOELS CODE
        g.setFont(f);                               // this is the header of the page
        g.setColor(Color.white);
        g.drawString("Credits", 325, 42);
        g.drawString("_______", 325, 42);

        g.setFont(b);                               // simple statement to be printed
        g.drawString("This game was brought to you in part by the Beta group", 100, 68);
        g.drawString("For CS 4310, Software Engeneering 1", 100, 88);
        g.drawString("In association with CSUEB, by the talented minds of: ", 100, 108);

        g.drawString("Jonathan George", 250, 130);          // names of creators, placed here due to 
        //g.drawImage(sam, 150, 130, null);                   // specific font style
        g.drawString("Sam Ruiz", 250, 220);
        g.drawString("Pravita Kafley", 250, 310);
        g.drawString("Gordan Man", 250, 400);
        g.drawString("Joel Muñoz", 250, 490);

        g.setFont(a);                       // writing under creators names, specific font for this section
        g.drawString("- Manager", 250, 145);            // Johnathan contribution
        g.drawString("- Enemy creature ---", 250, 160); 
        g.drawString("- SDD Document", 250, 175);
        
        g.drawString("- Enemy creature Kulkuma, Guajataka", 250, 235); // Sam contribution
        g.drawString("- Widget: Timer, Life bar", 250, 250);
        g.drawString("- SDD Document", 250, 265);
        
        g.drawString("- ScoreBoard", 250, 325);         // Pravita contribution 
        g.drawString("- Enemy creature ---", 250, 340);
        g.drawString("- SDD Document", 250, 355);
        
        g.drawString("- Menu", 250, 415);               // Gordan contribution
        g.drawString("- Enemy creature ---", 250, 430);
        g.drawString("- SDD Document", 250, 445);
        
        g.drawString("- Credits", 250, 505);            // Joel contribution
        g.drawString("- Help", 250, 515);
        g.drawString("- Enemy creature ---", 250, 530);
        g.drawString("- SDD Document", 250, 545);
        
        //back button
        g.fillRect(50, 730, 50, 40);
        g.setColor(Color.BLACK);
        g.drawString("Back", 60, 750);
        
        if(game.gamestate == STATE.HighScore)
        {
            //PRATIVAS CODE
            JFrame scoreFrame = new JFrame("Highest Scores");
            scoreFrame.setLayout(new BorderLayout());
            scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //scoreFrame.setBackground(Color.black);
            scoreFrame.pack();
            scoreFrame.setVisible(true);

            ScoreDisplay panel;
            JPanel btnPnl = new  JPanel(new BorderLayout());
            JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton OkButton = new JButton("OK");
            bottombtnPnl.add(OkButton);
            btnPnl.add(bottombtnPnl, BorderLayout.CENTER);
            scoreFrame.add(btnPnl, BorderLayout.SOUTH);
            panel = new ScoreDisplay("scores.txt");
            scoreFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            scoreFrame.setForeground(Color.black);
            scoreFrame.setBackground(Color.black);
            scoreFrame.getContentPane().add(panel, "Center");
            scoreFrame.setSize(panel.getPreferredSize());
            scoreFrame.setVisible(true);

            OkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    scoreFrame.setVisible(false);
                }
            });
        }
        
        
    } 
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) 
    {
        
        if (mx > x && mx < x + width) 
        {
            if (my > y && my < y + height) 
            {
                return true;
            } else 
            {
                return false;
            }
        } else 
        {
            return false;
        }
    }

}
