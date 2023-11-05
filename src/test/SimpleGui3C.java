package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C {
    private JFrame frame;
    private JLabel label;
    private int counter;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public SimpleGui3C(){
        counter = 0;
    }
    private void go (){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JButton button = new JButton("Color");
        JButton labelButton = new JButton("Label");
        label = new JLabel("Label");

        button.addActionListener(new ColorListener());
        labelButton.addActionListener(new LabelListener());

        MyPanel panel = new MyPanel();

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setVisible(true);
    }

    private class ColorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

    private class LabelListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            label.setText("Clicked" + counter);
        }
    }
}

class MyPanel extends JPanel{
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int red = (int)(Math.random()*255);
        int green = (int)(Math.random()*255);
        int blue = (int)(Math.random()*255);
        g.setColor(new Color(red, green ,blue));
        g.fill3DRect(this.getWidth()/4, this.getHeight()/4, this.getWidth()/2, this.getHeight()/2, true);
    }
}