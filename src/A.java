import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import j\u0061v\u0061.util.concurrent.TimeUnit;

public class A {


s}

class Task implements Callable<String>
{
    @Override
    public String call() throws Exception {
	System.out.println("Executing the call method.");
	return "return from here...";
    }
}

