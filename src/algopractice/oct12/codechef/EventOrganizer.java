package algopractice.oct12.codechef;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EventOrganizer {

    private static int[][] map = new int[49][49];

    private static Integer finalComp = 0;

    private static Integer tmp = 0;

    private static int counter2;

    private static Scanner scanner;
    
    private static int[] highestCompForStarting = new int[49];

    private static int[] leastEndTimeForStarting = new int[49];
    
    public static void main(String[] args) throws IOException {
//	System.out.println(System.currentTimeMillis());
	scanner = new Scanner(new File("in.txt")).useDelimiter("\n");
	String line = readLine();

	Integer totalCases = Integer.parseInt(line);

	for (int i = 0; i < totalCases; i++) {

	    line = readLine();
	    int totalInputs = Integer.parseInt(line.trim());
	    // System.out.println(totalInputs);
	    map = new int[49][49];
	    for (int j = 0; j < totalInputs; j++) {
		line = readLine();
		String[] str = line.trim().split(" ");
		int initTime = Integer.parseInt(str[0]);
		// System.out.println(line);
		int endTime = Integer.parseInt(str[1]);
		int value = Integer.parseInt(str[2]);

		if (map[initTime][endTime] < value)
		    map[initTime][endTime] = value;
	    }
	    finalComp = 0;
	    tmp = 0;
	    getFinalVal(0);
	    System.out.println(finalComp);

	}
//	System.out.println(System.currentTimeMillis());
	System.out.println(counter2);
    }

    private static void getFinalVal(int startTime) {

	outer: for (int i = startTime; i < 49; i++) {

	    if (tmp == 0 && i != 0) {
		for (int j = 0; j < i; j++) {

		    if (map[j][i] != 0) {
			break outer;
		    }
		}
	    }

	    counter2++;
	    
	     for (int j = i; j < 49; j++) {
		 
		 if(highestCompForStarting[i] > map[i][j] && leastEndTimeForStarting[i] <j){
//		     System.out.println("break");
		     continue;
		 }
		 if(highestCompForStarting[i] < map[i][j] && (leastEndTimeForStarting[i] >j || leastEndTimeForStarting[i] == 0)){
		     highestCompForStarting[i] = map[i][j];
		     leastEndTimeForStarting[i] = j;
		 }
		 
		if (map[i][j] != 0) {
		    tmp += map[i][j];
		    if (finalComp < tmp) {
			finalComp = tmp;
		    }
		    getFinalVal(j);

		    tmp -= map[i][j];
		}
	    }
	}

    }

    private static String readLine() throws IOException {

	return scanner.next().trim();
    }

}
