package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureUse {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> f = executorService.submit(() -> {
            Thread.sleep(10000);
            return "hello";
        });
        executorService.shutdown();
        System.out.println(f.get());
        System.out.println("Got future");


    }

}
