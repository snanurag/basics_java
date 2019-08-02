package hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListHashValue {

    /**
     * Because this is the hashcode of list. It is sume of hashcode of all the values in list.
     *
     *         int hashCode = 1;
     *         for (int i = from; i < to; i++) {
     *             Object e = es[i];
     *             hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
     *         }
     *         return hashCode;
     *
     * @param args
     */
    public static void main(String[] args) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);

        set.add(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(0);

        System.out.println(set.contains(list2));

        System.out.println(list.hashCode());
        System.out.println(list2.hashCode());

        System.out.println(list.equals(list2));
    }
}
