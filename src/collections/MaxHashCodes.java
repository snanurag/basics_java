package collections;

import java.lang.reflect.Field;
import java.util.*;

public class MaxHashCodes {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        hashmapRunningCapicityVSNewObjects();
        checkDifferentHashcodesProduced();
    }


    /**
     * This function shows that number of hash reminders with max bucket cap are quite close to the number of objects created.
     * That is why any objects can fill up any hash based collection quite sparsely.
     * 100M objects produced 83M different hash codes. So on average, every bucket will have either 1 or 2 objects stored.
     */
    private static void checkDifferentHashcodesProduced() {

        //Hashmap max capicity is 1 << 30 (1 Billion around) but at 8 GB jvm heap only around 100M objects can be produced and stored. That is why we are observing the hash bucket's filling at 1 << 28 ( 268M buckets)
        int hashBucketMaxCap = 1 << 28;
        List<Object> l = new LinkedList<>();
        Set<Integer> s = new HashSet<>();

        for (double i = 0; i < 4294967296.0; i++) {
            Object o = new Object();
            l.add(o);
            s.add(o.hashCode() % hashBucketMaxCap);
            if (i % 1000000 == 0) System.out.println("Total objects " + l.size() + " Total hashes " + s.size());

        }

    }

    /**
     * This function shows that new objects has the hashcodes which fills the buckets rather than going into same bucket.
     * In output, hashmap buckets will keep increasing when total objects reaches the load factor point (0.75).
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void hashmapRunningCapicityVSNewObjects() throws NoSuchFieldException, IllegalAccessException {
        HashMap m = new HashMap();
        System.out.println("10001".hashCode());
        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        System.out.println(1 << 30);

        for (double i = 0; i < 4294967296.0; i++) {
            m.put(new Object(), null);
            if (i % 1000000 == 0) {
                System.out.println("number of iteration -> " + i);
                Object[] table = (Object[]) tableField.get(m);
                System.out.println(table == null ? 0 : table.length);
            }
        }

    }
//        System.out.println(table ==null?0:table.length);


}
