package interviewbit.google;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/min-jumps-array/
 *
 */
public class MinJumps {
    public int jump(ArrayList<Integer> A) {
        if(A.size() == 1){
            return 0;
        }
        int jumps = 1;
        int lastReach = A.get(0);
        int maxReach = A.get(0);
        System.out.println("node -> jump -> last -> max");
        for(int i=1; i<A.size(); i++){
            System.out.print(A.get(i)+" -> ");
            if(maxReach < i){
                return -1;
            }
            if(lastReach < i){
                jumps++;
                lastReach = maxReach;
            }
            maxReach = Math.max(maxReach, i + A.get(i));
            System.out.print(jumps+" -> ");
            System.out.print(lastReach +" -> ");
            System.out.println(maxReach );
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new MinJumps().jump(new ArrayList<>(Arrays.asList(2,3,1,1,4,1))));
    }
}
