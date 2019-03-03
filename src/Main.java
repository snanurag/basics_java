import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static int[][] map = new int[49][49];

    private static Integer finalComp = 0;

    private static Integer tmp = 0;

    private static int counter2;

    private static Scanner scanner;

    private static int[] highestCompForEnd = new int[49];

    public static void main(String[] args) throws IOException {
        // System.out.println(System.currentTimeMillis());
        scanner = new Scanner(System.in).useDelimiter("\n");
        String line = readLine();

        Integer totalCases = Integer.parseInt(line);

        for (int i = 0; i < totalCases; i++) {

            line = readLine();
            int totalInputs = Integer.parseInt(line.trim());
            map = new int[49][49];
            for (int j = 0; j < totalInputs; j++) {
                line = readLine();
                String[] str = line.trim().split(" ");
                int initTime = Integer.parseInt(str[0]);
                // System.out.println(line);
                int endTime = Integer.parseInt(str[1]);
                int value = Integer.parseInt(str[2]);

                if (map[initTime][endTime] < value)
                    map[initTime][endTime] = value;
            }
            finalComp = 0;
            tmp = 0;
            highestCompForEnd = new int[49];
            getFinalVal(0);
            System.out.print(finalComp);
            if (i != totalCases - 1) {
                System.out.println();
            }
        }
        // System.out.println(System.currentTimeMillis());
        // System.out.println(counter2);
    }

    private static void getFinalVal(int startTime) {

        for (int i = startTime; i < 49; i++) {

            counter2++;

            outer:
            for (int j = i; j < 48; j++) {
                for (int k = j; k < 49; k++) {

                    if (map[j][k] != 0) {

                        tmp += map[j][k];

                        if (highestCompForEnd[k] < tmp) {
                            highestCompForEnd[k] = tmp;
                        } else {
                            tmp -= map[j][k];
                            continue outer;
                        }

                        if (finalComp < tmp) {
                            finalComp = tmp;
                        }
                        getFinalVal(k);

                        tmp -= map[j][k];
                    }
                }
            }

        }

    }

    private static String readLine() throws IOException {

        return scanner.next().trim();
    }

}
