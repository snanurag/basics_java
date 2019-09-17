package lambda;


public class MethodReference {
    public static void main(String[] args) {
        MethodReference obj = new MethodReference();
        // Method reference using the object of the class
        MyInterface ref0 = () -> obj.myMethod();

        // Below is the way of method expression
        MyInterface ref = obj::myMethod;
        // Calling the method of functional interface
        ref.display();

        MyInterface2 ref2 = Hello::new;
        System.out.println(ref2.i);
        ref2.display("say hi");

        //This proves that interface doesn't need to be a functional interface.
        NonFunctionalInterface nref = Hello::new;
    }

    public void myMethod() {
        System.out.println("Instance Method");
    }
}