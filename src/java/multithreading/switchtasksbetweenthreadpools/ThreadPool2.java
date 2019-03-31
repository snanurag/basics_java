package multithreading.switchtasksbetweenthreadpools;

public class ThreadPool2 {
    public static Runnable r = () -> {
            System.out.println("Thraed pool 2");
    };
}
