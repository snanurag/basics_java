package algopractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChefDream2 {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {

	inputStream = new FileInputStream(new File("in.txt"));
	
	long time = System.currentTimeMillis();

	int totalAssistants = 0;
	boolean haveBeenInside = false;

	int n = 0;
	int k = 0;

	String tempString = readLine();
	String[] dishArray = tempString.split(" ");

	n = Integer.valueOf(dishArray[0]);
	k = Integer.valueOf(dishArray[1].trim());

	tempString = readLine();
	dishArray = tempString.split(" ");

	int[] cookedArray = new int[n];

	for (int i = 0; i < n; i++) {
	    for (int j = i; j < i + k; j++) {
		if (j < n && dishArray[i].trim().equals(dishArray[j].trim())
			&& cookedArray[j] == 0) {

		    cookedArray[j] = 1;
		    haveBeenInside = true;
		}
	    }
	    if (haveBeenInside) {
		totalAssistants++;
		haveBeenInside = false;
	    }

	}
	System.out.println(System.currentTimeMillis() - time);
	System.out.println(totalAssistants);

    }

    private static String readLine() throws IOException {

	String str = null;


	if (counter == 8192 || counter == 0) {
	    inputStream.read(b);
	}

	while (true) {

	    if (counter != 8192) {
		char c = (char) b[counter];
		counter++;
		if (c != '\n') {
		    buff.append(c);
		} else {

		    str = buff.toString();
		    buff = new StringBuffer();
		    return str;
		}
	    } else {
		inputStream.read(b);
		counter = 0;
	    }
	}
    }
}
