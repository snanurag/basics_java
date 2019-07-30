package sort;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchANonExistingNumber {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(4);
        list.add(9);
        list.add(14);
        System.out.println(Collections.binarySearch(list, 2));

    }
}
