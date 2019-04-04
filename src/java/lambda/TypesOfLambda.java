package lambda;

import java.util.Arrays;

//No need of interface to be functional interface. But functional interface is the definition which blocks more than one abstract functions.
public class TypesOfLambda {

    public static void main(String[] args) {
        Arrays.asList(args).forEach( s -> System.out.println(s));
        StringConcat s1 = (a,b) -> a+b;
    }
}
interface StringConcat {

    public String sconcat(String a, String b);

}