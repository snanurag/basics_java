package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StatefulIntermediate {

    public static void main(String[] args) {

        nonParallelStream();
        System.out.println("\n :::::::::::: Parallel Stream :::::::: \n ");
        parallelStream();
    }

    private static void nonParallelStream(){
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.stream();
        stream.filter(n -> {
            System.out.println("Filter from seq stream : " + Thread.currentThread().getName());
            return true;
        }).sorted().filter(n -> {
            System.out.println("Sorted from seq Stream : " + n + " : "+Thread.currentThread().getName());
            return true;
        }).distinct().forEach(n -> {
            System.out.println("Distinct from seq for each : " + Thread.currentThread().getName());
            System.out.println(n);
        });

    }

    private static void parallelStream(){
        List<Integer> l = new ArrayList<>();
        int i = 5;
        do {
            l.add(i);
            i--;
        } while (i > 0);
        Stream stream = l.parallelStream();
        stream.filter(n -> {
            System.out.println("Filter from parallel : " + Thread.currentThread().getName());
            return true;
        }).sorted().forEach(n -> {
            System.out.println("Sorted from parallel for each : " + Thread.currentThread().getName());
            System.out.println(n);
        });

    }

}
