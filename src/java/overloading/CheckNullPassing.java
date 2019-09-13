package overloading;

public class CheckNullPassing {

    public static void main(String[] args) {

        CheckNullPassing c = new CheckNullPassing();

        // Method would not be ambiguous in case of Object and just one simple
        // other argument.
//    	c.method(null);
    }

    private void method(Integer i) {
        System.out.println("In integer args");
    }

    private void method(String i) {
        System.out.println("In String parameter.");
    }

    private void method(Object o) {
        System.out.println("In Object parameter.");
    }
}
