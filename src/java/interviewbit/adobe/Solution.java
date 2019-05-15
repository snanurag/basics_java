package interviewbit.adobe;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
        int low;
        int high;

        int[] arr = {0,2,1,2,0};

        int moving = 0;

        low = 0;
        high = arr.length -1;

        while(moving < arr.length){
            if(arr[moving] == 0){
                while(arr[low] == 0) low++;
                if(low < moving) swap(arr, low, moving);
            }
            else if(arr[moving] == 2){
                while(arr[high] == 2) high--;
                if(moving < high) {
                    swap(arr, moving,high);
                    continue;
                }
            }
            moving++;
        }

        for(Integer i:arr) System.out.print(i+" ");
    }
    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}