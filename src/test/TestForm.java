package test;

import javax.swing.*;
import java.awt.event.*;

public class TestForm {
    private JButton button1;
    private JPanel panel1;

    public TestForm() {
        panel1.setSize(200, 200);
        button1.addMouseListener(new ml());
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setText("Clicked!");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestForm");
        TestForm gui = new TestForm();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        //frame.pack();
        frame.addWindowListener(new wl());
        frame.setVisible(true);
    }

}
 class ml extends MouseAdapter{
     @Override
     public void mouseClicked(MouseEvent e) {
         super.mouseClicked(e);
         System.out.println(e);
     }
 }
 class wl implements WindowListener{

     @Override
     public void windowOpened(WindowEvent e) {
         System.out.println("Opened!");
     }

     @Override
     public void windowClosing(WindowEvent e) {

     }

     @Override
     public void windowClosed(WindowEvent e) {

     }

     @Override
     public void windowIconified(WindowEvent e) {

     }

     @Override
     public void windowDeiconified(WindowEvent e) {

     }

     @Override
     public void windowActivated(WindowEvent e) {

     }

     @Override
     public void windowDeactivated(WindowEvent e) {

     }
 }