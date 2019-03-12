package generics;

public class DefaultGenericisStringJdk7 {

    public static void main(String[] args) {
        MyClass<Integer> c = new MyClass<>("");
    }


}

class MyClass<X> {
    <T> MyClass(T t) {
        // ...
    }
}