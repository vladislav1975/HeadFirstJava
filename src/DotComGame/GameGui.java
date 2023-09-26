package DotComGame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameGui extends JFrame{
    private JPanel mainPanel;
    private JButton exitGameButton;
    JList lstGuesses;
    DefaultListModel lm;
    JTextField turnTextField;
    private JButton okButton;
    JTable jtBoard;
    JLabel lblStatus;
    private JFrame jFrame;
    boolean isInputReady = false;

    public GameGui(DotComBust game){
        DefaultTableModel tm = new DefaultTableModel();
        //set headers
        for (int i = 0; i <= game.getBOARD_SIZE(); i++) {
            if (i > 0) tm.addColumn(i-1);
            else tm.addColumn("");
        }
        //set rows
        for (int i = 0; i < game.getBOARD_SIZE(); i++) {
            String[] row = new String[game.getBOARD_SIZE()+1];
            row[0] = game.ab.charAt(i)+"";
            tm.addRow(row);
        }
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)jtBoard.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtBoard.setRowHeight((jtBoard.getPreferredScrollableViewportSize().height - 19)/ game.getBOARD_SIZE());
        jtBoard.setModel(tm);
        jtBoard.setPreferredScrollableViewportSize(new Dimension(200,200));
        lm = new DefaultListModel();
        lstGuesses.setModel(lm);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Battle Ship");
        // Change the icon image
        ImageIcon img = new ImageIcon("/home/vlad/Pictures/battleship.png");
        setIconImage(img.getImage());
        pack();
        turnTextField.requestFocus();
        setVisible(true);
        jFrame = this;

        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(jFrame, "Exit Game?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (result == 0) System.exit(0);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInputReady = true;
                makeGuess();
            }
        });
        turnTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isInputReady = true;
                makeGuess();
            }
        });
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(jFrame, "Exit Game?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (result == 0) System.exit(0);
            }
        });
    }

    private void makeGuess() {
    }

}
