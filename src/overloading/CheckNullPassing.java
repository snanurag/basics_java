package overloading;

public class CheckNullPassing {

    public static void main(String[] args) {

	CheckNullPassing c = new CheckNullPassing();

	// Method would not be ambiguous in case of Object and just one simple
	// other argument.
//	c.method(null)
    }

    private void method(Integer i) {

    }

    private void method(String i) {

    }

    private void method(Object o) {

    }
}
