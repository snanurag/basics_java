package io;

import java.io.*;

public class IntegertoCharAndByte {

    public static void main(String[] args) {

        try {
            PipedInputStream is = new PipedInputStream();
            OutputStream os = new PipedOutputStream(is);

            PipedReader ir = new PipedReader();
            PipedWriter iw = new PipedWriter(ir);

            iw.write(2147483000);
            iw.write(Integer.MAX_VALUE);
            os.write(2147483000);
            System.out.println(Integer.MAX_VALUE);

            int b;
//			while ((b = ir.read()) > -1) {
//				System.out.println(b);
//			}
            while ((b = is.read()) > -1) {
                System.out.println(b);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
