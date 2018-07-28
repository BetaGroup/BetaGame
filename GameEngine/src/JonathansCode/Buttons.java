/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JonathansCode;

    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.FontMetrics;
    import java.awt.Graphics;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseListener;

    import javax.swing.JButton;

    /**
     *
     * @author KnightLife
     */
public class Buttons extends JButton implements MouseListener{
    
    
 
    /*
     * Welcome to the World of Tomrrow!
     * Jul 2, 2018 
     */
 
    

        Dimension size = new Dimension(250, 150);
        boolean hover = false;
        boolean click = false;
        String text = "";
        int fontSize = 0;

        public Buttons(String text, int fontSize) {

            setVisible(true);
            setFocusable(true);
            setContentAreaFilled(false);
            setBorderPainted(false);

            this.text = text;
            this.fontSize = fontSize;
            addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //Color for the border
            g.setColor(Color.WHITE);

            if (hover) {
                g.setColor(Color.RED);
            }
            //draw the border
            g.fillRect(0, 0, 250, 7);
            g.fillRect(0, 130, 250, 7);
            g.fillRect(0, 0, 7, 130);
            g.fillRect(243, 0, 7, 130);

            //Color for the area inside the border
            g.setColor(Color.BLUE);

            if (hover) {
                g.setColor(Color.BLACK);
            }
            g.fillRect(7, 7, 237, 123);

            //Color for the String
            g.setColor(Color.WHITE);

            if (hover) {
                g.setColor(Color.RED);
            }

            Font myFont = new Font("times new roman", Font.BOLD, fontSize);
            g.setFont(myFont);

            FontMetrics metrics = g.getFontMetrics();
            int width = metrics.stringWidth(text);

            g.drawString(text, 125 - width / 2, 85);

            if (click) {

                //draw the inside
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, 235, 143);
                g.setColor(Color.RED);
                g.drawString(text, 125 - width / 2, 85);

                //draw the border
                g.setColor(Color.RED);
                g.drawRect(0, 0, 250, 7);
                g.drawRect(0, 130, 250, 7);
                g.drawRect(0, 0, 7, 130);
                g.drawRect(243, 0, 7, 130);
            
            }
            
            
        }

        @Override
        public Dimension getPreferredSize() {
            return size;
        }

        public void setButtonText(String text) {
            this.text = text;
        }

        public String getButtonText() {
            return text;
        }

        @Override
        public void mouseClicked(MouseEvent me) {

        }

        @Override
        public void mousePressed(MouseEvent me) {
            click = true;
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            click = false;
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            hover = true;
        }

        @Override
        public void mouseExited(MouseEvent me) {
            hover = false;
        }

    }


    
    

