package interviews.rakuten;


/**
 * Simpler Approach.
 *
 * Mar 2019
 * <p>
 * There is a series of trees for different height e.g. {3,4,5,4}.
 * You have to cut exactly one tree and create a non-decreasing series.
 * <p>
 * Return the total number of ways.
 * <p>
 */

public class NonDecreasingTreeSequence2 {
    public static void main(String[] args) {
        NonDecreasingTreeSequence2 s = new NonDecreasingTreeSequence2();
        System.out.println(s.solution(new int[]{4, 5, 2, 5, 4}) == 0);
        System.out.println(s.solution(new int[]{4, 5, 2, 3, 4}) == 0);
        System.out.println(s.solution(new int[]{4, 5, 4, 3}) == 0);
        System.out.println(s.solution(new int[]{3, 4, 5, 4, 4, 4}) == 1);
        System.out.println(s.solution(new int[]{4, 6, 5, 5, 6}) == 1);
        System.out.println(s.solution(new int[]{3, 4, 5, 4}) == 2);
        System.out.println(s.solution(new int[]{3, 3, 5, 4}) == 2);
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5}) == 5);

    }

    public int solution(int[] A) {
        if (A.length < 3) return A.length;
        int numOfWays = 0;
        boolean cuttingDone = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {

                if (cuttingDone) return 0;
                else cuttingDone = true;

                if (isCutPossible(i, A)) numOfWays++;
                if (isCutPossible(i - 1, A)) numOfWays++;
            }
        }
        if (cuttingDone)
            return numOfWays;
        else return A.length;
    }

    public boolean isCutPossible(int i, int[] A) {
        if (i + 1 < A.length) {
            if (A[i - 1] <= A[i + 1]) return true;

        } else return true;
        return false;


    }
}
