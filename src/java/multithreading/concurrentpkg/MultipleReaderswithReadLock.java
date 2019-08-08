package multithreading.concurrentpkg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultipleReaderswithReadLock {

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock rLock = readWriteLock.readLock();

    public static void main(String[] args) {
        new ReaderThread().start();
        new ReaderThread().start();
    }


    static class ReaderThread extends Thread {
        @Override
        public void run() {
            rLock.lock();
            System.out.println("Before Sleep 1 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 1 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 2 "+Thread.currentThread().getName());
            rLock.unlock();
        }

    }

}
