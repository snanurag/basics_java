package splititerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Test {

    public static void main(String[] args) throws IOException

    {
        File f = new File("test.txt");
        Writer w = new FileWriter(f);
        BufferedWriter bfw = new BufferedWriter(w);
        List<Integer> l = new ArrayList();
        for (int i = 0; i < 1000; i++) l.add(i);
        System.out.println("List created");
//        l.spliterator().forEachRemaining(System.out::println); //Printing sequentially
        Spliterator<Integer> originalSplitItr = l.spliterator();
        Spliterator<Integer> splitedItr = originalSplitItr.trySplit();

        System.out.println("One element output");
        originalSplitItr.tryAdvance(System.out::println);

        System.out.println("Original iterator run");
        originalSplitItr.forEachRemaining(System.out::println);

        System.out.println("Splitted iterator run");
        splitedItr.forEachRemaining(System.out::println);

        System.out.println("all writing done.");

    }

}
