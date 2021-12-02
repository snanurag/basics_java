package interview_skeletons;

import java.io.IOException;

/**
 * Find a missing number from an array of contiguous numbers
 * 1. Unsorted array
 * 2. Sorted array
 *
 * 1 2 3 4 5 6 7 9
 */

public class SearchMissingNumberInContinuousArray {

    public static void main(String[] args) throws IOException {
        System.out.println(findMissingNumber(new int[]{1,3}));
    }

    public static int findMissingNumber(int [] a){

        if (a[0] != 1){
            return 1;
        }
        if(a.length == 1 && a[0] ==1){
            return 2;
        }
        int i = a.length /2; //4
        int f =0;
        int slice = a.length/2; //4
        while( slice != 0){
            slice /=2; // slice = 0
            if(a[i] -1 == i){ //true
                f = a[i]+1; // f = 8
                i += slice;  // i = 7

            } else{
                f = a[i]-1;
                i -= slice;
            }
        }

        return f;
    }
}
