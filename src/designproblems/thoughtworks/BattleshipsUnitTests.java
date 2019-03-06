package designproblems.thoughtworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleshipsUnitTests {
    Battleships b = new Battleships();
    Player p;
    Fleet f;

    @BeforeEach
    public void createPlayer() {
        createPlayer("Player-1");
    }

    @BeforeEach
    public void resetConsole(){
        Util.outBuff = new StringBuffer();
    }

    private Player createPlayer(String name) {
        p = new Player(name);
        f = p.createFleet(5, 5);

        Ship ship = new Ship("Q", 1, 1);
        f.setShip(ship, 0, 0);
        ship = new Ship("P", 2, 1);
        f.setShip(ship, 3, 3);
        return p;
    }

    @Test
    public void testConvertIntoRowCol() {
        int[] expected = {3, 2};
        assertArrayEquals(expected, Util.convertIntoRowCol("D3"));
    }

    @Test
    public void testFleetStrength() {
        assertEquals(4, f.getStrength());
    }


    @Test
    public void testHit() {
        Missile m = new Missile("D4");
        assertEquals(true, f.hit(m));
        m = new Missile("D5");
        assertEquals(true, f.hit(m));
        m = new Missile("E5");
        assertEquals(false, f.hit(m));
        m = new Missile("D3");
        assertEquals(false, f.hit(m));
    }


    @Test
    public void testConsumeMissleFailed() {
        Missile m = new Missile("D4");
        try {
            p.consumeMissile(m);
        } catch (Exception e) {
            assertEquals("Player is not ready for the Battle", e.getMessage());

        }
    }

    @Test
    public void testConsumedMissileHit() {
        Missile m = new Missile("D4");
        Player p1 = p;
        p1.setOpposition(createPlayer("Player-2"));
        try {
            p1.consumeMissile(m);

        } catch (Exception e) {
            assertEquals("Player is not ready for the Battle", e.getMessage());
        }
        assertEquals("Player-2 fires a missile with target D4 which got hit", Util.outBuff.toString().trim());

    }

    @Test
    public void testConsumedMissileMiss() {
        Missile m = new Missile("E4");
        Player p1 = p;
        p1.setOpposition(createPlayer("Player-2"));
        try {
            p1.consumeMissile(m);

        } catch (Exception e) {
            assertEquals("Player is not ready for the Battle", e.getMessage());
        }
        assertEquals("Player-2 fires a missile with target E4 which got miss", Util.outBuff.toString().trim());

    }

    @Test
    public void testConsumedMissileNull() {
        Player p1 = p;
        p1.setMissles("A1");
        p1.setOpposition(createPlayer("Player-2"));
        try {
            p1.consumeMissile(null);

        } catch (Exception e) {
            assertEquals("Player is not ready for the Battle", e.getMessage());
        }
        assertEquals("Player-2 has no more missiles left to launch", Util.outBuff.toString().trim());

    }

    @Test
    public void testLunchBattle() throws IOException {
        File output = new File("./src/output.txt");
        FileReader fr = new FileReader(output);
        char[] c = new char[100];
        StringBuffer stringBuffer = new StringBuffer();

        while (fr.read(c) != -1) {
            stringBuffer.append(c);
            c = new char[100];
        }

        fr.close();

        Player p1 = p;
        Player p2 = createPlayer("Player-2");
        p1.setOpposition(p2);
        p2.setOpposition(p1);

        Arrays.asList("A1 B2 B2 B3".split(" ")).forEach(p1::setMissles);
        Arrays.asList("A1 B2 B2 B3".split(" ")).forEach(p2::setMissles);
        p1.fireMissile();
        assertEquals(stringBuffer.toString().trim(), Util.outBuff.toString().trim());

    }

}
