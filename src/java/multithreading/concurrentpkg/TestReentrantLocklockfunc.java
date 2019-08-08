package multithreading.concurrentpkg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLocklockfunc {

    /**
     * @param args
     */
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        t2.start();

    }

    static class Thread1 extends Thread {

        public void run() {
            lock.lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Thread1 after aquiring lock and exit");

        }
    }

    static class Thread2 extends Thread {

        public void run() {
            lock.lock();
            System.out.println("Thread2 after aquiring lock and exit");

        }
    }


}

