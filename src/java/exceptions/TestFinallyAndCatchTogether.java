/*
 * http://stackoverflow.com/questions/4625650/object-reference-set-to-null-in-finally-block
 *
 * Read from the above link.
 */

package exceptions;

public class TestFinallyAndCatchTogether {

    private static int value = 1;

    public static void main(String[] args) {
        TestFinallyAndCatchTogether c = new TestFinallyAndCatchTogether();
        System.out.println(c.setName());
        System.out.println(getValue());
    }

    public static int getValue() {
        try {
            value = value + 1;
            return value;
        } catch (Exception e) {
            return 0;
        } finally {
            value = value + 1;
            System.out.println("final value " + value);

        }
    }

    public int setName() {
        try {
            return 2;
        } catch (Exception e) {
            return 3;
        } finally {
            return 4;
        }
    }
}
