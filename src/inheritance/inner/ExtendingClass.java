package inheritance.inner;

import inheritance.Interface1;

public class ExtendingClass implements Interface1 {
    public static void main(String[] args) {
        new ExtendingClass().method1();
        Interface1.staticMethod1();
        new ExtendingClass().method2();

    }

    @Override
    public void method2() {
        System.out.println("method 2 is overwritten");
    }
}
