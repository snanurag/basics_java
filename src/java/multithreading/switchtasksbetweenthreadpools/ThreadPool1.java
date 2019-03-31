package multithreading.switchtasksbetweenthreadpools;

public class ThreadPool1 {

    public static Runnable r = () -> {
        try {
            System.out.println("Thraed pool 1");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

}

