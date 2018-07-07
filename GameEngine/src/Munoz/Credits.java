package Munoz;

import java.awt.Color;
import java.awt.Font;                               // Header for fonts
import java.awt.Graphics;                           // for the paint function
import java.awt.Image;                              // import for images
import java.awt.Toolkit;                            // to make image appear 
import javax.swing.JFrame;                          // Header for frame
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;                          // header for panel, thats extended

public class Credits extends JPanel {

    Font f = new Font("Dialog", Font.ITALIC, 50);           // for the title Credits
    Font b = new Font("Dialog", Font.BOLD, 20);             // body text
    

    public void paint(Graphics g) {                         // code for credits
        Image sam = Toolkit.getDefaultToolkit().getImage("/Munoz/sam.png");        // sam sprite
        g.setFont(f);

        g.setColor(Color.white);

        g.drawString("Credits", 325, 45);
        g.setFont(b);
        g.drawString("This game was brought to you in part by the Beta group", 100, 65);
        g.drawString("For CS 4310, Software Engeneering 1", 100, 85);
        g.drawString("In association with CSUEB, by the talented minds of: ", 100, 105);

        g.drawString("Sam Ruiz", 250, 130);
        g.drawImage(sam, 100, 130, this);
        g.drawString("Jonathan George", 250, 220);
        g.drawString("Pravita Kafley", 250, 310);
        g.drawString("Gordan Man", 250, 400);
        g.drawString("Joel Muñoz", 250, 490);

    }

//    public void mbar() {
//        
////        private JMenuBar menuBar = new JMenuBar();              // for menu bar
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        Frames(menuBar); // Add the menu bar to the window
//        JMenu fileMenu = new JMenu("File"); // Create File menu
//        JMenu elementMenu = new JMenu("Elements"); // Create Elements menu
//        menuBar.add(fileMenu); // Add the file menu
//        menuBar.add(elementMenu); // Add the element menu
//    }

    public static void main(String[] args) {    // code for frame structure

        JFrame frame = new JFrame("Beta Group");
        frame.getContentPane().add(new Credits());
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setBackground(Color.black);                   // for background
        frame.setForeground(Color.white);

    }
}
