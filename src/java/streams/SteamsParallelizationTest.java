package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Parallelstream runs threads in parallel.
public class SteamsParallelizationTest {
    public static void main(String[] args) throws IOException {
        Set<String> threadNames = new HashSet<>();
        File f = new File("test.txt");
        Writer w = new FileWriter(f);
        BufferedWriter bfw = new BufferedWriter(w);
        List<Integer> l = new ArrayList();
        for (int i = 0; i < 10000; i++) l.add(i);
        System.out.println("List created");
//        l.stream().forEach(System.out::println); //Printing sequentially
//        l.parallelStream().forEach(System.out::println); //Printing parallelly.
        l.stream().parallel().forEach(System.out::println); //Printing parallely

//        l.stream().forEach(n ->
//        threadNames.add(Thread.currentThread().getName())
//        );
        l.parallelStream().forEach(n ->
                threadNames.add(Thread.currentThread().getName())
        );
        threadNames.forEach(System.out::println);
        System.out.println("all writing done.");

    }


}
