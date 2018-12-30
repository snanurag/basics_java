package generics;

import java.util.ArrayList;
import java.util.List;

public class SuperandExtends {

    public static void main(String[] args) {
	
//	List<Integer> l = new ArrayList<Number>(); This gives error but not the code below.
	
	List<? super Integer> l2 = new ArrayList<Number>();

//	l2.add((Number)1); You can add Integer or subclass of integer because super only guarantees Integer. There is no reading guarantee because, it might be pointing to Number or Object.

	l2.add(1);
	
	List<? extends Number> l3 = new ArrayList<Integer>();
//	l3.add((Integer)1);		can't add anything to list because it doesn't guarantee that actually which instance is being added too. It could be ArrayList<Integer> or ArrayList<Double>. It only guarantees reading.
//		l3.add((Number)1);
	
	List<? super Number> l4 = new ArrayList<Number>();
	l4.add(1);
    }
}
