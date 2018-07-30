
package Munoz;

import Munoz.Help;
import Munoz.Help;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Enemy extends Panel 
{
    int txtD = 100;
    int txtT ;

    Font f;           // for the title Credits
    Font b;           // body text
    Font a;           // for text, that list the ceators contribution
    Font e;
    
    private BufferedImage lobo1;
    private BufferedImage SB;
//    private BufferedImage ;
//    private BufferedImage ;
//    private BufferedImage ;
    public Enemy() {
        f = new Font("Dialog", Font.ITALIC, 50);
        b = new Font("Dialog", Font.BOLD, 20);
        a = new Font("Dialog", Font.CENTER_BASELINE, 12);
        e = new Font("Dialog", Font.BOLD, 20);
        try {
            lobo1 = ImageIO.read(getClass().getResourceAsStream("/MunozImages/wolfpix.png"));
            SB = ImageIO.read(getClass().getResourceAsStream("/MunozImages/spongeBob.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
        g.setFont(f);
        g.setColor(Color.white);
        g.drawString("Help", 325, 42);
        g.drawString("____", 325, 42);
        g.setFont(b);
        g.drawString("Enemys:", 10, 125);
        g.drawString("________", 10, 125);
        g.drawString("Lobo: ",90, 160);
        g.drawString("BobSponge", 90, 260);
        
        g.setFont(a);
        g.drawString("The young lone wolf, raised in the salvage wilderness, it hungers for the blood of the", 100, 175);
        g.drawString("chosen player. His red moon eyes may look breath taking" ,100 ,188);
        g.drawString("But hes only looking to take your breath away!!", 100, 200);
        
        g.drawString("He might havee served you at the Krusty Krab, but this patty flipper ", 100, 275);
        g.drawString("is here to flip the player", 100, 288);
        
        g.drawImage(lobo1, 10, 135, 70, 70, null);
        g.drawImage(SB, 10, 235, 70,70, null);

        
        g.setColor(Color.gray);         //for the back button
        g.fillRect(325, 700, 80, 40);
        g.setColor(Color.BLACK);
        g.setFont(e);
        g.drawString("Back",340,725);
    }  
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Help page");
//        frame.getContentPane().add(new Enemy());
//        frame.setSize(800, 800);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//        frame.setBackground(Color.black);
//        frame.setForeground(Color.WHITE);
//    }
}
