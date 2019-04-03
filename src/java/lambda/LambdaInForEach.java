package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaInForEach {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        l.forEach(System.out::println);
        l.forEach(n -> System.out.println(n));
    }
}
