package algos;

public class PrintAllnCr {

    static char[] c = {'a', 'b'};

    private static void subString(String initialString, String testString) {

        System.out.println("Sub String: " + initialString);

        for (int i = 0; i < testString.length(); i++)

            subString(initialString + testString.charAt(i),
                    testString.substring(i + 1));
    }

    public static void main(String[] args) {

        String s = "abcd"; // this
        // can
        //subString("", s);

        subString(0, 0, 0, 0);

    }

    private static void subString(int start, int end, int start2, int end2) {

        for (int i = start; i < end; i++) {
            System.out.print(c[i]);
        }
        System.out.println();

        for (int i = 0; i < c.length; i++) {
            subString(start, i + 1, i + 2, c.length);
        }
    }
}
