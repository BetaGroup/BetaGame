package Munoz;

import java.awt.Color;
import java.awt.Font;                               // Header for fonts
import java.awt.Graphics;                           // for the paint function
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Credits extends Panel {
// attributes

    Font f;           // for the title Credits
    Font b;           // body text
    Font a;           // for text, that list the ceators contribution

    private BufferedImage sam;
    private BufferedImage Jonathan;
    private BufferedImage Gordan;
    private BufferedImage Pravita;
    private BufferedImage Joel;

    int setx = 300;                 // x location for creators names to be straight
    int setyJ = 180;                // starting point for johnathan text
    int setyS = 270;                // starting point for sam text
    int setyP = 360;                // starting point for Pravita text
    int setyG = 450;                // starting point for Gordan text
    int setyJO = 540;               // starting point for Joel text
    int setImgx = 210;              // x location for images
    int setImgy = 160;              // y location for images
    int sizeimg = 70;               // for image width and height

    public Credits() {
        f = new Font("Dialog", Font.ITALIC, 50);
        b = new Font("Dialog", Font.BOLD, 20);
        a = new Font("Dialog", Font.CENTER_BASELINE, 12);

        try {
            sam = ImageIO.read(getClass().getResourceAsStream("/MunozImages/Sam.png"));
            Jonathan = ImageIO.read(getClass().getResourceAsStream("/MunozImages/Johanthan.png"));
            Gordan = ImageIO.read(getClass().getResourceAsStream("/MunozImages/Gordan.png"));
            Pravita = ImageIO.read(getClass().getResourceAsStream("/MunozImages/Pravita.png"));
            Joel = ImageIO.read(getClass().getResourceAsStream("/MunozImages/joel.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void paint(Graphics g) {                         // code for credits

        g.setFont(f);                               // this is the header of the page
        g.setColor(Color.white);
        g.drawString("Credits", 325, 42);
        g.drawString("_______", 325, 42);

        g.setFont(b);                               // specific font style
        g.drawString("This game was brought to you in part by the Beta group", 100, 88);
        g.drawString("For CS 4310, Software Engeneering 1", 100, 108);
        g.drawString("In association with CSUEB, by the talented minds of: ", 100, 128);
        g.drawString("Jonathan George", setx, setyJ);          // names of creators, placed here due to 
        g.drawString("Sam Ruiz", setx, setyS);
        g.drawString("Pravita Kafley", setx, setyP);
        g.drawString("Gordan Man", setx, setyG);
        g.drawString("Joel Muñoz", setx, setyJO);
        g.setFont(a);                       // writing under creators names, specific font for this section
        // Johnathan contribution
        g.drawString("- Manager", setx, setyJ + 15);                           // Johnathan contribution
        g.drawString("- Enemy creature ---", setx, setyJ + 30);
        g.drawString("- SDD Document", setx, setyJ + 45);
        // Sam contribution
        g.drawString("- Enemy creature Kulkuma, Guajataka", setx, setyS + 15);
        g.drawString("- Widget: Timer, Life bar", setx, setyS + 30);
        g.drawString("- SDD Document", setx, setyS + 45);
        // Pravita contribution
        g.drawString("- ScoreBoard", setx, setyP + 15);
        g.drawString("- Enemy creature ---", setx, setyP + 30);
        g.drawString("- SDD Document", setx, setyP + 45);
        // Gordan contribution
        g.drawString("- Menu", setx, setyG + 15);
        g.drawString("- Enemy creature ---", setx, setyG + 30);
        g.drawString("- SDD Document", setx, setyG + 45);
        // Joel contribution
        g.drawString("- Credits", setx, setyJO + 15);
        g.drawString("- Help", setx, setyJO + 30);
        g.drawString("- Enemy creature ---", setx, setyJO + 45);
        g.drawString("- SDD Document", setx, setyJO + 60);
        // images section
        g.drawImage(Jonathan, setImgx, setImgy, sizeimg, sizeimg, null);
        g.drawImage(sam, setImgx, setImgy + 90, sizeimg, sizeimg, null);
        g.drawImage(Pravita, setImgx, setImgy + 180, sizeimg, sizeimg, null);
        g.drawImage(Gordan, setImgx, setImgy + 270, sizeimg, sizeimg, null);
        g.drawImage(Joel, setImgx, setImgy + 360, sizeimg, sizeimg, null);
    }
//***** rememebr to comment this section out when testing******

    public static void main(String[] args) {    // code for frame structure

        JFrame frame = new JFrame("Beta Group");
        frame.getContentPane().add(new Credits());
        frame.setSize(800, 800);
        frame.setVisible(true);
        JLabel sam = new JLabel(new ImageIcon("sam.png"));
        sam.setBounds(10, 10, 32, 32);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.black);                   // for background
        frame.setForeground(Color.white);

    }
}
