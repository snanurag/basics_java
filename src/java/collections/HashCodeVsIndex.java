package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class HashCodeVsIndex {

    static LinkedList<String> l = new LinkedList<>();
    public static void main(String[] args) {
        for(int i =0; i< 50000000; i++){
            if (i % 1000000 == 0)
                System.out.println("number of iteration -> " + i);

                l.add(String.valueOf(i));
        }

//        timeTakenForGeneratingHash();
        timeTakenInSorting();
    }


    private static void timeTakenInSorting(){
        PriorityQueue priorityQueue = new PriorityQueue();
        long timeInLoopIteration = timeInLoopIteration();
        long time = System.currentTimeMillis();

        l.forEach(n -> priorityQueue.add(n));

        System.out.println(System.currentTimeMillis() - time- timeInLoopIteration);

    }

    /**
     * This is not the correct way becauses hashes were already generated when object was created.
     */
    private static void timeTakenForGeneratingHash(){
        long time = System.currentTimeMillis();
        l.forEach(n -> n.hashCode());
        for (String s : l) {

        }
        System.out.println(System.currentTimeMillis() - time);
    }

    private static long timeInLoopIteration(){
        long time = System.currentTimeMillis();
        for (String s : l) {

        }
        return System.currentTimeMillis() - time;

    }
}
