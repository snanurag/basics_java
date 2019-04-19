package interviewbit.google;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/majority-element/
 */
public class MajorityEvent {

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(Arrays.asList(1, 3, 2, 2, 2)) == 2);
        System.out.println(new Solution().majorityElement(Arrays.asList(1, 2, 3, 4, 2, 2, 2)) == 2);
        System.out.println(new Solution().majorityElement(Arrays.asList(1, 2, 3, 4, 2, 2)) == 0);
    }

    static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int majorityElement(final List<Integer> a) {
            int maj_index = 0, count = 1;
            int maj = a.get(0);
            int i;
            for (i = 1; i < a.size(); i++) {
                if (maj == a.get(i))
                    count++;
                else
                    count--;
                if (count == 0) {
                    maj = a.get(i);
                    maj_index = i;
                    count = 1;
                }
            }
            final int number = maj;
            if (a.stream().filter(n -> n == number).count() > a.size() / 2)
                return a.get(maj_index);
            else return 0;
        }
    }


}
