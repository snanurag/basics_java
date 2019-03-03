package designproblems.thoughtworks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Battleships {

    /**
     * To run this code give the input file name with relative of absolute path.
     * The output of the battle would be printed on console.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) System.err.println("Please give the file relative or absolute path.");
        Battleships b = new Battleships();
//        Data d = b.parseData("./src/designproblems/thoughtworks/input.txt");
        Data d = b.parseData(args[0]);
        System.out.println(b.launchBattle(d.getRow(), d.getCols(), d.getBattleShips(), d.getAttacksOfP1(), d.getAttacksOfP2()).toString());

    }

    private Data parseData(String filepath) throws IOException {
        File file = new File(filepath);
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);
        Data data = new Data();
        String[] inputs = bfr.readLine().split(" ");
        data.setCols(Integer.parseInt(inputs[0]));
        data.setRow(Util.getRowIndex(inputs[1])+1);
        int totalShips = Integer.parseInt(bfr.readLine());

        List<String[]> battleShips = new LinkedList<>();

        for (int i = 0; i < totalShips; i++) battleShips.add(bfr.readLine().split(" "));
        data.setBattleShips(battleShips);

        data.setAttacksOfP1(bfr.readLine().split(" "));
        data.setAttacksOfP2(bfr.readLine().split(" "));

        return data;
    }

    /**
     * This is the function which starts the battle.
     * @param rows Total rows in grid
     * @param cols Total columns in grid
     * @param battleShips Total ships in both grids
     * @param attacksOfP1 Attacks series of player 1
     * @param attacksOfP2 Attacks series of player 2
     * @return
     */
    public String launchBattle(int rows, int cols, List<String[]> battleShips, String[] attacksOfP1, String[] attacksOfP2) {
        int fleetStrength = getFleetStrength(battleShips);
        int[][] gridOfP1 = new int[rows][cols];
        int[][] gridOfP2 = new int[rows][cols];

        placeShipsOnGrids(battleShips, gridOfP1, gridOfP2);
        return playMatch(fleetStrength, gridOfP1, gridOfP2, attacksOfP1, attacksOfP2).toString();
    }

    /**
     * This function calculates the fleet strength (minimum missiles required to destroy fleet).
     *
     * @param battleShips List of battleships in every grid.
     * @return
     */
    public int getFleetStrength(List<String[]> battleShips) {
        int totalStrength = 0;
        for (String[] battleShip : battleShips) {
            int shipStrength = battleShip[0].equals("Q") ? 2 : 1;
            totalStrength += shipStrength * Integer.parseInt(battleShip[1]) * Integer.parseInt(battleShip[2]);
        }
        return totalStrength;
    }

    /**
     * Play the actual match between two players.
     *
     * @param fleetStrength Total missles required to destroy the fleet.
     * @param gridP1        Player1 grid
     * @param gridP2        Player2 grid
     * @param attacksOfP1   Attacks of player 1
     * @param attacksOfP2   Attacks of player 2
     * @return StringBuffer outcome of the match.
     */
    private StringBuffer playMatch(int fleetStrength, int[][] gridP1, int[][] gridP2, String[] attacksOfP1, String[] attacksOfP2) {
        int fleetStrengthOfP1 = fleetStrength;
        int fleetStrengthOfP2 = fleetStrength;
        StringBuffer stringBuffer = new StringBuffer();

        Iterator<String> attacksP1Itr = Arrays.asList(attacksOfP1).iterator();
        Iterator<String> attacksP2Itr = Arrays.asList(attacksOfP2).iterator();

        Iterator<String> attacker = attacksP1Itr;
        int[][] attackedGrid = gridP2;

        while (attacksP1Itr.hasNext() || attacksP2Itr.hasNext()) {
            if (attacker.hasNext()) {
                String location = attacker.next();
                int[] hitLocation = Util.convertIntoRowCol(location);
                if (attackedGrid[hitLocation[0]][hitLocation[1]] > 0) {
                    attackedGrid[hitLocation[0]][hitLocation[1]]--;
                    if (attackedGrid == gridP2) {
                        fleetStrengthOfP2--;
                        stringBuffer.append(String.format(Constants.FIRE, "Player-1", location, "hit"));
                        if (fleetStrengthOfP2 == 0) {
                            stringBuffer.append(String.format(Constants.WIN, "Player-1"));
                            return stringBuffer;
                        }
                    } else {
                        fleetStrengthOfP1--;
                        stringBuffer.append(String.format(Constants.FIRE, "Player-2", location, "hit"));
                        if (fleetStrengthOfP1 == 0) {
                            stringBuffer.append(String.format(Constants.WIN, "Player-2"));
                            return stringBuffer;
                        }
                    }
                    continue;
                } else {
                    if (attackedGrid == gridP2)
                        stringBuffer.append(String.format(Constants.FIRE, "Player-1", location, "miss"));
                    else stringBuffer.append(String.format(Constants.FIRE, "Player-2", location, "miss"));
                }
            } else {
                if (attackedGrid == gridP2)
                    stringBuffer.append(String.format(Constants.EMPTY, "Player-1"));
                else stringBuffer.append(String.format(Constants.EMPTY, "Player-2"));
            }
            attackedGrid = attackedGrid == gridP1 ? gridP2 : gridP1;
            attacker = attacker == attacksP1Itr ? attacksP2Itr : attacksP1Itr;
        }

        stringBuffer.append(Constants.DRAW);
        return stringBuffer;
    }

    /**
     * Create the battle grids for both the players.
     *
     * @param battleShips List contains ships which their timensions.
     * @param gridOfP1    Player1 grid
     * @param gridOfP2    Player2 grid
     */
    private void placeShipsOnGrids(List<String[]> battleShips, int[][] gridOfP1, int[][] gridOfP2) {
        for (String[] battleShip : battleShips) {
            int shipStrength = battleShip[0].equals("Q") ? 2 : 1;
            int w = Integer.parseInt(battleShip[1]);
            int h = Integer.parseInt(battleShip[2]);

            placeShipOnGrid(shipStrength, gridOfP1, w, h, Util.convertIntoRowCol(battleShip[3]));
            placeShipOnGrid(shipStrength, gridOfP2, w, h, Util.convertIntoRowCol(battleShip[4]));

        }
    }

    private void placeShipOnGrid(int shipStrength, int[][] grid, int col, int row, int[] startPoint) {
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                grid[startPoint[0] + r][startPoint[1] + c] = shipStrength;
    }

}
