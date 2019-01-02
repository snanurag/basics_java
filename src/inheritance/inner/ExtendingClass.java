package inheritance.inner;

import inheritance.Interface1;

public class ExtendingClass implements Interface1 {
    public static void main(String[] args) {
        new ExtendingClass().method1();
        Interface1.staticMethod1();


    }
}
