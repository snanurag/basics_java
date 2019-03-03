package performance;

import java.io.*;

//Both seems to have same performance.

public class ByteStreamvsCharStream {

    private static void readFromByteStream() {
        FileInputStream fi;
        int byteCounter = 0;
        try {
            fi = new FileInputStream("/home/anurag/Desktop/license.txt");
            BufferedInputStream bfi = new BufferedInputStream(fi);
            long time = System.currentTimeMillis();
            while (bfi.read() != -1)
                byteCounter++;
            System.out.println(System.currentTimeMillis() - time);
            System.out.println("byteCounter " + byteCounter);
            bfi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void readFromCharStream() {
        FileReader fr;
        int charCounter = 0;
        try {
            fr = new FileReader("/home/anurag/Desktop/license.txt");
            BufferedReader bfr = new BufferedReader(fr);
            long time = System.currentTimeMillis();
            while (bfr.read() != -1)
                charCounter++;
            System.out.println(System.currentTimeMillis() - time);
            System.out.println("charCounter " + charCounter);
            bfr.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        readFromByteStream();
        readFromCharStream();
    }

}