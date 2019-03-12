package algopractice.codechef.challenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TeamSelection2 {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    private static int[] players;

    private static boolean[] markerArray;

    private static int halfSum;

    private static int lastStoredSum;

    private static boolean[] lastStoredCopy;

    public static void main(String[] args) throws IOException {

        inputStream = new FileInputStream(new File("in.txt"));

        int totalCases = Integer.parseInt(readLine());

        for (int i = 0; i < totalCases; i++) {
            readLine();

            int totalPlayers = Integer.parseInt(readLine());

            players = new int[totalPlayers];

            for (int j = 0; j < totalPlayers; j++) {

                players[j] = Integer.parseInt(readLine());

            }

            markerArray = new boolean[players.length];
            lastStoredCopy = null;
            lastStoredSum = 0;

            int grandTotal = getTotalOfCollection(players);

            halfSum = grandTotal / 2;

            recursiveFunction();

            int total = getSum(lastStoredCopy);

            System.out.print(total);
            System.out.print(" ");
            System.out.print(grandTotal - total);
            if (i != totalCases - 1)
                System.out.println('\n');

        }
    }

    private static String readLine() throws IOException {

        String str = null;

        if (counter == 8192 || counter == 0) {
            b = new byte[8192];
            inputStream.read(b);
        }

        while (true) {

            if (counter != 8192) {
                char c = (char) b[counter];
                counter++;
                if (c != '\n' && c != 0) {
                    buff.append(c);
                } else {

                    str = buff.toString();
                    buff = new StringBuffer();
                    return str.trim();
                }
            } else {
                b = new byte[8192];
                inputStream.read(b);
                counter = 0;
            }
        }
    }

    private static int getTotalOfCollection(int[] players) {
        int total = 0;
        for (int i = 0; i < players.length; i++) {
            total += players[i];
        }

        return total;
    }

    private static void recursiveFunction() {
        for (int i = 0; i < markerArray.length; i++) {
            if (!markerArray[i]) {
                markerArray[i] = true;
                int tmpSum = getSum(markerArray);
                if (tmpSum > halfSum) {
                    tmpSum -= players[i];
                    markerArray[i] = false;
                } else if (tmpSum < halfSum) {
                    recursiveFunction();
                }
                if (tmpSum <= halfSum && tmpSum > lastStoredSum) {
                    lastStoredSum = tmpSum;
                    lastStoredCopy = markerArray.clone();
                }

                markerArray[i] = false;
            }
        }
    }

    private static int getSum(boolean[] markerArray) {
        int sum = 0;
        for (int i = 0; i < markerArray.length; i++) {
            if (markerArray[i]) {
                sum += players[i];
            }
        }

        return sum;
    }

}
