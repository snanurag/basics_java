package algopractice.rakuten;
/**
 * Return the smallest positive number not present in input array.
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {

        Set<Integer> existing = new HashSet<>();

        int finalN = 1;
        for(int i:A){
            if(i > 0) existing.add(i);
            if(finalN == i) {
                do
                    finalN++;
                while(existing.contains(finalN));
            }
        }
        return finalN;
        // write your code in Java SE 8
    }
}