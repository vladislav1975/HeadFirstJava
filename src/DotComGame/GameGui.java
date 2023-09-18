package DotComGame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GameGui extends JFrame{
    private JPanel mainPanel;
    private JTable jtBoard;

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
            row[0] = game.ab.charAt(i) + " (" + i + ") ";
            for (int j = 0 ; j < game.getBOARD_SIZE();  j++) {
                String strCell = game.cellToString(i, j);
                for (DotCom ship: game.ships) {
                    if (ship.getLocationCells().contains(strCell)) row[j+1] = "X";
                    else row[j+1] = ".";
                }
                //System.out.println(strCell);
                //row[j+1] = "X";
            }
            tm.addRow(row);
        }
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)jtBoard.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jtBoard.setModel(tm);
        jtBoard.setPreferredScrollableViewportSize(new Dimension(200,200));
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        GameGui gameGui = new GameGui(game);
    }
}
