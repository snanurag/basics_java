package inheritance.inner;

/**
 * Java 9 feature.
 */
public interface Interface4 {
    private void printPrivate(){
        System.out.println("from private method");
    }

    default void printDefault(){
        System.out.println("from default method");
        printPrivate();
    }
}
