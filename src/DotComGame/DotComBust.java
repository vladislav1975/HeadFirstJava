package DotComGame;

import java.util.ArrayList;
import java.util.Random;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private int numOfGuesses;
    private GameGui gameGui;

    public DotComBust() {
        setUpGame();
    }

    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    private final int BOARD_SIZE = 7;
    final String ab = "abcdefghij";
    private final int[] shipList = {2};
    final ArrayList<DotCom> ships = new ArrayList<>();
    private final Random rnd = new Random();

    String cellToString(int y, int x){
        return ab.charAt(y) + Integer.toString(x);
    }
    private int[] stringToCell(String loc){
        int y = ab.indexOf(loc.charAt(0));
        int x = Character.getNumericValue(loc.charAt(1));
        return new int[]{y, x};
    }

    private ArrayList<String> randLoc(int shipSize){
        ArrayList <String> loc = new ArrayList<>(); //Try location
        boolean horizontal = rnd.nextBoolean();
        int [][] cells = new int[shipSize][2]; //Coordinates array
        // First point
        if (horizontal) {
            cells[0][0] = rnd.nextInt(BOARD_SIZE - shipSize - 1) + 1;
            cells[0][1] = rnd.nextInt(BOARD_SIZE - 2) + 1;
        } else {
            cells[0][0] = rnd.nextInt(BOARD_SIZE - 2) + 1;
            cells[0][1] = rnd.nextInt(BOARD_SIZE - shipSize - 1) + 1;
        }
        // All points set
        for (int i = 0; i < shipSize; i++) {
            if (horizontal) {
                cells[i][0] = cells[0][0] + i;
                cells[i][1] = cells[0][1];
            } else {
                cells[i][0] = cells[0][0];
                cells[i][1] = cells[0][1] + i;
            }
        }
        //Set location string array
        for (int i = 0; i < shipSize; i++) {
            loc.add(cellToString(cells[i][1], cells[i][0]));
        }
        return loc;
    }
    private boolean isFreePlace(ArrayList<String> loc){
        int shipSize = loc.size();
        int[][] ship = new int[shipSize][2];
        //convert string location to digit coordinates
        for (int i = 0; i < ship.length; i++) {
            ship[i] = stringToCell(loc.get(i));
        }
        boolean isHorizontal = ship[0][1] != ship[shipSize - 1][1]; //direction of ship
        int[] p0 = new int[]{ship[0][0]-1, ship[0][1]-1}; // first point of big place

        // setting big place
        ArrayList<String> bigLoc = new ArrayList<>();
        int x,y;
        if (isHorizontal){
            for (int i = 0; i < 3; i++) {
                y = p0[0] + i;
                for (int j = 0; j < shipSize + 2; j++) {
                    x = p0[1] + j;
                    bigLoc.add(cellToString(y, x));
                }
            }
        } else {
            for (int i = 0; i < shipSize + 2; i++) {
                y = p0[0] + i;
                for (int j = 0; j < 3; j++) {
                    x = p0[1] + j;
                    bigLoc.add(cellToString(y, x));
                }
            }
        }
        // check if place for ship is free
        boolean isFree = true;
        for (String dot:bigLoc) {
            for (DotCom sh: ships) {
                if (sh.getLocationCells().contains(dot)) {
                    isFree = false;
                    break;
                }
            }
            if (!isFree) break;
        }
        return isFree;
    }
    private boolean initShips() {
        boolean result = true;
        for (int j : shipList) {
            boolean placed = false;
            int count = 0;
            while (!placed) {
                ArrayList<String> newLoc = randLoc(j);
                if (isFreePlace(newLoc)) {
                    DotCom ship = new DotCom();
                    ship.setLocationCells(newLoc);
                    ships.add(ship);
                    placed = true;
                } else if (++count > 10000) {
                    result = false;
                    break;
                }
            }
            if (!result) break;
        }
        return result;
    }
    private void printBoard(){
        System.out.println("       0  1  2  3  4  5  6  7  8  9");
        int i = 0;
        while (i < BOARD_SIZE) {
            System.out.print(ab.charAt(i)+" " + "(" + i + ") ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                String coordinates = ab.charAt(i)+Integer.toString(j);
                boolean isShip = false;
                for (DotCom ship:ships) {
                    if (ship.getLocationCells().contains(coordinates)) {
                        isShip = true;
                        break;
                    }
                }
                if (isShip) System.out.print("█".repeat(3));
                else System.out.print(" " + "·" + " ");
            }
            System.out.println();
            i++;
        }
    }

    private void  setUpGame(){
        // Create ships
        boolean isPlaced = false;
        while (!isPlaced){
            ships.clear();
            isPlaced = initShips();
        }
        this.gameGui = new GameGui(this);
        printBoard();
    }

    private void startPlaying(){
        while (!ships.isEmpty()){
            String userGuess = helper.getUserInput("Your turn: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Fail";
        for (DotCom dotComToTest: ships) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Hit")) break;
            if (result.equals("Destroyed")) {
                ships.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
        boardRefresh(userGuess, result);
    }

    private void boardRefresh(String userGuess, String result) {
        // get cell value
        int row = stringToCell(userGuess)[0];
        int column = stringToCell(userGuess)[1]+1;
        String value = String.valueOf(gameGui.jtBoard.getModel().getValueAt(row, column));
        //new value
        if (result.equals("Fail") && value == "null") value = ".";
        else if (!result.equals("Fail")) value = "X";
        //set value
        gameGui.jtBoard.getModel().setValueAt(value, row, column);
    }

    private void finishGame(){
        System.out.println("Game Over!\nGuesses:" + numOfGuesses);
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        //game.setUpGame();
        game.startPlaying();
    }
}
