import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class A {


}

class Task implements Callable<String>
{
    @Override
    public String call() throws Exception {
	System.out.println("Executing the call method.");
	return "return from here...";
    }
}

