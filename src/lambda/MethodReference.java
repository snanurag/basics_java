package lambda;


public class MethodReference {
    public void myMethod(){
        System.out.println("Instance Method");
    }
    public static void main(String[] args) {
        MethodReference obj = new MethodReference();
        MyInterface ref0 = () -> obj.myMethod();
        // Method reference using the object of the class
        // This is a shorthand of lambda. The above lambda function could be represented like the below one too.
        MyInterface ref = obj::myMethod;
        // Calling the method of functional interface
        ref.display();

        MyInterface2 ref2 = Hello::new;
    }
}