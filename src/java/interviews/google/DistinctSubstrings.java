package interviews.google;

// https://www.interviewbit.com/problems/distinct-subsequences/
public class DistinctSubstrings {
    public int numDistinct(String A, String B) {

        if (A.length() < B.length())
            return 0;
        int a[][] = new int[B.length() + 1][A.length() + 1];
        for (int i = 1; i < B.length() + 1; i++) {
            a[i][0] = 0;
        }
        for (int j = 0; j < A.length() + 1; j++) {
            a[0][j] = 1;
        }
        for (int i = 1; i < B.length() + 1; i++) {
            for (int j = 1; j < A.length() + 1; j++) {

                if (B.charAt(i - 1) != A.charAt(j - 1)) {
                    a[i][j] = a[i][j - 1];
                } else {
                    a[i][j] = a[i][j - 1] + a[i - 1][j - 1];
                }
            }
        }
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return a[B.length()][A.length()];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubstrings().numDistinct("rabbit", "rabit") == 2);
    }
}
