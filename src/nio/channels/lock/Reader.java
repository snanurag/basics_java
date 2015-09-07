package nio.channels.lock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.OverlappingFileLockException;

public class Reader {

	public static void main(String args[]) {
		File f = null;
		FileInputStream fi = null;
		FileChannel fc = null;
		try {
			f = new File("a.txt");
			fi = new FileInputStream(f);
			fc = fi.getChannel();
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ByteBuffer bf = ByteBuffer.allocate((int) fc.size());
			byte[] b = new byte[(int) fc.size()];
			fc.read(bf);
			bf.flip();
			bf.get(b);
			System.out.println(new String(b));
			fc.close();
		} catch (IOException e) {
			System.out.println("setting to false");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (OverlappingFileLockException eo) {
			System.out.println("setting to false");
			System.out.println(eo.getMessage());

		}
	}
}