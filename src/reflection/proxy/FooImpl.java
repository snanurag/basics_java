package reflection.proxy;

public class FooImpl implements Foo {

    static {
        System.out.println("anurag in FooImpl static block");
    }

    public Object bar(Object obj) {

        System.out.println("proxy anurag");
        return "anu";
    }
}
