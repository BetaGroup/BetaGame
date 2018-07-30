package FinalProduct;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GameWindow extends Canvas{
    int WIDTH = 800;
    int HEIGHT = 800;
    

    GameWindow(GameLooper aThis) { // some resaon the compiler wants me to name it aThis
        JFrame frame = new JFrame("Shooter game"); //title     
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // seting up new
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT)); // dimentions 
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit in frame
        frame.setResizable(false); // user cant resize
        frame.setLocationRelativeTo(null); // makes window start in middlewindow
        frame.add(aThis);
        frame.setVisible(true); //you can see the frame!
        aThis.start(); // runs the start method     
    }
}
