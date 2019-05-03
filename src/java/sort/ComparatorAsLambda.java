package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ComparatorAsLambda {

    static PriorityQueue<Element> queue = new PriorityQueue<>(2, (a, b) -> {
        return a.t > b.t ? -1 : 1;
    });



    public static void main(String[] args) {
        Map m = new HashMap();

        Long a = 1000L;
        Long b =1000L;
        System.out.println(a == b);
        queue.add(new Element(1));
        queue.add(new Element(2));
        queue.add(new Element(3));
        queue.add(new Element(4));
        queue.add(new Element(5));
        queue.add(new Element(6));


        while(!queue.isEmpty())
            System.out.println(queue.poll());
    }
    static class Element {
        Element(long t){
            this.t = t;
        }
        long t;

        @Override
        public String toString() {
            return String.valueOf(t);
        }
    }
}
