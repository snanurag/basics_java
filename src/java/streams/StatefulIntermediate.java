package streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StatefulIntermediate {

    public static void main(String[] args) {

        nonParallelStream();
        System.out.println("\n :::::::::::: Stream 2 :::::::: \n ");
        nonParallelStream2();
        System.out.println("\n :::::::::::: Stream 3 :::::::: \n ");
        nonParallelStream3();
        System.out.println("\n :::::::::::: Parallel Stream :::::::: \n ");
        parallelStream();
        System.out.println("\n :::::::::::: Parallel Stream 2:::::::: \n ");
        parallelStream2();
    }

    /**
     * Print all filter values first then sorted values started printing because sort needs to see whole sequence.
     * Hence stateful.
     */
    private static void nonParallelStream() {
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.stream();
        stream.filter(n -> {
            System.out.println("Filter from seq stream : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).sorted().forEach(n -> {
            System.out.println("Sorted from seq Stream : " + n + " : " + Thread.currentThread().getName());

        });

    }


    /**
     * 2nd sorted knows that stream is already sorted. That's why 2nd sorted is not stateful.
     */
    private static void nonParallelStream2() {
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.stream();
        stream.filter(n -> {
            System.out.println("Filter from seq stream : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).sorted().filter(n -> {
            System.out.println("Sorted 1 from seq Stream : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).distinct().sorted().forEach(n -> {
            System.out.println("Sorted 2 from seq Stream : " + n + " : " + Thread.currentThread().getName());
        });

    }

    /**
     * In this case 2nd sorted stream doesn't know that stream is already sorted because mapToInt is used in between.
     * 2nd sorted doesn't know that mapToInt is returning same numbers.
     * That is why first full list from filter then full list from 1st sorted then full list from 2nd sorted.
     */
    private static void nonParallelStream3() {
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.stream();
        stream.filter(n -> {
            System.out.println("Filter from seq stream : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).sorted().filter(n -> {
            System.out.println("Sorted 1 from seq Stream : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).mapToInt(n -> (int) n).sorted().forEach(
                n -> {
                    System.out.println("Sorted 2 from seq Stream : " + n + " : " + Thread.currentThread().getName());
                }
        );

    }

    /**
     * Sorted stream is a parallel stream. So can't trust it because multiple threads running there.
     *
     */
    private static void parallelStream() {
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.parallelStream();
        stream.filter(n -> {
            System.out.println("Filter from parallel : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).sorted().forEach(n -> {
            System.out.println("Sorted from parallel for each : " + n + " : "+ Thread.currentThread().getName());
        });
    }

    // Last sequential call made the whole stream sequential.
    private static void parallelStream2() {
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.parallelStream();
        Iterator<Integer> itr =         stream.filter(n -> {
            System.out.println("Filter from parallel : " + n + " : " + Thread.currentThread().getName());
            return true;
        }).sorted().sequential().iterator();

        while(itr.hasNext()) System.out.println(itr.next());
    }

}
