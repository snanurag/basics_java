package interviews.intellisys;

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

public class BoggleBoardThroughMultiThread {

    int finalscore = 0;
    List<String> finalList = new ArrayList<>();

    Map<Integer, Integer> scoringMap = new HashMap();

    public static void main(String[] args) {
        String[][] boggleGrid = new String[4][4];
        for (int row = 0; row < boggleGrid.length; row++) {
            for (int col = 0; col < boggleGrid[0].length; col++) {
                boggleGrid[row][col] = "x";
            }
        }
        Set<String> dictionary = new HashSet<>();
        dictionary.add("age");
        dictionary.add("agent");
        dictionary.add("energy");
        dictionary.add("synergy");

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

        BoggleBoardThroughMultiThread instance = new BoggleBoardThroughMultiThread();
        instance.scoringMap.put(0, 0);
        instance.scoringMap.put(1, 0);
        instance.scoringMap.put(2, 0);
        instance.scoringMap.put(3, 1);
        instance.scoringMap.put(4, 1);
        instance.scoringMap.put(5, 2);
        instance.scoringMap.put(6, 3);
        instance.scoringMap.put(7, 5);
        instance.scoringMap.put(8, 11);
        instance.printValidWords(dictionary, boggleGrid);
    }

    public void printValidWords(Set<String> dictionary, String[][] boggleGrid) {

        if (boggleGrid.length == 0 || boggleGrid[0].length == 0) return;

        CustomCollection parentC = new CustomCollection();
        parentC.markerGrid = new boolean[boggleGrid.length][boggleGrid[0].length];

        subTraversal(dictionary, boggleGrid, parentC);

        //Printing list of winning words.
        finalList.forEach(System.out::println);
        System.out.println("Final Score " + finalscore);
    }

    private void subTraversal(Set<String> dictionary, String[][] boggleGrid, CustomCollection parentC) {
        List<Thread> traversal = new LinkedList<>();
        for (int r = 0; r < boggleGrid.length; r++) {
            for (int c = 0; c < boggleGrid[0].length; c++) {

                final int row = r;
                final int col = c;
                Runnable r1 = () -> {
                    if (parentC.markerGrid[row][col] == true) return;
                    CustomCollection threadCol = new CustomCollection();
                    threadCol.markerGrid = deepCopy(parentC.markerGrid);
                    threadCol.score = parentC.score;
                    threadCol.progressionList = parentC.progressionList == null ? null : deepCopy(parentC.progressionList);

                    List<CustomCollection> possibleWordsCollection = wordConstruction(boggleGrid[row][col], row, col, dictionary, boggleGrid, threadCol);
                    for (CustomCollection c1 : possibleWordsCollection) {
                        if (c1.score > finalscore) {
                            finalscore = c1.score;
                            finalList = deepCopy(c1.progressionList);
                        }
                        new Thread(() -> subTraversal(dictionary, boggleGrid, c1)).start();
                    }
                };
                Thread t = new Thread(r1);
                t.start();
                traversal.add(t);
            }
        }
        traversal.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private List<CustomCollection> wordConstruction(String word, int prevRow, int prevCol, Set<String> dictionary, String[][] boggleGrid, CustomCollection parentC) {

        //This is the limit on the length of the word. If there is no limit then please remove this line.
        if (word.length() == 8) return null;
        List<CustomCollection> possibleWordCollection = new ArrayList<>();
        for (int row = prevRow - 1; row <= prevRow + 1; row++) {
            for (int col = prevCol - 1; col <= prevCol + 1; col++) {
                if (row < 0 || row >= boggleGrid.length) continue;
                if (col < 0 || col >= boggleGrid[0].length) continue;
                if (parentC.markerGrid[row][col]) continue;

                parentC.markerGrid[row][col] = true;
                String tmp = word + boggleGrid[row][col];

                if (dictionary.contains(tmp)) {
                    CustomCollection c = new CustomCollection();
                    c.markerGrid = deepCopy(parentC.markerGrid);
                    c.score = parentC.score + scoringMap.get(tmp.length());
                    if (parentC.progressionList == null) c.progressionList = new ArrayList<>();
                    else c.progressionList = deepCopy(parentC.progressionList);
                    c.progressionList.add(tmp);
                    possibleWordCollection.add(c);
                }
                List<CustomCollection> tmpCollection = wordConstruction(tmp, row, col, dictionary, boggleGrid, parentC);
                if (tmpCollection != null) possibleWordCollection.addAll(tmpCollection);
                parentC.markerGrid[row][col] = false;
            }
        }
        return possibleWordCollection;
    }

    private boolean[][] deepCopy(boolean[][] markerGrid) {

        boolean[][] deepCopy = new boolean[markerGrid.length][markerGrid[0].length];

        for (int row = 0; row < markerGrid.length; row++) {
            for (int col = 0; col < markerGrid.length; col++) {
                deepCopy[row][col] = markerGrid[row][col];
            }
        }
        return deepCopy;
    }

    private List<String> deepCopy(List<String> list) {

        List<String> deepCopy = new ArrayList<>();
        deepCopy.addAll(list);
        return deepCopy;
    }

    class CustomCollection {
        boolean markerGrid[][];
        int score;
        List<String> progressionList;

    }
}
