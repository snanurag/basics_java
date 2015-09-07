package algopractice;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ChefDream {

    public static void main(String[] args) throws IOException {
	StringBuffer sb = new StringBuffer();
	boolean firstLine = true;
	int totalAssistants = 0;
	boolean haveBeenInside = false;
	
	InputStream inputStream = new FileInputStream(new File("in.txt"));
	BufferedInputStream bufferedInputStream = new BufferedInputStream(
		inputStream);
	int n = 0;
	int k = 0;
	while (true) {
	    char b = (char) bufferedInputStream.read();

	    if (b != '\n' && b != -1 && bufferedInputStream.available() > 0) {
		sb.append(b);

	    } else {
		String tempString = sb.toString();
		String[] dishArray = tempString.split(" ");

		if (firstLine) {
		    n = Integer.valueOf(dishArray[0]);
		    k = Integer.valueOf(dishArray[1].trim());
		    firstLine = false;
		} else {
		    int[] cookedArray = new int[dishArray.length];

		    for (int i = 0; i <= n - k; i++) {
			for (int j = i; j < i + k; j++) {
			    if (dishArray[i].equals(dishArray[j])
				    && cookedArray[j] == 0) {

				cookedArray[j] = 1;
				haveBeenInside = true;
			    }
			}
			totalAssistants++;
		    }

		    System.out.println(totalAssistants);
		    firstLine = true;
		    n = 0;
		    k = 0;
		}
		sb = new StringBuffer();
	    }
//	    System.out.print(b);
	    if (bufferedInputStream.available() == 0)
		break;
	}

    }

}
