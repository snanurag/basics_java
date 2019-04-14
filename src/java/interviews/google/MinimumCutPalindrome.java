package interviews.google;

/**
 * Try to do this one using stack and keeping count. That would have been easier.
 *
 * https://www.interviewbit.com/problems/palindrome-partitioning-ii/
 *
 */
public class MinimumCutPalindrome {

    public int minCut(String a) {
        int[] cut = new int[a.length()];
        boolean[][] palindrome = new boolean[a.length()][a.length()];

        for (int i = 0; i < a.length(); i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (a.charAt(i) == a.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) {
                    palindrome[j][i] = true;
                    minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1));
                }
            }
            cut[i] = minCut;
        }

        return cut[a.length() - 1];
    }

}
