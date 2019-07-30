package inheritance;

/**
 * Java 9 feature.
 */
public interface Interface4 {
    private void printPrivate(){

    }

    default void printDefault(){
        printPrivate();
    }
}
