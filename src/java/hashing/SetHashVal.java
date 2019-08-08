package hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetHashVal {
    public static void main(String[] args) {
        sameOrderSet();
        diffOrderSet();
    }

    private static void sameOrderSet(){
        HashSet<Set<Integer>> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(0);

        set.add(set1);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(0);


        System.out.println(set.contains(set2));

        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());

        System.out.println(set1.equals(set2));
    }

    private static void diffOrderSet(){
        HashSet<Set<Integer>> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(0);

        set.add(set1);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);


        System.out.println(set.contains(set2));

        System.out.println(set1.hashCode());
        System.out.println(set2.hashCode());

        System.out.println(set1.equals(set2));
    }

}
