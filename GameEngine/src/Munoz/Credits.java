package Munoz;

import com.sun.javafx.tk.Toolkit;
import java.awt.Color;
import java.awt.Font;                               // Header for fonts
import java.awt.Graphics;                           // for the paint function
import java.awt.Image;
import java.awt.Panel;
import javax.swing.JFrame;

public class Credits extends Panel {

    Font f = new Font("Dialog", Font.ITALIC, 50);           // for the title Credits
    Font b = new Font("Dialog", Font.BOLD, 20);             // body text
    Font a = new Font("Dialog", Font.CENTER_BASELINE, 12);

    public Credits() {
        
        

    }

    public void paint(Graphics g) {                         // code for credits

        g.setFont(f);
        g.setColor(Color.white);
        g.drawString("Credits", 325, 45);

        g.setFont(b);
        g.drawString("This game was brought to you in part by the Beta group", 100, 65);
        g.drawString("For CS 4310, Software Engeneering 1", 100, 85);
        g.drawString("In association with CSUEB, by the talented minds of: ", 100, 105);

        g.drawString("Jonathan George", 250, 130);
        //g.drawImage(sam, 150, 130, this);
        g.drawString("Sam Ruiz", 250, 220);
        g.drawString("Pravita Kafley", 250, 310);
        g.drawString("Gordan Man", 250, 400);
        g.drawString("Joel Muñoz", 250, 490);

        g.setFont(a);                           // writing under creators names
        g.drawString("- Manager", 250, 145);            // Johnathan 
        g.drawString("- Enemy creature ---", 250, 160);       
        g.drawString("- Enemy creature Kulkuma, Guajataka", 250, 235); // Sam
        g.drawString("- Widget: Timer, Life bar", 250, 250);
        g.drawString("- ScoreBoard", 250, 325);         // Pravita
        g.drawString("- Enemy creature ---", 250, 340);
        g.drawString("- Menu", 250, 415);               // Gordan
        g.drawString("- Enemy creature ---", 250, 430);
        g.drawString("- Credits", 250, 505);            // Joel
        g.drawString("- Help", 250, 515);
        g.drawString("- Enemy creature ---", 250, 530);

    }

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
