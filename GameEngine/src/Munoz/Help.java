package Munoz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Help extends Panel 
{
    private BufferedImage s;
    private BufferedImage a;
    private BufferedImage d;
    private BufferedImage w;
    private BufferedImage sb;
    Image lifeb;
    private BufferedImage timer;
    private BufferedImage hank;
    int imgX;
    int imgY;
    int img;
    int txtX;
    int txtY;
    Font f;
    Font b;
    Font c;
    Font e;
    
    public Help() 
    {
        imgX = 50;
        imgY = 130;
        img = 32;
        txtX = 90;
        txtY = 150;
        f = new Font("Dialog", Font.ITALIC, 50);
        b = new Font("Dialog", Font.PLAIN, 18);
        c = new Font("Dialog", Font.PLAIN, 20);
        e = new Font("Dialog", Font.BOLD, 20);
        lifeb = Toolkit.getDefaultToolkit().createImage("/MunozImages/lifeBar.gif");
        try {
            s = ImageIO.read(getClass().getResourceAsStream("/MunozImages/S.png"));
            a = ImageIO.read(getClass().getResourceAsStream("/MunozImages/A.png"));
            d = ImageIO.read(getClass().getResourceAsStream("/MunozImages/D.png"));
            w = ImageIO.read(getClass().getResourceAsStream("/MunozImages/W.png"));
            sb = ImageIO.read(getClass().getResourceAsStream("/MunozImages/space.png"));
            lifeb = ImageIO.read(getClass().getResourceAsStream("/MunozImages/lifeBar.gif"));
            timer = ImageIO.read(getClass().getResourceAsStream("/MunozImages/timesequence.gif"));
            hank = ImageIO.read(getClass().getResourceAsStream("/MunozImages/HankStalica.gif"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics p) 
    {                   // class to draw onto the JFrame
        p.setFont(f);
        p.setColor(Color.white);
        p.drawString("Help", 325, 45);
        p.drawString("____", 325, 45);
        p.setFont(b);
        p.drawString("Welcome to the Help page, where everything you need to know on how to play", 10, 70);
        p.drawString("the Beta Game.", 10, 87);
        p.drawString("Here are a list of the assets you will need to know during Game mode: ", 10, 104);
        
        p.drawString("Keys to move:", 10, 125);
        p.drawString("_____________", 10, 125);
        p.drawString("Game Mode Asset: ", 10, txtY +230);
        p.drawString("_________________", 10, txtY +230);
        
        p.setFont(c);
        p.drawString(": Key board 'A' will move the player to the left of the screen", txtX, txtY);
        p.drawString(": Key board 'S' will move the player downward wihitn the screen", txtX, txtY + 50);
        p.drawString(": Key board 'D' will move the player to the right of the screen", txtX, txtY + 100);
        p.drawString(": Key board 'w' will move the player to the right of the screen", txtX, txtY + 150);
        p.drawString(": spacebar when pressed will enable the player to shoot a bullet", txtX, txtY + 200);
        p.drawString(": shows the current life status of the player", txtX, imgY + 272);
        p.drawString(": shows the current time remaining in game mode", txtX, imgY + 315);
        p.drawString(": The Brave young Player, here to conquor the evils of cheating!!", txtX, imgY + 375);

        p.setColor(Color.gray);         //for the next button
        p.fillRect(325, 700, 80, 40);
        p.setColor(Color.BLACK);
        p.setFont(e);
        p.drawString("Next",340,725);
        //images
        p.drawImage(a, imgX, imgY, img, img, null);
        p.drawImage(s, imgX, imgY + 50, img, img, null);
        p.drawImage(d, imgX, imgY + 100,img, img, null);
        p.drawImage(w, imgX, imgY + 150, img, img, null);
        p.drawImage(sb, imgX - 15, imgY + 200, img + 18, 25, null);
        p.drawImage(lifeb, imgX - 35, imgY + 245, 70 , 60, null);
        p.drawImage(timer, imgX - 35, imgY + 280, 70, 60, null);
        p.drawImage(hank, imgX - 50, imgY + 310 , 120, 120, null);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Help page");
        frame.getContentPane().add(new Help());
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.black);
        frame.setForeground(Color.WHITE);
    }
}