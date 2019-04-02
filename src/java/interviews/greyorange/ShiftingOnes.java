package interviews.greyorange;

import java.util.Arrays;
import java.util.List;

/**
 * An array of 0/1 is provided e.g. 10100001. Find the minimum number of moves required to move all 1s or all 0s to one side.
 * For example in this question, it is 6 moves required.
 */
public class ShiftingOnes {

    public static void main(String[] args) {
        System.out.println(shiftOnes(Arrays.asList(new Integer[]{0, 0, 1, 0, 0, 1})));
    }

    public static int shiftOnes(List<Integer> ones) {
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < ones.size(); i++) {
            if (ones.get(i) == 1) {
                currentSum += i + 1;
                count++;
            }
        }
        //If all ones at begining.
        int count_sum_begin = count * (count + 1) / 2;
        //If all ones at end.
        int count_sum_end = count_sum_begin + count * (ones.size() - count);

        int moves = count_sum_begin - currentSum;
        if (moves < 0) moves *= -1;
        if (count_sum_end - currentSum < moves) moves = count_sum_end - currentSum;
        return moves;
    }
}
