package instantiation;

public class StaticfuncOverriding {

    public static void main(String[] args) {
        C.x();
    }

}

class B {

    public static void x() {
        y();
    }

    public static void y() {
        System.out.println("B");
    }
}

class C extends B {
    public static void y() {
        System.out.println("C");
    }
}