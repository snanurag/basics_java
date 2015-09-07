package nio.channels.lock;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

public class Writer {

	public static void main(String args[]) {
		try {
			File f = new File("a.txt");

			FileChannel fc = new RandomAccessFile(f, "rw").getChannel();
			FileLock fl = fc.lock();
			System.out.println("Locked by writer");

			long startTime = System.currentTimeMillis();
			int i = 0;
			try {
				while (System.currentTimeMillis() - startTime < 20000) {
					ByteBuffer bf = ByteBuffer.allocate(1024);
					String s = "testing" + (i++) + "\n";

					for (int j = 0; j < s.toCharArray().length; j++) {
						bf.put((byte) s.toCharArray()[j]);
					}
					bf.flip();
					fc.write(bf);
					fc.force(false);
				}

			} catch (OverlappingFileLockException e) {
				System.out
						.println("File is already locked in this thread or virtual machine");
			}
			// Release the lock
			fl.release();

			// Close the file
			fc.close();

		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

}