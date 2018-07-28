package GordonsCode;
import java.awt.Color;
import java.awt.Font;                               // Header for fonts
import java.awt.Graphics;                           // for the paint function
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Credits extends Panel {
// attributes
    Font f;           // for the title Credits
    Font b;           // body text
    Font a;           // for text, that list the ceators contribution
    Image sam; 
    Image Gordan;
    Image Pravita;
    Image Jonathan;
    Image Joel;

    public Credits() {
        f = new Font("Dialog", Font.ITALIC, 50);
        b = new Font("Dialog", Font.BOLD, 20); 
        a = new Font("Dialog", Font.CENTER_BASELINE, 12);
        sam = new ImageIcon("sam.png").getImage();

    }

    public void paint(Graphics g) {                         // code for credits

        g.setFont(f);                               // this is the header of the page
        g.setColor(Color.white);
        g.drawString("Credits", 325, 42);
        g.drawString("_______", 325, 42);

        g.setFont(b);                               // simple statement to be printed
        g.drawString("This game was brought to you in part by the Beta group", 100, 68);
        g.drawString("For CS 4310, Software Engeneering 1", 100, 88);
        g.drawString("In association with CSUEB, by the talented minds of: ", 100, 108);

        g.drawString("Jonathan George", 250, 130);          // names of creators, placed here due to 
        g.drawImage(sam, 150, 130, null);                   // specific font style
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

    }
//***** rememebr to comment this section out when testing******
    public static void main(String[] args) {    // code for frame structure

        JFrame frame = new JFrame("Beta Group");
        frame.getContentPane().add(new Credits());
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.black);                   // for background
        frame.setForeground(Color.white);

    }
}