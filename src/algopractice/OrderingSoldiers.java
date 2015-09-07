package algopractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class OrderingSoldiers {

	public static void main(String[] args) throws IOException {
		File f = new File("");
		Reader r = new FileReader(f);
		BufferedReader br = new BufferedReader(r);
		
		String firstLine = br.readLine();
	}
}
