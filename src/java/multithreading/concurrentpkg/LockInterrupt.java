package multithreading.concurrentpkg;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Benefit 1 : lockInterruptibly doesn't wait for sleep or wait to occur to interrupt the thread.
 * Benefit 2 : Don't need to write lock snippet in one block. Can move the lock object anywhere in call hierarchy.
 * Benefit 3 : Got a shared read lock and exclusive write lock objects.
 *
 */
public class LockInterrupt {
    static    ReentrantLock lock = new ReentrantLock();
    public static void tryInterruptibly() {

        try{
            lock.lockInterruptibly();
            int i = 0;
            while(i != Integer.MAX_VALUE){
                i++;
            }
        }
        catch (InterruptedException e){
            System.err.println("Intterupt exception : "+e.getMessage());
        }
        finally {
            System.out.println("Is any lock on hold "+lock.getHoldCount());
        }
    }

    public static void tryWithoutInterruptibly() {

        try{
            lock.lock();
            int i = 0;
            while(i != Integer.MAX_VALUE){
                i++;
            }
        }
        finally {
            System.out.println("Is any lock on hold "+lock.getHoldCount());
            lock.unlock();
        }
    }

    public static void interruptSleep() {

        try{
            lock.lock();
            int i = 0;
            while(i != Integer.MAX_VALUE){
                i++;
            }
            Thread.sleep(100);
        }
        catch (InterruptedException e){
            System.err.println("Intterupt exception : "+e.getMessage());
        }
        finally {
            System.out.println("Is any lock on hold "+lock.getHoldCount());
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        // TODO: Try all three methods here. lockInterruptibly doesn't wait for sleep or wait to occur to interrupt the thread.
        // It Interrupts normal running thread and releases the lock too.
        Runnable r = () -> tryInterruptibly();
//        Runnable r = () -> tryWithoutInterruptibly();
//        Runnable r = () -> interruptSleep();

        Thread t = new Thread(r);
        t.start();
        t.interrupt();

    }

}
