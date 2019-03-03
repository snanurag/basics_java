package multithreading;

import java.util.LinkedList;
import java.util.List;

public class JoinThreads {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            int time = (10 - i) * 100;
            Runnable r = () -> {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("in join");

            };
            Thread t = new Thread(r);
            t.start();
            l.add(t);

        }
        l.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        Thread.sleep(1000);
        System.out.println("after join");
    }
}
