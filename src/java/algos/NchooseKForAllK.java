package algos;

public class NchooseKForAllK {

    private static void subString(String initialString, String testString) {

        System.out.println("Sub String: " + initialString);

        for (int i = 0; i < testString.length(); i++)

            subString(initialString + testString.charAt(i),
                    testString.substring(i + 1));
    }

    public static void main(String[] args) {

        String s = "abcd";
        subString("", s);
    }

}
