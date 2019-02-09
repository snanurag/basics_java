package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextendsComparableOfT implements Comparable<String>{
    
    public static <T extends Comparable<? super T>> T max(List<? extends T> list){
//	 Iterator<T> t = list.iterator(); // should be Iterator<? extends T>
	 Iterator u = list.iterator();	// It works
	 Iterator<? extends T> v = list.iterator();
	 return v.next();
    }
    
    public static void main(String[] args) {
        List<TextendsComparableOfT> t = new ArrayList<TextendsComparableOfT>();
    //	max(t);

        List<SubClassComparable> u = new ArrayList<>();

        max(u);
    }

    @Override
    public int compareTo(String o) {
        // TODO Auto-generated method stub
        return 0;
    }
}

class SubClassComparable implements Comparable<SubClassComparable>{
    
    @Override
    public int compareTo(SubClassComparable o) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}