package reflection.constructor;

public class Singleton {

    static {
        System.out.println("anurag in static block");
    }

    {
        System.out.println("anurag in instance block");
    }

    private Singleton() {

    }

    public static void methodB() {
        System.out.println("anurag inside methodB");
        ;
    }

    public void methodA() {
        System.out.println("anurag in methodA");
    }
}
