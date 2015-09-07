/**
 * This is  just the basic logic to calculate the factors of number in efficient way. Rest could be done easily.
 */
package algopractice.sep12.codechef;

import java.util.HashMap;
import java.util.Map;

public class QueriesAboutNumbers {
   
    public static void main(String[] args) {

	System.out.println(System.currentTimeMillis());

//	for(int j =0; j<100000; j++){
//		long input = 999999999999997L;
//		factorize(input);
//	}

		for(int j =0; j<100000; j++){
		long input = 999999999999997L;
		Map<Long, Long> map = new HashMap();
		
		while(input % 2 ==0){
		    input = input/2;
		    increaseMapValue(map, 2);
		}
		
		while(input % 3 == 0){
		    input = input/3;
		    increaseMapValue(map, 3);
		}
		
		   long i =0;
			 
		while(true){
		    i++;
		    long n = 6*i-1;
		    while(input % n == 0){
			input = input/n;
			increaseMapValue(map, n);
		    }
		    
		    n = 6*i + 1;

		    while(input % n == 0){
			input = input/n;
			increaseMapValue(map, n);
		    }
		    
		    
		    if(input == 1 ){
			break;
		    }
		    if(n*n >= input){
			increaseMapValue(map, input);
			break;
		    }
		}
		
//		System.out.println(map);
	}
	System.out.println(System.currentTimeMillis());

    }
    
    
    private static void increaseMapValue(Map<Long, Long> map, long n){
	Long v = map.get(n);
	if(v == null ){
	    map.put(n, 1L);
	}
	else{
	    v = map.get(n);
	    v++;
	    map.put(n, v);
	}
    }
    
    private static void factorize(long n) {
	    // for each potential factor i
	    for (long i = 2; i * i <= n; i++) {
		// if i is a factor of N, repeatedly divide it out
		while (n % i == 0) {
		    n = n / i;
		}
	    }
	    // if biggest factor occurs only once, n > 1
	}
}
