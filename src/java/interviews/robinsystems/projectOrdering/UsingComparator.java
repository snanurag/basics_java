package interviews.robinsystems.projectOrdering;


import java.util.*;

/**
 * Input
 * project : a, b, c, d, e, f
 * dependencies : (a,d), (f,b), (d, c), (f a) -> (x,y) : x before y
 * Output
 * f, a, d, c, b, e
 */
public class UsingComparator {

    public static void main(String[] args) {
        String[] a = new String[]{"a", "b","c","d","e","f"};
        String[][] dep = new String[][]{{"a","d"},{"f", "b"},{"d","c"},{"f","a"}};

        addProj(a, dep);
        set.forEach(System.out::println);
    }
    static Comp c = new Comp();
    static TreeSet<String> set = new TreeSet<>(c);
    public static void addProj(String[] a, String[][] dep){
        for (String[] strings : dep) {
            c.setComparision(strings[0], strings[1]);
        }

        for(String p:a){
            set.add(p);
        }
    }

}

class Comp implements Comparator<String> {

    Map<String, Set<String>> map = new HashMap<>();
    public void setComparision(String x, String y){
        Set<String> set = map.get(x);
        if(set == null)
        {
            set = new HashSet<>();
            map.put(x, set);
        }
        set.add(y);
    }

    @Override
    public int compare(String x, String y) {
        if(map.containsKey(x)){
            Set<String> set = map.get(x);
            if(set.contains(y))
                return -1;

        }
        return 1;
    }
}