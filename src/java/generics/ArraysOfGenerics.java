/**
 * Explanation of this is given is given in the tutorial of this link http://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
 */

package generics;

import java.util.ArrayList;
import java.util.List;

public class ArraysOfGenerics {

//    List<?>[] l = new ArrayList<Object>[2]; // Can not create arrays of
    // non-reifiable types

//    List<String>[] m = new ArrayList<String>[5];

    List<String> m2 = new ArrayList<String>();

    public static void main(String[] args) {
        Object[] o = new String[2];
        o[0] = "";
        o[1] = 1; // The above is not allowed because then ArrayStoreException
        // would be thrown at runtime.

    }


//    class MathException<T> extends Exception { /* ... */ }    // compile-time error
}
