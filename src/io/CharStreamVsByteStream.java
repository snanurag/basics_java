package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharStreamVsByteStream {

    public static void main(String[] args) throws IOException {
	Reader r = new FileReader(new File("in2.txt"));

	// System.out.println(r.read());
	//
	// System.out.println(r.read());


	final StringBuilder stringBuilder = new StringBuilder();
	InputStream inStream = new FileInputStream("in2.txt"); // There is \u0000 written in in2.txt file
	InputStreamReader streamReader = new InputStreamReader(inStream,
		"UTF-16");
	BufferedReader bufferedReader = new BufferedReader(streamReader);

	char[] c = new char[1];
	bufferedReader.read(c);
	System.out.println("\u0000".equals(c[0]));
	System.out.println(c[0]);
    }

}
