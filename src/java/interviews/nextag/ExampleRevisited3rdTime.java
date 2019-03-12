package interviews.nextag;

/**
 * This class solves the deck problem for any large value whithin seconds.
 *
 * @author anurag
 */
public class ExampleRevisited3rdTime {

    /**
     * This array stores the initial positions of any two cards.
     */
    private int[] pos = new int[2];

    /**
     * This array stores the positions of the two cards during shuffling.
     */
    private int[] a1 = new int[2];

    /**
     * It stores the minimum number of counts required to arrange the deck in
     * same order.
     */
    private double leastCounter = 1;

    /**
     * It keeps the track of positions whose shuffling is remaining.
     */
    private int appender;

    public static void main(String[] args) {
        ExampleRevisited3rdTime er = new ExampleRevisited3rdTime();

        //Answer for this is 5812104600 shuffles.
        er.shuffle(1002, 101);

    }

    /**
     * This is the method which is called for shuffling. First it calls the
     * initialize method which inserts the positions in pos array and a1 array.
     * appender is kept on increasing by 2 so that all the positions get
     * covered. If appender hits the last position in an odd deck then it
     * initialize the pos and a1 array with length 1 only.
     * <p>
     * After initialize it calls the getNumberOfCounts function, which returns
     * the number of counts for rearranging the positions in initial order of
     * array a1.
     * <p>
     * After that least common factor is called for the leastCounter and
     * tempCounter and appender is increased by 2.
     *
     * @param n
     * @param cut
     */
    public void shuffle(int n, int cut) {
        double tempCounter = 1;
        if (n <= cut) {
            throw new IllegalArgumentException(
                    "Deck size should be more than the cut size.");
        }
        while (appender < n) {
            if (appender == n - 1) {
                pos = new int[1];
                a1 = new int[1];
            }
            initialize();
            tempCounter = getNumberOfCounts(n, cut);
            leastCounter = getLCF(leastCounter, tempCounter);
            appender = appender + 2;
        }
        System.out.println("The no. of counts " + leastCounter);
    }

    /**
     * This function initialize the pos and a1 array. It adds the appender to
     * the index variable of the array.
     */
    private void initialize() {

        for (int i = 0; i < pos.length; i++) {
            pos[i] = i + appender;
            a1[i] = i + appender;
        }
    }

    /**
     * This function tracks the positions in the a1 array. It has the formulas,
     * which determine the next positions of the current a1 array positions for
     * every shuffle. The positions are tracked in an infinite while loop, which
     * means that number of counts are tracked till the same order repeats.
     *
     * @param n
     * @param cut
     * @return
     */
    private double getNumberOfCounts(int n, int cut) {
        double counter = 0;
        outer:
        while (true) {
            counter++;
            if (cut < n - cut) {
                for (int m = 0; m < a1.length; m++) {
                    // 0 <= m < cut
                    if (a1[m] < cut) {
                        // m = n - (2*(cut - m) -1)
                        a1[m] = n + 2 * a1[m] + 1 - 2 * cut;
                        // (n-1)-cut < m < n
                    } else if (n - 1 - cut < a1[m] && a1[m] < n) {
                        // m = n - 2*(n-m)
                        a1[m] = 2 * a1[m] - n;
                        // cut <= m <= (n-1)-cut
                    } else {
                        // m = m - cut
                        a1[m] = a1[m] - cut;
                    }
                }
            } else {
                for (int m = 0; m < a1.length; m++) {
                    // (cut-1)-(n-cut) < m < cut
                    if (2 * cut - n - 1 < a1[m] && a1[m] < cut) {
                        // m = n - (2*(cut - m) -1)
                        a1[m] = n + 2 * a1[m] + 1 - 2 * cut;
                        // cut <= m < n
                    } else if (cut <= a1[m] && a1[m] < n) {
                        // m = n - 2*(n-m)
                        a1[m] = 2 * a1[m] - n;
                        // 0 <= m <= (cut-1)-(n-cut)
                    } else {
                        // m = m
                        a1[m] = a1[m];
                    }
                }
            }

            for (int i = 0; i < a1.length; i++) {
                if (a1[i] != pos[i]) {
                    break;
                }
                if (i == a1.length - 1) {
                    break outer;
                }
            }
        }
        return counter;
    }

    /**
     * This function returns the least common factor of the two variables, a and
     * b.
     *
     * @param a
     * @param b
     * @return
     */
    private double getLCF(double a, double b) {
        return (a * b) / getHCF(a, b);
    }

    /**
     * This function returns the highest common factor of the two variables, a
     * and b.
     *
     * @param a
     * @param b
     * @return
     */
    private double getHCF(double a, double b) {
        if (b == 0) {
            return a;
        } else {
            return getHCF(b, a % b);
        }
    }
}
