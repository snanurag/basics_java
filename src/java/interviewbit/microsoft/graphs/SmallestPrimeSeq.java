package interviewbit.microsoft.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SmallestPrimeSeq {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> l = new ArrayList<>();
        if(D == 0) return l;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(A);
        q.add(B);
        q.add(C);

        A = q.poll();
        B = q.poll();
        C = q.poll();

        q.add(A);
        q.add(B);
        q.add(C);

        while(q.peek() != 0){
            int val = q.poll();
            if(val%A == 0){
                q.add(val * A);
                q.add(val * B);
                q.add(val * C);
            }
            else if(val % B == 0){
                q.add(val * B);
                q.add(val * C);
            }
            else
                q.add(val * C);

            if(!l.contains(val))l.add(val);
            if(l.size() == D) break;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestPrimeSeq().solve(3,11,7,50));
    }
}


/**
 * 3 7 9 11 21 27 33 49 63 77 81 99 121 147 189 231 243 297 343 363 441 539 567 693 729 847 891 1029 1089 1323 1331 1617 1701 2079 2187 2401 2541 2673 3087 3267 3773 3969 3993 4851 5103 5929 6237 6561 7203 7623
 */