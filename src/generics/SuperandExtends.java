package generics;

import java.util.ArrayList;
import java.util.List;

public class SuperandExtends {

    public static void main(String[] args) {
	
	List<Integer> l = new ArrayList<Number>();
	
	List<? super Integer> l2 = new ArrayList<Number>();

	l2.add((Number)1);
	
	l2.add(1);
	
	List<? extends Number> l3 = new ArrayList<Integer>();
	
	List<? super Number> l4 = new ArrayList<Number>();
	
	l4.add(1);
    }
}
