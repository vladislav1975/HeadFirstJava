package DotComGame;

import java.util.Objects;
import java.util.Scanner;

public class GameHelper {

    public String getUserInput() {
        String inputLine = null;
        Scanner console = new Scanner(System.in);
        System.out.print("Your turn: ");
        while (true){
            if (console.hasNextLine()) inputLine = console.nextLine().toLowerCase();
            if(Objects.requireNonNull(inputLine).length() == 2){
                byte row = (byte) Character.getNumericValue(inputLine.charAt(0));
                byte column = (byte) Character.getNumericValue(inputLine.charAt(1));
                if ((row > 9 && row < 20) && (column >= 0 && column < 10)) return inputLine;
            }
            System.out.println("Invalid input, try another");
        }
    }
    public String getUserInput(DotComBust game) {
        String inputLine = null;
        boolean isReady = game.gameGui.isInputReady;
        while (true){
            game.gameGui.revalidate();
            if (game.gameGui.isInputReady) {
                inputLine = game.gameGui.turnTextField.getText().toLowerCase();
                game.gameGui.isInputReady = false;
                game.gameGui.turnTextField.setText("");
                game.gameGui.lblStatus.setText(inputLine);
            }
            else continue;
            if(Objects.requireNonNull(inputLine).length() == 2){
                byte row = (byte) Character.getNumericValue(inputLine.charAt(0));
                byte column = (byte) Character.getNumericValue(inputLine.charAt(1));
                if ((row > 9 && row < 20) && (column >= 0 && column < 10)) return inputLine;
            }
            game.gameGui.lblStatus.setText("Invalid input, try another");
        }
    }
}
