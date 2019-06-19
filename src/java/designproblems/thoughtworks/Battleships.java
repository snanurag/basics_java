package designproblems.thoughtworks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Battleships {

    /**
     * To run this code give the input file name with relative or absolute path.
     * The output of the battle would be printed on console.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) System.err.println("Please give the file relative or absolute path.");
        Battleships b = new Battleships();
//        Data d = b.parseData("./designproblems/thoughtworks/input.txt");
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
        data.setRow(Util.getRowIndex(inputs[1]) + 1);
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
     *
     * @param rows        Total rows in grid
     * @param cols        Total columns in grid
     * @param battleShips Total ships in both grids
     * @param attacksOfP1 Attacks series of player 1
     * @param attacksOfP2 Attacks series of player 2
     * @return
     */
    public String launchBattle(int rows, int cols, List<String[]> battleShips, String[] attacksOfP1, String[] attacksOfP2) {
        Player p1 = new Player("Piece-1");
        Player p2 = new Player("Piece-2");
        p1.setOpposition(p2);
        p2.setOpposition(p1);

        Fleet fleet1 = p1.createFleet(rows, cols);
        Fleet fleet2 = p2.createFleet(rows,cols);

        for(String[] s:battleShips){
            Ship ship = new Ship(s[0], Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            int[] p1Start = Util.convertIntoRowCol(s[3]);
            int[] p2Start = Util.convertIntoRowCol(s[4]);

            fleet1.setShip(ship, p1Start[0],p1Start[1]);
            fleet2.setShip(ship, p2Start[0],p2Start[1]);
        }

        for(String s: attacksOfP1) p1.setMissles(s);
        for(String s: attacksOfP2) p2.setMissles(s);

        //Start battle.
        p1.fireMissile();
        return Util.outBuff.toString();
    }

}
