package algos;

public class KMinOn2SortedArray {

    static int[] M = {1, 5, 6, 8, 9, 11, 15, 17, 19};
    //  static int[] M = { 1, 1, 1, 1, 1, 1, 1, 1, 1,1,1,1 };
    static int[] N = {4, 7, 8, 13, 15, 18, 20, 24, 26};
    static int k = 12;

    /**
     * len =3 6 9
     * <p>
     * len =2 9 4
     * <p>
     * len=1 8 6
     *
     * @param args Simple Algo
     *             http://stackoverflow.com/questions/4607945/how-to-find
     *             -the-kth-smallest-element-in-the-union-of-two-sorted-arrays
     */
    public static void main(String[] args) {
        traverse(0, k);
        // traverseStackOverflow(k);
    }

    private static void traverse(int pt, int len) {
        int temp = 0;

        if (len <= 3) {
            int n = 0;
            int val = 0;
            if (k - (pt + 1) - 1 - len > -1) {
                n = k - (pt + 1) - 1 - len;
            }

            while (pt + n <= k - 1) {
                if (M[pt] < N[n]) {
                    val = M[pt];
                    pt++;
                } else {
                    val = N[n];
                    n++;
                }
            }

            System.out.println(val);

            return;
        }

        temp = len / 2;

        if (M[pt + temp - 1] < N[k - (pt + temp) - 1]) {
            traverse(pt + temp, temp);

        } else {
            traverse(pt, temp);
        }

    }

    private static void traverseStackOverflow(int k) {
        int i = k / 2; // 4
        int j = k - i; // 5
        int step = k / 4; // 2
        while (step > 0) {
            if (M[i - 1] > N[j - 1]) {
                i -= step;
                j += step;

            } else {
                i += step; // 6
                j -= step; // 3

            }
            step /= 2; // 1

        }

        if (M[i - 1] > N[j - 1])
            System.out.println(M[i - 1]);
        else
            System.out.println(N[j - 1]);

    }
}
