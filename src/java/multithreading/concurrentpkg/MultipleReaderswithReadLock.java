package multithreading.concurrentpkg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultipleReaderswithReadLock {

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock rLock = readWriteLock.readLock();

    public static void main(String[] args) {
        new ReaderThread1().start();
        new ReaderThread2().start();
    }


    static class ReaderThread1 extends Thread {
        @Override
        public void run() {
            rLock.lock();
            System.out.println("Before Sleep 1 ReaderThread1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 1 ReaderThread1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 2 ReaderThread1");
            rLock.unlock();
        }

    }

    static class ReaderThread2 extends Thread {
        @Override
        public void run() {
            rLock.lock();
            System.out.println("Before Sleep 1 ReaderThread2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 1 ReaderThread2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("After Sleep 2 ReaderThread2");
            rLock.unlock();
        }

    }

}
