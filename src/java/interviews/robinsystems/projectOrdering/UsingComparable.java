package interviews.robinsystems.projectOrdering;

import java.util.*;

public class UsingComparable {

    private static TreeSet<ComparableObj> set = new TreeSet<>();
    public static void main(String[] args) {
        String[] a = new String[]{"a", "b","c","d","e","f"};
        String[][] dep = new String[][]{{"a","d"},{"f", "b"},{"d","c"},{"f","a"}};
        addProj(a, dep);
        set.forEach( n -> { System.out.println(n.s);});

    }

    public static void addProj(String[] a, String[][] dep){
        Map<String, ComparableObj> map  = new HashMap<>();

        for(String p:a){
            map.put(p, new ComparableObj(p));
        }

        for(String[] arr:dep){
            map.get(arr[0]).set(map.get(arr[1]));
        }
        set.addAll(map.values());
    }
}

class ComparableObj implements Comparable<ComparableObj>{
    public String s;
    public ComparableObj(String s){
        this.s = s;
    }

    Set<ComparableObj> set = new HashSet<>();
    public void set(ComparableObj s){
        set.add(s);
    }

    @Override
    public int compareTo(ComparableObj o) {
        if(set.contains(o))
            return -1;
        else return 1;
    }
}