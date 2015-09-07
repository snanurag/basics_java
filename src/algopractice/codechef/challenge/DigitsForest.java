package algopractice.codechef.challenge;

import java.io.IOException;
import java.io.InputStream;

public class DigitsForest {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {
	
	int N = Integer.parseInt(readLine());
    
	String[] nodes = readLine().split(" ");
	
	String[][] bridges = new String[N][];
	
	for(int i =0; i<N ; i++){
	    
	    bridges[i] = readLine().split(" ");
	    
	}
	
	
	
    }
    
    private static void depthSearch(){
	
    }

    private static String readLine() throws IOException {

	String str = null;

	if (counter == 8192 || counter == 0) {
	    b = new byte[8192];
	    inputStream.read(b);
	}

	while (true) {

	    if (counter != 8192) {
		char c = (char) b[counter];
		counter++;
		if (c != '\n' && c != 0) {
		    buff.append(c);
		} else {

		    str = buff.toString();
		    buff = new StringBuffer();
		    return str.trim();
		}
	    } else {
		b = new byte[8192];
		inputStream.read(b);
		counter = 0;
	    }
	}
    }

}
