package nio.channels;

/**
 * By the comparison between InputStream and Channel, it is appeared that if the buffer size is kept low then channels are twice as fast as the input streams,
 * no matter whether input file is big or small. But if the buffer size is quite big, like 64*1024, then even for big files the performance of channel would be
 * a little slower than input streams.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFromChannelVsBufferedStream {

    public static void main(String[] args) throws IOException {

	File f = new File("/Users/anuragshrinagar/Documents/workspace/Quora-Insincere-word-challenge/input/embeddings/glove.840B.300d/glove.840B.300d.txt");

	System.out.println("File channel Reading");

	FileInputStream fi = new FileInputStream(f);

	FileChannel fc = fi.getChannel();

	ByteBuffer bbf = ByteBuffer.allocate(100000);

	long time = System.currentTimeMillis();
	while (fc.read(bbf) != -1) {
	    bbf.clear();
	}
	System.out.println(time - System.currentTimeMillis());

	fc.close();
	fi.close();

	System.out.println("InputStream Reading");

	FileInputStream fi1 = new FileInputStream(f);

	byte[] b = new byte[100000];

	time = System.currentTimeMillis();
	while (fi1.available() != 0) {
	    fi1.read(b);
	}
	System.out.println(time - System.currentTimeMillis());

	fi1.close();

    }

}
