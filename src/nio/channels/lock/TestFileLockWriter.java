package nio.channels.lock;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class TestFileLockWriter {
	
	public static void main(String[] args) throws Exception{
		FileChannel ch = new RandomAccessFile(new File("test.txt"), "rw").getChannel();
		System.out.println("before lock TestFileLockWriter");
		FileLock lock = ch.lock(0, Long.MAX_VALUE, false);
		System.out.println("after lock TestFileLockWriter");
		Thread.sleep(1000000);
		lock.release();

	}

}
