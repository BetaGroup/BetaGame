/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JonathansCode;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
    import javax.swing.JFrame;
    import static javax.swing.JFrame.EXIT_ON_CLOSE;
    import javax.swing.JPanel;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;
    /**
     *
     * @author KnightLife
     */
public class Menu extends Canvas{
    
      int WIDTH = 800;
    int HEIGHT = 800;
    

   
        public Menu(GameLooper aThis) {
            
        JFrame frame = new JFrame("Beta game"); //title     
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // seting up new
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT)); // dimentions 
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit in frame
        frame.setResizable(false); // user cant resize
        frame.setLocationRelativeTo(null); // makes window start in middlewindow
        
        frame.getContentPane().setBackground(java.awt.Color.BLACK);
        
          aThis.start(); // runs the start method  
            //frame.setBackground(java.awt.Color.BLACK);
        //create the buttons and set their positions
            frame.setLayout(null); //removes any java based lay out
            Buttons Play = new Buttons("Play", 50);
            Play.setBounds(325, 50, 260,150);
            frame.add(Play);
            
            frame.setLayout(null); //removes any java based lay out
            Buttons Settings = new Buttons("Settings", 50);
            Settings.setBounds(325, 250, 260,150);
            frame.add(Settings);
            
            frame.setLayout(null); //removes any java based lay out
            Buttons HighScore = new Buttons("High Score", 45);
            HighScore.setBounds(325, 450, 260,150);
            frame.add(HighScore);
            
            frame.setLayout(null); //removes any java based lay out
            Buttons Credits = new Buttons("Credits", 50);
            Credits.setBounds(325, 650, 260,150);
            frame.add(Credits);
      
        frame.add(aThis);
        frame.setVisible(true); //you can see the frame!
  
            
            
           
        }

      
    }