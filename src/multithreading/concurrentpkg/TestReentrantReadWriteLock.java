package multithreading.concurrentpkg;

/**
 * Run it many times.
 * 
 * Before any reader starts, it checks if any writer is queued. 
 * If any writer is queued then writer would be given preference. 
 * But if any reader is already started then a writer can not be started. 
 * Any Reader Thread which is started after Writer Thread would be parked till Writer Thread doesn't complete
 * 
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReentrantReadWriteLock {

	static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static Lock rLock = readWriteLock.readLock();
	static Lock wLock = readWriteLock.writeLock();

	public static void main(String[] args) {
		new ReaderThread1().start();
		new ReaderThread2().start();
		new WriterThread1().start();
		new ReaderThread2().start();
		new ReaderThread3().start();
	}

	static class ReaderThread1 extends Thread {
		@Override
		public void run() {
			/*
			 * TODO Try to run it with commenting and not commenting the sleep.
			 * This way, race condition can be observed with Writer1 Thread.
			 */
			rLock.lock();
			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			System.out.println("Reader thread 1 done");
			rLock.unlock();

		}
	}

	static class ReaderThread2 extends Thread {
		@Override
		public void run() {
			rLock.lock();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Reader thread 2 done");
			rLock.unlock();
		}
	}

	static class WriterThread1 extends Thread {
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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			wLock.lock();
			System.out.println("Writer thread 1 done");
			wLock.unlock();
		}
	}

	static class ReaderThread3 extends Thread {
		@Override
		public void run() {
			/**
			 * This 2000 value of sleep ensures that the Reader Thread 3 takes
			 * lock after Writer has acquired write lock.
			 */
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rLock.lock();

			System.out.println("Reader thread 3 done");
			rLock.unlock();
		}
	}

}
