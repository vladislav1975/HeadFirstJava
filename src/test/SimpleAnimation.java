package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAnimation {
    JFrame frame;
    JButton button;
    MyPanel panel;
    int x,y;
    Timer timer;
    byte step = 5;


    public void go(){
        x=y=0;
        button = new JButton("Start");
        panel = new MyPanel();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        frame = new JFrame("Simple Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(260, 310);
        frame.setVisible(true);

        timer = new Timer(100, new TimerListener());
    }

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    class MyPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.orange);
            g.fillOval(x,y, 50, 50);
        }
    }

    class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            x = x + step;
            y = y + step;
            panel.repaint();
            if (x > 200 || y > 200) timer.stop();
        }
    }
}
