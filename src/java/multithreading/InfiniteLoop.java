package multithreading;

/**
 * See the CPU usage. On macbook, you can use htop. It shows that 7 cores are busy. CPU usage is 700%.
 * This proves that JVM is a multi-core process.
 */

public class InfiniteLoop {

    public static void main(String[] args) {
        Runnable r = () -> {while(true){}};

        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }


}
