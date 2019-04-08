import java.util.SortedMap;
import java.util.TreeMap;

public class Take7 implements Take8 {

    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>();
        map.put(90, "a");
        map.put(40, "b");
        map.put(80, "c");
        map.forEach((k,v)-> System.out.println(k));
    }

    public void setIt() throws IndexOutOfBoundsException {

    }
}