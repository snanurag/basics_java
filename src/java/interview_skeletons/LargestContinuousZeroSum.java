package interview_skeletons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Find the largest continuous sequence in a array which sums to zero.
 *
 * Example:
 *
 *
 * Input:  {1 ,2 ,-2 ,4 ,-4}
 * Output: {2 ,-2 ,4 ,-4}
 */
public class LargestContinuousZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i=0; i <A.size(); i++){
            count += A.get(i);
            if(count == 0){
                start = -1;
                end = i;
            }
            Integer val = map.get(count);
            if(val == null)
                map.put(count, i);
            else
            if(i - val > end - start){
                end = i;
                start = val;
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = start+1; i<=end; i++){
            l.add(A.get(i));
        }
        return l;
    }
}
