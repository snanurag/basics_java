package nio.channels.lock;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

import java.nio.channels.FileLock;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * IndexAt1Starts locking with FileChannel. Run one copy of this code with arguments
 * "-w /tmp/locktest.dat" and one or more copies with "-r /tmp/locktest.dat" to
 * see the interactions of exclusive and shared locks. Note how too many readers
 * can starve out the writer. Note: The filename you provide will be
 * overwritten. Substitute an appropriate temp filename for your favorite OS.
 * 
 * Created April, 2002
 * 
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class Reader1 {
	private static final int SIZEOF_INT = 4;
	private static final int INDEX_START = 0;
	private static final int INDEX_COUNT = 10;
	private static final int INDEX_SIZE = INDEX_COUNT * SIZEOF_INT;
	private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);
	private IntBuffer indexBuffer = buffer.asIntBuffer();
	private Random rand = new Random();

	public static void main(String[] argv) throws Exception {
		boolean writer = false;
		String filename;

		writer = false;
		filename = "b.txt";
		RandomAccessFile raf = new RandomAccessFile(filename, (writer) ? "rw"
				: "r");
		FileChannel fc = raf.getChannel();
		Reader1 lockTest = new Reader1();
		lockTest.doQueries(fc);
	}

	// ----------------------------------------------------------------
	// Simulate a series of read-only queries while

	// holding a shared lock on the index area
	void doQueries(FileChannel fc) throws Exception {
		while (true) {
			println("trying for shared lock...");
			FileLock lock = fc.lock(INDEX_START, INDEX_SIZE, true);
			System.out.println("Reader " + System.currentTimeMillis());
			int reps = rand.nextInt(60) + 20;
			for (int i = 0; i < reps; i++) {
				int n = rand.nextInt(INDEX_COUNT);
				int position = INDEX_START + (n * SIZEOF_INT);
				buffer.clear();
				fc.read(buffer, position);
				int value = indexBuffer.get(n);
				println("Index entry " + n + "=" + value);
				// Pretend to be doing some work
				Thread.sleep(10000);
			}
			lock.release();
			println("<sleeping>");
		}
	}

	private int idxval = 1;

	// ----------------------------------------------------------------
	private int lastLineLen = 0;

	// Specialized println that repaints the current line
	private void println(String msg) {
		System.out.print("\r ");
		System.out.print(msg);
		for (int i = msg.length(); i < lastLineLen; i++) {
			System.out.print(" ");
		}
		System.out.print("\r");
		System.out.flush();
		lastLineLen = msg.length();
	}
}