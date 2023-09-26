package DotComGame;

import javax.swing.*;
import java.awt.*;

public class ListTest extends JFrame{
    private JList list1;
    private JPanel panel1;
    DefaultListModel<String> lm;

    public ListTest() throws HeadlessException {
        lm = new DefaultListModel<>();
        list1.setModel(lm);
        setContentPane(panel1);
        setSize(new Dimension(300,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        for (int i = 0; i < 20; i ++) {
            lt.lm.add(0, i + " String");
        }
    }
}
