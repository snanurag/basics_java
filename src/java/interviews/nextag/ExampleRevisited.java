package interviews.nextag;

import java.io.File;
import java.io.FileWriter;

public class ExampleRevisited {

    private int[] a1;
    private int totalDivisors = 200;
    private int[] pos = new int[totalDivisors];

    public static void main(String[] args) {
        ExampleRevisited er = new ExampleRevisited();

        er.shuffle(1002, 101);
    }

    public void shuffle(int n, int cut) {
        if (n <= cut) {
            throw new IllegalArgumentException("Deck size should be more than the cut size.");
        }
        int lcf = (n - 1) / totalDivisors;        // n-1 is used because we are interested in storing indexes only.
        initialize(lcf);
        rearrange(n, cut);
    }

    private void initialize(int lcf) {

        for (int i = 0; i < pos.length; i++) {
            pos[i] = lcf * (i + 1);
        }
        a1 = pos.clone();
    }

    private void rearrange(int n, int cut) {
        double counter = 0;
        outer:
        while (true) {
            counter++;
            for (int m = 0; m < a1.length; m++) {
                if (a1[m] < cut) {
                    a1[m] = n + 2 * a1[m] + 1 - 2 * cut;    //n - (2*(cut - m) -1)
                } else if (n - cut - 1 < a1[m] && a1[m] < n) {
                    a1[m] = 2 * a1[m] - n;    //n - 2*(n-m)
                } else {
                    a1[m] = a1[m] - cut;
                }
            }

            for (int i = 0; i < a1.length; i++) {
                if (a1[i] != pos[i]) {
                    break;
                }
                if (i == a1.length - 1) {
                    try {
                        File f = new File("output2.txt");
                        FileWriter fw = new FileWriter(f);
                        fw.write("\n");
                        fw.write("No of times " + counter);
                        fw.flush();
                        fw.close();

                        System.out.println("Total no. of counts " + counter);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    break outer;
                }
            }
        }
    }
}
