package lambda;


public class MethodReference {
    public static void main(String[] args) {
        MethodReference obj = new MethodReference();
        MyInterface ref0 = () -> obj.myMethod();
        // Method reference using the object of the class
        // This is a shorthand of lambda. The above lambda function could be represented like the below one too.
        MyInterface ref = obj::myMethod;
        // Calling the method of functional interface
        ref.display();

        MyInterface2 ref2 = Hello::new;
        System.out.println(ref2.i);
        ref2.display("say hi");

        //This proves that a constructor also works as a lambda function and can be assigned to any functional interface function.
//        MyInterface3 ref3 = Hello::new;

        //This proves that interface doesn't need to be a functional interface.
        NonFunctionalInterface nref = Hello::new;
    }

    public void myMethod() {
        System.out.println("Instance Method");
    }
}