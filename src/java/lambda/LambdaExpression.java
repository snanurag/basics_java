package lambda;

public class LambdaExpression {
    public static void main(String[] args) {
        MyInterface ref = () -> System.out.print("It is from sout");
        ref.display();
        MyInterface ref1 = () -> {
            System.out.print("first line call");
            System.out.println("2nd line call");
        };

    }
}
