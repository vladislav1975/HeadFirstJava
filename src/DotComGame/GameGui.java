package DotComGame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GameGui extends JFrame{
    private JPanel mainPanel;
    private JLabel caption;
    private JTable table1;
    private JLabel label1;
    private JScrollPane sp;
    private DotComBust game;

    public GameGui(DotComBust game){
        this.game = game;
        add(mainPanel);
        String[] headers = {"h1", "h2"};
        Integer[][] data = {{1,2}, {3, 4}};
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn(1);
        model.addColumn(2);
        model.addRow(data[0]);
        table1.setModel(model);

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        GameGui gameGui = new GameGui(game);
    }
}
