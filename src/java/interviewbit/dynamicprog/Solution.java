package interviewbit.dynamicprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int i = 1;
        int[] values = new int[A.size()];

        values[0] = 1;

        while(i < A.size()){
            int j = i-1;
            while(j > -1 && A.get(j) >= A.get(i) ){
                j--;
            }
            if(j == -1) values[i] = values[i-1];
            else
                values[i] = values[j] +1 > values[i-1] ? values[j]+1 : values[i-1];
            i++;
        }

        for(int k=0 ; k<A.size() ;k++){
            System.out.print( A.get(k) +" ");
            System.out.println(values[k]);
        }
        return values[values.length -1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> l = Arrays.asList(69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55, 88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88, 68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66, 94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 );
        System.out.println(s.lis(l));
    }
}

