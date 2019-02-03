package streams;

import java.io.*;
import java.util.*;

public class SteamsParallelizationTest {
    public static void main(String[] args) throws IOException

    {
        File f = new File("test.txt");
        Writer w = new FileWriter(f);
        BufferedWriter bfw = new BufferedWriter(w);
        List<Integer> l = new ArrayList();
        for (int i = 0; i < 100000000; i++) l.add(i);
        System.out.println("List created");
//        l.stream().forEach(System.out::println); //Printing sequentially
//        l.parallelStream().forEach(System.out::println); //Printing parallelly.
        l.stream().parallel().forEach(System.out::println); //Printing parallely

        System.out.println("all writing done.");

    }


}
