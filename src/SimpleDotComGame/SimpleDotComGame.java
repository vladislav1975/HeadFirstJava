package SimpleDotComGame;

import java.util.Arrays;

public class SimpleDotComGame {
    public static void main(String[] args) {
        SimpleDotCom dotCom = new SimpleDotCom();
        int[] locations = new int[3];
        int numOfGuesses = 0;
        locations[0] = (int)(Math.random()*5);
        locations[1] = locations[0]+1;
        locations[2] = locations[0]+2;
        System.out.println(Arrays.toString(locations));
        dotCom.setLocationCells(locations);
        boolean isAlive = true;
        String result;
        while(isAlive) {
            String turn = GameHelper.getUserInput("Your turn");
            numOfGuesses++;
            result = dotCom.checkYourself(turn);
            if (result.equals("destroyed")) isAlive=false;
        }
        System.out.println("Number of Guesses: " + numOfGuesses);
    }
}
