package nio.channels.lock;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

/**
 * IndexAt1Starts locking with FileChannel. Run one copy of this code with arguments
 * "-w /tmp/locktest.dat" and one or more copies with "-r /tmp/locktest.dat" to
 * see the interactions of exclusive and shared locks. Note how too many readers
 * can starve out the writer. Note: The filename you provide will be
 * overwritten. Substitute an appropriate temp filename for your favorite OS.
 * <p>
 * Created April, 2002
 *
 * @author Ron Hitchens (ron@ronsoft.com)
 */
public class Writer1 {
    private static final int SIZEOF_INT = 4;
    private static final int INDEX_START = 0;
    private static final int INDEX_COUNT = 10;
    private static final int INDEX_SIZE = INDEX_COUNT * SIZEOF_INT;
    private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);
    private IntBuffer indexBuffer = buffer.asIntBuffer();
    private Random rand = new Random();
    // Write new values to the index slots
    private int idxval = 1;
    // ----------------------------------------------------------------
    private int lastLineLen = 0;

    public static void main(String[] argv) throws Exception {
        boolean writer = false;
        String filename;

        writer = true;
        filename = "b.txt";
        RandomAccessFile raf = new RandomAccessFile(filename, (writer) ? "rw"
                : "r");
        FileChannel fc = raf.getChannel();
        Writer1 lockTest = new Writer1();
        lockTest.doUpdates(fc);
    }

    void doUpdates(FileChannel fc) throws Exception {
        while (true) {
            println("trying for exclusive lock...");
            FileLock lock = fc.lock(INDEX_START, INDEX_SIZE, false);
            System.out.println("Writer " + System.currentTimeMillis());
            System.out.println(System.currentTimeMillis());
            updateIndex(fc);
            Thread.sleep(1000);
            lock.release();
            println("<sleeping>");
        }
    }

    private void updateIndex(FileChannel fc) throws Exception {

        // "indexBuffer" is an int view of "buffer"
        indexBuffer.clear();
        for (int i = 0; i < INDEX_COUNT; i++) {
            idxval++;
            println("Updating index " + i + "=" + idxval);
            indexBuffer.put(idxval);
            // Pretend that this is really hard work
        }
        // leaves position and limit correct for whole buffer
        buffer.clear();
        fc.write(buffer, INDEX_START);
    }

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