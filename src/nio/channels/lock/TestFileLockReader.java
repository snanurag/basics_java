package nio.channels.lock;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TestFileLockReader {

	
	public static void main(String[] args) throws Exception {
		FileChannel ch = new RandomAccessFile(new File("test.txt"), "r").getChannel();
		System.out.println("before lock TestFileLockReader");
		FileLock lock = ch.lock(0, Long.MAX_VALUE, true);
		System.out.println("after lock TestFileLockReader");
		Thread.sleep(1000000);
		lock.release();

	}
}
