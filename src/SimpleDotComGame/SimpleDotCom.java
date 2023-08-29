package SimpleDotComGame;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public  String checkYourself (String stringGuess){
        int guess = Integer.parseInt(stringGuess);
        String result = "fail";
        for (int cell: locationCells){
            if(guess==cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits==locationCells.length) result = "destroyed";
        System.out.println(result);
        return result;
    }
}
