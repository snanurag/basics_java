package interviews.nextag;

import java.io.File;
import java.io.FileWriter;

public class Example {

    private int[] a1;
    private int[] a2;

    public static void main(String[] args) {
        new Example().shuffle(500, 91);

    }

    public void shuffle(int n, int cut) {
        if (n <= cut) {
            throw new IllegalArgumentException("Deck size should be more than the cut size.");
        }
        a1 = new int[n];
        a2 = new int[n];
        initializeArray(n);
        int[] finalArray = rearrange(a1, a2, cut);
        double counter = 1;
        long time = System.currentTimeMillis();
        while (true) {
            int currentPointer = 0;

            if (counter == Double.MAX_VALUE) {
                System.out.println("Counter reached its maximum value " + counter);
            }

            while (currentPointer < a1.length
                    && finalArray[currentPointer] == currentPointer + 1) {
                currentPointer++;
            }

            if (currentPointer < a1.length) {
                if (finalArray == a1) {
                    finalArray = rearrange(finalArray, a2, cut);
                } else {
                    finalArray = rearrange(finalArray, a1, cut);
                }
                counter++;
            } else {
                try {
                    File f = new File("output.txt");
                    FileWriter fw = new FileWriter(f);
                    for (int i : finalArray) {
                        System.out.print(i + " ");
                        fw.write(i + " ");
                    }
                    System.out.println();
                    System.out.println("No of times " + counter);
                    fw.write("\n");
                    fw.write("No of times " + counter);
                    time = System.currentTimeMillis() - time;
                    fw.write("Total time " + time + "\n");
                    fw.flush();
                    fw.close();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                break;
            }
        }
    }

    private int[] rearrange(int[] a1, int[] a2, int cut) {
        int arrayLen = a2.length;
        int n = arrayLen;
        int currentPointer = arrayLen - 1;
        int a1Pointer = -1;
        int a1BreakPoint = cut;

        for (int i = cut - 1; i >= 0; i--) {
            a2[currentPointer] = a1[i];
            currentPointer--;
            a2[currentPointer] = a1[n - 1];
            currentPointer--;
            n--;
            if (n - 1 == cut - 1) {
                a1Pointer = i - 1;
                a1BreakPoint = 0;
                break;
            } else {
                a1Pointer = n - 1;
            }
        }

        while (a1Pointer >= a1BreakPoint) {
            a2[currentPointer] = a1[a1Pointer];
            currentPointer--;
            a1Pointer--;
        }

        return a2;
    }

    private void initializeArray(int n) {

        for (int i = 0; i < n; i++) {
            a1[i] = i + 1;
        }
    }
}