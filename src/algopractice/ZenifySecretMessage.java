package algopractice;

public class ZenifySecretMessage {

    public static void main(String[] args) {
	String[] words = {"abc", "abcba", "abcd"};
	System.out.println(encrypt(words));
    }
    static int[] encrypt(String[] words) {

	int[] out = new int[words.length];

	for (int j=0; j <words.length; j++ ) {
	    
	    String s = words[j]; 
	    
	    int mid = 0;
	    int opt =0;
	    
	    if(s.length()== 1)
		out[j] = 0;
	    
	    if (s.length() % 2 == 0) {
		mid = s.length() / 2 - 1;
	    } else {
		mid = s.length() / 2;
	    }

	    for (int i = s.length() - 1; i > mid; i--) {
		int index = (s.length()-1) - i;
		
		opt += Math.abs(s.charAt(i) - s.charAt(index));
	    }
	    
	    out[j] = opt;
	}
	
	return out;
    }
}
