/*
 * Welcome to the World of Tomrrow!
 * Jul 5, 2018 
 */
package GordonsCode;


import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author KnightLife
 */
public class Menu extends JFrame implements MouseListener
{
    public Menu()
    {
    //create the window
        JPanel panel = new JPanel();
        setTitle("Menu");
        setVisible(true);
        setSize(875,875);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        
        
        //create the buttons and set their positions
        panel.setLayout(null); //removes any java based lay out
        Buttons Play = new Buttons("Play", 50);
        Play.setBounds(325, 50, 260,150);
        panel.add(Play);
        
        panel.setLayout(null); //removes any java based lay out
        Buttons Settings = new Buttons("Settings", 50);
        Settings.setBounds(325, 250, 260,150);
        panel.add(Settings);
        
        panel.setLayout(null); //removes any java based lay out
        Buttons HighScore = new Buttons("High Score", 45);
        HighScore.setBounds(325, 450, 260,150);
        panel.add(HighScore);
        
        panel.setLayout(null); //removes any java based lay out
        Buttons Credits = new Buttons("Credits", 50);
        Credits.setBounds(325, 650, 260,150);
        panel.add(Credits);
        
        panel.setBackground(java.awt.Color.BLACK);
        
        
        add(panel);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       new Menu();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
      }
    
}



