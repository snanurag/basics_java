package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsParallelizationNature {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        int i = 0;
        do {
            l.add(i);
            i++;
        } while (i < 100);
        Stream stream = l.stream();
        stream.limit(100).filter(n -> {
            System.out.println("Filter 1 : " + Thread.currentThread().getName());
            return true;
        }).filter(n -> {
            System.out.println("Filter 2 : " + Thread.currentThread().getName());
            return true;
        }).forEach(n -> {
            System.out.println("For Each : " + Thread.currentThread().getName());
            System.out.println(n);
        });

    }
}
