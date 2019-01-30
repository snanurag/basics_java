package nio.channels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NIOvsIOThreadPool {

    static class Task implements Runnable {

        public void run()  {

            File f = new File("/Users/anuragshrinagar/Documents/workspace/Quora-Insincere-word-challenge/input/embeddings/glove.840B.300d/glove.840B.300d.txt");

            System.out.println("File channel Reading");

            FileInputStream fi = null;
            try{
                fi = new FileInputStream(f);
            }
            catch (FileNotFoundException e){

            }

            FileChannel fc = fi.getChannel();

            ByteBuffer bbf = ByteBuffer.allocate(100000);

            long time = System.currentTimeMillis();
            System.out.println("start time "+time);
            try{
                while (fc.read(bbf) != -1) {
                    bbf.clear();
                }
                System.out.println(time - System.currentTimeMillis());

                fc.close();
                fi.close();
            }
            catch (IOException e){

            }

        }
    }

    static class TaskIO implements Runnable {

        public void run()  {

            File f = new File("/Users/anuragshrinagar/Documents/workspace/Quora-Insincere-word-challenge/input/embeddings/glove.840B.300d/glove.840B.300d.txt");

            System.out.println("InputStream Reading");

            FileInputStream fi1 = null;
            try{
                fi1 = new FileInputStream(f);
            }
            catch (FileNotFoundException e){

            }

            byte[] b = new byte[100000];

            long time = System.currentTimeMillis();
            try {
                while (fi1.available() != 0) {
                    fi1.read(b);
                }
                System.out.println(time - System.currentTimeMillis());

                fi1.close();
            }
            catch (IOException e){

            }
        }
    }

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
//        for(int i=0; i < 20; i++){
//            Task t = new NIOvsIOThreadPool.Task();
//            threadPoolExecutor.execute(t);
//        }
//        threadPoolExecutor.shutdown();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for(int i=0; i < 20; i++){
            TaskIO t = new NIOvsIOThreadPool.TaskIO();
            threadPoolExecutor.execute(t);
        }
        threadPoolExecutor.shutdown();

    }
}