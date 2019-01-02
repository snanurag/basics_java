package inheritance;

public interface Interface1 {
    default void method1(){
        System.out.println("I am from method 1");
        privateMethod1();
    }

    static void staticMethod1(){
        System.out.println("I am from static method 1");

    }

    private void privateMethod1(){
        System.out.println("I am from private method 1");
    }

}
