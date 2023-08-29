package DotComGame;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    //private String name;

    public void setLocationCells(ArrayList<String> loc) {
        this.locationCells = loc;
    }
    public ArrayList<String> getLocationCells() {
        return locationCells;
    }
/*
    public void setName(String name) {
        this.name = name;
    }
*/

    public  String checkYourself (String userInput){
        String result = "Fail";

        int index = locationCells.indexOf(userInput);
        if (index >= 0){
            locationCells.remove(index);
            if(locationCells.isEmpty())
                result = "Destroyed";
            else
                result = "Hit";
        }
        return result;
    }
}