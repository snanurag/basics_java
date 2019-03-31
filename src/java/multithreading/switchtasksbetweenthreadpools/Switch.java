package multithreading.switchtasksbetweenthreadpools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Switch {

    static ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    static ThreadPoolExecutor executor2 = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> q1 = executor1.getQueue();
        BlockingQueue<Runnable> q2 = executor2.getQueue();

        while(true){
            executor1.execute(ThreadPool1.r);
            executor2.execute(ThreadPool2.r);

            Thread.sleep(50);
            while (q1.size() > 10 && q2.size() < 5) {
                System.out.println("Shuffle");
                try {
                    q2.put(q1.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
