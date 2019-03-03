package designproblems.thoughtworks;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleshipsUnitTests {
    Battleships b = new Battleships();

    @Test
    public void testConvertIntoRowCol() {
        int[] expected = {3, 2};
        assertArrayEquals(expected, Util.convertIntoRowCol("D3"));
    }

    @Test
    public void testFleetStrength() {
        List<String[]> battleShips = new LinkedList<>();
        battleShips.add("Q 1 1 A1 B2".split(" "));
        battleShips.add("P 2 1 D4 C3".split(" "));
        assertEquals(4, b.getFleetStrength(battleShips));
    }

    @Test
    public void testLunchBattle() throws IOException {
        System.out.println(File.listRoots());
        File output = new File("./src/designproblems/thoughtworks/output.txt");
        System.out.println(output.getAbsolutePath());
        FileReader fr = new FileReader(output);
        char[] c = new char[100];
        StringBuffer stringBuffer = new StringBuffer();

        while (fr.read(c) != -1) {
            stringBuffer.append(c);
            c = new char[100];
        }

        fr.close();

        List<String[]> battleShips = new LinkedList<>();
        battleShips.add("Q 1 1 A1 B2".split(" "));
        battleShips.add("P 2 1 D4 C3".split(" "));
        String[] attacksP1 = "A1 B2 B2 B3".split(" ");
        String[] attacksP2 = "A1 B2 B3 A1 D1 E1 D4 D4 D5 D5".split(" ");
        assertEquals(stringBuffer.toString().trim(), b.launchBattle(5, 5, battleShips, attacksP1, attacksP2).trim());

    }

}
