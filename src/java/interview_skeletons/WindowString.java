package interview_skeletons;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
 *
 * Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.
 *
 * Example :
 *
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC"
 *
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string ''.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).
 */
public class WindowString {
    public String minWindow(String s, String B) {
        int[] need = new int[128];
        for(char c : B.toCharArray()) need[c]++;
        int i = 0, j = 0, l = 0, r = 0, missing = B.length();
        while(r < s.length()){
            char right = s.charAt(r);
            if(need[right] > 0) missing -= 1;
            need[right]--;
            r += 1;
            while(missing == 0){
                if(j == 0 || (r - l) < (j - i)){
                    j = r;
                    i = l;
                }
                char left = s.charAt(l);
                need[left]++;
                if(need[left] > 0) missing += 1;
                l += 1;
            }
        }
        return s.substring(i, j);
    }
}
