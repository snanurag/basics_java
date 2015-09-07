package nio.channels.lock;

/**
 * This won't work because locks are jvm dependent and file both dependent. In single jvm it is not possible to take two locks from the same file. These locks are mainly for the synchronization of processes not threads.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.RandomAccess;

public class TestFileLocks {

	public static void main(String[] args) throws FileNotFoundException {
		FileChannel ch = new RandomAccessFile(new File("test.txt"), "rw")
				.getChannel();

		Thread t1 = new Thread1(ch);

		t1.start();

		FileChannel ch1 = new RandomAccessFile(new File("test.txt"), "rw")
				.getChannel();

		Thread t2 = new Thread2(ch1);

		t2.start();

	}

}

class Thread1 extends Thread {

	FileOutputStream fos;
	FileChannel ch;

	Thread1(FileChannel fos) {
		this.ch = fos;
	}

	@Override
	public void run() {
		try {
			System.out.println("before lock Thread1");
			FileLock lock = ch.lock(0, Long.MAX_VALUE, false);
			System.out.println("after lock Thread1");
			Thread.sleep(1000000);
			lock.release();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread2 extends Thread {

	FileOutputStream fos;
	FileChannel ch;

	Thread2(FileChannel fos) {
		this.ch = fos;
	}

	@Override
	public void run() {
		try {

			System.out.println("before lock thread 2");
			FileLock lock = ch.lock(0, Long.MAX_VALUE, false);
			System.out.println("after lock thread 2");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}