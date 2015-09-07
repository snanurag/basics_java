package algopractice.oct12.codechef;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LittleElephant {

    private static Scanner scanner;

    private static String A;
    private static String B;
    // private static int A7;
    // private static int B7;
    // private static int A4;
    // private static int B4;
    // private static int A98;
    // private static int B98;
    // private static int A65;
    // private static int B65;
    // private static int A321;
    // private static int B321;
    private static int[] P7 = new int[2];
    private static int[] P4 = new int[2];
    private static int[] P98 = new int[2];
    private static int[] P65 = new int[2];
    private static int[] P3210 = new int[2];

    public static void main(String[] args) throws IOException {
	// System.out.println(System.currentTimeMillis());
	scanner = new Scanner(new File("in.txt")).useDelimiter("\n");
	String line = scanner.next().trim();

	Integer totalCases = Integer.parseInt(line);

	for (int i = 0; i < totalCases; i++) {
	    A = scanner.next().trim();
	    B = scanner.next().trim();

	    storeNumbers(A, 0);
	    storeNumbers(B, 1);
	    System.out.println(makeOutputString());
	    makeAllVariablesToZero();
	}
	// System.out.println(System.currentTimeMillis());
    }

    private static void storeNumbers(String P, int index) {

	for (int i = 0; i < P.length(); i++) {
	    switch(P.charAt(i)){
	    case '7': P7[index]++;  break;
	    case '4' : P4[index]++; break;
	    case '3' : 
		case '2' : 
		    case '1' : 
			case '0' : P3210[index]++; break;
	    case '8' : 
		case '9' : P98[index]++; break;
	    case '5' : 
		case '6' : P65[index]++; break;
	    }
	}
    }
    
    private static String makeOutputString(){
	
	StringBuffer buff = new StringBuffer();
	
	//writing 7 first
	while(P7[0] > 0 && P65[1] > 0){
	    buff.append("7");
	    P7[0]--;
	    P65[1]--;
	}
	while(P7[0] > 0 && P3210[1] > 0){
	    buff.append("7");
	    P7[0]--;
	    P3210[1]--;
	}
	while(P7[0] > 0 && P4[1] > 0){
	    buff.append("7");
	    P7[0]--;
	    P4[1]--;
	}
	while(P7[1] > 0 && P65[0] > 0){
	    buff.append("7");
	    P7[1]--;
	    P65[0]--;
	}
	while(P7[1] > 0 && P3210[0] > 0){
	    buff.append("7");
	    P7[1]--;
	    P3210[0]--;
	}
	while(P7[1] > 0 && P4[0] > 0){
	    buff.append("7");
	    P7[1]--;
	    P4[0]--;
	}
	while(P7[0] > 0 && P7[1] > 0){
	    buff.append("7");
	    P7[0]--;
	    P7[1]--;
	}

	
	//writing 4 second
	while(P4[0] > 0 && P3210[1] > 0){
	    buff.append("4");
	    P4[0]--;
	    P3210[1]--;
	}
	while(P4[1] > 0 && P3210[0] > 0){
	    buff.append("4");
	    P4[1]--;
	    P3210[0]--;
	}
	while(P4[0] > 0 && P4[1] > 0){
	    buff.append("4");
	    P4[0]--;
	    P4[1]--;
	}

	return buff.toString();
	
    }
    
    
    private static void makeAllVariablesToZero(){
	    P7 = new int[2];
	    P4 = new int[2];
	    P98 = new int[2];
	    P65 = new int[2];
	    P3210 = new int[2];
	
    }
}
