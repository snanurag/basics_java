import java.util.concurrent.Callable;

public class A {


}

class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Executing the call method.");
        return "return from here...";
    }
}

