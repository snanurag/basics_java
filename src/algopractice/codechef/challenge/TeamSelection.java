package algopractice.codechef.challenge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeamSelection {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {

        inputStream = new FileInputStream(new File("in.txt"));

        int totalCases = Integer.parseInt(readLine());

        for (int i = 0; i < totalCases; i++) {
            readLine();

            int totalPlayers = Integer.parseInt(readLine());

            int[] players = new int[totalPlayers];

            for (int j = 0; j < totalPlayers; j++) {

                players[j] = Integer.parseInt(readLine());

            }

            Arrays.sort(players);

            int grandTotal = getTotalOfCollection(players);

            int median = grandTotal / 2; // This could be maximum possible total
            // of
            // one team

            List<Integer> list = new ArrayList<Integer>();

            int total = 0;
            int k = 0;
            int end = totalPlayers / 2;
            if (totalPlayers % 2 != 0) {
                end = totalPlayers / 2 + 1;
            }
            for (k = 0; k < end; k++) {
                total += players[k];
                if (total > median) {
                    total -= players[k];
                    break;
                }
                list.add(players[k]);
            }

            for (; k < totalPlayers; k++) {
                int diff = median - total;
                int l = 0;
                boolean replacePlayer = false;
                for (l = list.size() - 1; l >= 0; l--) {
                    int player = list.get(l);
                    int tempDiff = players[k] - player;

                    if (tempDiff > diff) {
                        if (l != list.size() - 1) {
                            replacePlayer = true;
                        }
                        break;
                    } else if (l == 0) {
                        replacePlayer = true;
                        break;
                    }
                }
                if (replacePlayer) {

                    if (l != 0)
                        l += 1;
                    total -= list.remove(l);
                    list.add(players[k]);
                    total += players[k];
                    Collections.sort(list);
                }

            }

            System.out.print(total);
            System.out.print(" ");
            System.out.print(grandTotal - total);
            System.out.println();
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

}
