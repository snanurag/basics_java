package lambda;

public class LambdaExpression {
    public static void main(String[] args) {
        MyInterface ref = () -> System.out.print("It is from sout");
        ref.display();
    }
}
