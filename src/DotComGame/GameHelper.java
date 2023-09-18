package DotComGame;

import java.util.Objects;
import java.util.Scanner;

public class GameHelper {

    public String getUserInput(String prompt) {
        String inputLine = null;
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
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
}
