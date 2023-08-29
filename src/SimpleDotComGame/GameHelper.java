package SimpleDotComGame;

import java.util.Scanner;

public class GameHelper {
    public static String getUserInput(String prompt){
        String inputLine = null;
        Scanner console = new Scanner(System.in);
        System.out.print(prompt+": ");
        if (console.hasNextLine()) {
            inputLine = console.nextLine();
        }
        return inputLine;
    }
}
