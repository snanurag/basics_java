package collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapvsHashTable {


    public static void main(String[] args) {
        Map ht = new Hashtable();
        Map hm = new HashMap();

        // ht.put(null,null); This gives runtime exception.
        // ht.get(null); This gives runtime exception.
        System.out.println(hm.get(null)); // hashmap by default has <null,null> key-value pair. So, it doesn't fail in conditional statements.
    }
}
