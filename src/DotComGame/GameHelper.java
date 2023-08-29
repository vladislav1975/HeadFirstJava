package DotComGame;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {

    public String getUserInput(String prompt){
        String inputLine = null;
        Scanner console = new Scanner(System.in);
        System.out.print(prompt);
        if (console.hasNextLine()) {
            inputLine = console.nextLine();
        }
        return inputLine;
    }

//    public ArrayList<String> placeDotCom (int comSize){
//
//
//    }
}
