package inheritance;

public interface Interface1 {
    static void staticMethod1() {
        System.out.println("I am from static method 1");

    }

    default void method1() {
        System.out.println("I am from Interface 1 -> method 1");
//        privateMethod1();
    }

    default void method2() {
        System.out.println("I am from method 2");
    }

    //This functionality was enabled specifically in Java 9
//    private void privateMethod1() {
//        System.out.println("I am from private method 1");
//    }

}
