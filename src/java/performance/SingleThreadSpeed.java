package performance;

//This is giving too much time because this is not the right way of bench-marking java. It should be compiled with JIT, warmed up and benchmarked using JMH

public class SingleThreadSpeed {
    public static void main(String[] args) {
        double x = 0;
        double limit = 1000000000.0;
        //Warm-up
        for (double i = 0; i < limit; i++) x += 1;
        for (double i = 0; i < limit; i++) x += 1;
        for (double i = 0; i < limit; i++) x += 1;
        for (double i = 0; i < limit; i++) x += 1;
        x = 0;
        long start = System.currentTimeMillis();
        for (double i = 0; i < limit; i++) x += 1;
        long end = System.currentTimeMillis();
        System.out.println(x);
        System.out.println("Total time spent " + (end - start));
    }
}
