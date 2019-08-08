package multithreading.concurrentpkg;

/**
 * Run it many times.
 * <p>
 * Before any reader starts, it checks if any writer is queued.
 * If any writer is queued then writer would be given preference.
 * But if any reader is already started then a writer can not be started.
 * Any Reader Thread which is started after Writer Thread would be parked till Writer Thread doesn't complete
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReentrantReadWriteLock {

    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock rLock = readWriteLock.readLock();
    static Lock wLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        new ReaderThread().start();
        new WriterThread().start();
        new ReaderThread().start();
    }


    static class ReaderThread extends Thread {
        @Override
        public void run() {
            System.out.println("Reader thread trying to acquire lock");
            rLock.lock();
            System.out.println("Reader thread acquired lock");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rLock.unlock();
            System.out.println("Reader thread released lock");
        }
    }

    static class WriterThread extends Thread {
        @Override
        public void run() {
            try {
                /*
                 * TODO try to run it with commenting the sleep and not
                 * commenting it. This way race condition can be observed with
                 * Reader1 Thread.
                 *
                 * Closed the window for entering Writer Thread.
                 */
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Writer thread trying to acquire lock");
            wLock.lock();
            System.out.println("Writer thread acquired lock");
            wLock.unlock();
            System.out.println("Writer thread released lock");

        }
    }


}
