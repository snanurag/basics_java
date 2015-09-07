package generics;

import java.util.ArrayList;
import java.util.List;

public class ChangesJava7 {
    
    public void method1(){
	List<String> list = new ArrayList<>();
	list.add("A");

	  // The following statement should fail since addAll expects
	  // Collection<? extends String>
	
	list.addAll(list);

	list.addAll(new ArrayList<>());
    }

    public void method2(){
	
    }
}
