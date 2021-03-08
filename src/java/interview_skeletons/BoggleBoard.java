package interview_skeletons;

/**
 * Feb 2019
 *
 * Solve the Boggle Board problem
 * <p>
 * Target of this code is that the player should win as the following scoring rules.
 * So his selection of words on the boggle board should make the maximum score possible on the particular cubes arrangement.
 * <p>
 * Scoring and Winning
 * <p>
 * No. of Letters | Points per Word
 * 3       |        1
 * 4       |        1
 * 5       |        2
 * 6       |        3
 * 7       |        5
 * 8+    |        11
 * <p>
 * Following map contains word length vs points.
 */

import java.util.*;

public class BoggleBoard {


    public static void main(String[] args) {


        Set<String> dictionary = new HashSet<>();
        dictionary.add("age");
        dictionary.add("agent");
        dictionary.add("energy");
        dictionary.add("synergy");

        Map<Integer, Integer> scoringMap = new HashMap();

        //Scoring on length.
        scoringMap.put(0, 0);
        scoringMap.put(1, 0);
        scoringMap.put(2, 0);
        scoringMap.put(3, 1);
        scoringMap.put(4, 1);
        scoringMap.put(5, 2);
        scoringMap.put(6, 3);
        scoringMap.put(7, 5);
        scoringMap.put(8, 11);

        String[][] boggleGrid = new String[4][4];
        /**
         * a g e n
         * s y n t
         *     e y
         *     r g
         */
        boggleGrid[0][0] = "a";
        boggleGrid[0][1] = "g";
        boggleGrid[0][2] = "e";
        boggleGrid[0][3] = "n";
        boggleGrid[1][0] = "s";
        boggleGrid[1][1] = "y";
        boggleGrid[1][3] = "t";
        boggleGrid[1][2] = "n";
        boggleGrid[2][2] = "e";
        boggleGrid[3][2] = "r";
        boggleGrid[3][3] = "g";
        boggleGrid[2][3] = "y";


        /**
         * Output:
         * agent
         * synergy
         * 7
         */
        printWordsAndScore(boggleGrid, dictionary, scoringMap);
    }

    private static void printWordsAndScore(String[][] boggleBoard, Set<String> dictionary, Map<Integer, Integer> scoringMap){

    }
}