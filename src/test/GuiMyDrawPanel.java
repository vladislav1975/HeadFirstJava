package test;

import javax.swing.*;
import java.awt.*;

public class GuiMyDrawPanel {
    JFrame frame;
    MyDrawPanel myPanel;

    public static void main(String[] args) {
        GuiMyDrawPanel gui = new GuiMyDrawPanel();
    }

    public GuiMyDrawPanel() {
        frame = new JFrame("MyPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        myPanel = new MyDrawPanel();
        frame.getContentPane().add(myPanel);
        frame.setVisible(true);
    }

    static class MyDrawPanel extends JPanel {
        public void paintComponent (Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            Color startColor = new Color(red, green, blue);

            red = (int)(Math.random() * 255);
            green = (int)(Math.random() * 255);
            blue = (int)(Math.random() * 255);
            Color endColor = new Color(red, green, blue);

            GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
            g2d.setPaint(gradient);
            g2d.fillOval(70, 70, 100, 100);
        }
    }
}
