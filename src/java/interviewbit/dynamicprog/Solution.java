package interviewbit.dynamicprog;

import java.util.*;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int n = A.size();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        Collections.sort(A);
        int arr[] = new int[n];
        Arrays.fill(arr,1);
        int diff = 0;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                diff = Math.abs(A.get(i)-A.get(j));
                if(hm.containsKey(diff) && arr[i] < arr[j]+1) {
                    hm.put(diff,hm.get(diff)+1);
                    arr[i] = arr[j]+1;
                }
                else if(!hm.containsKey(diff)){
                    hm.put(diff,2);
                    if(arr[i] < arr[j]+1) {
                        arr[i]= arr[j]+1;
                    }
                }
            }
        }
        int max = 1;
        for(Map.Entry<Integer,Integer> mp : hm.entrySet()) {
            if(mp.getValue() > max) {
                max  = mp.getValue();
            }
        }
        int max2 = 1;
        for(int i=0;i<n;i++) {
            if(arr[i] > max2) {
                max2 = arr[i];
            }
        }
        return Math.min(max2,max);
    }
}