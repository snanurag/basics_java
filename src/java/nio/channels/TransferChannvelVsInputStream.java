package nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class TransferChannvelVsInputStream {


    public static void main(String[] args) throws Exception {
        useNormalIO();
        useFileChannel();
    }

    private static void useNormalIO() throws Exception {
        File file = new File("/Users/anuragshrinagar/Documents/workspace/java_basic_examples/src/BufferReadervsNIOChannel.txt");
        File oFile = new File("test1.txt");

        long time1 = System.currentTimeMillis();
        InputStream is = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(oFile);
        byte[] buf = new byte[64 * 1024];
        int len = 0;
        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.flush();
        fos.close();
        is.close();
        long time2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (time2 - time1) + " ms");
    }

    private static void useFileChannel() throws Exception {
        File file = new File("/Users/anuragshrinagar/Documents/workspace/java_basic_examples/src/BufferReadervsNIOChannel.txt");
        File oFile = new File("test2.txt");

        long time1 = System.currentTimeMillis();
        FileInputStream is = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(oFile);
        FileChannel f = is.getChannel();
        FileChannel f2 = fos.getChannel();


        //  Direct transfer

//        f.transferTo(0, f.size(), f2);


        ByteBuffer buf = ByteBuffer.allocateDirect(64 * 1024);
        long len = 0;
        while ((len = f.read(buf)) != -1) {
            buf.flip();
            f2.write(buf);
            buf.clear();
        }

        f2.close();
        f.close();
        is.close();
        long time2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (time2 - time1) + " ms");
    }
}

