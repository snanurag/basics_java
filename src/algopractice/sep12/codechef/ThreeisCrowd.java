package algopractice.sep12.codechef;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThreeisCrowd {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    private static long[] resultStore = new long[51];

    public static void main(String[] args) throws IOException {

        inputStream = new FileInputStream(new File("in2.txt"));

        String line = readLine();

        Integer totalCases = Integer.parseInt(line);

        for (int i = 0; i < totalCases; i++) {

            line = readLine();

            Integer testCase = Integer.parseInt(line);

            long l = recursiveFunc(testCase);
            l = (long) Math.pow(2, testCase) - l;
            System.out.println(l);

        }
    }

    private static long recursiveFunc(int n) {

        if (resultStore[n] == 0 && n > 2) {
            resultStore[n] = recursiveFunc(n - 1) + recursiveFunc(n - 2)
                    + recursiveFunc(n - 3);
            return resultStore[n];
        } else {
            if (n > 2) {
                return resultStore[n];
            } else if (n == 2) {
                return 4;
            } else if (n == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    private static String readLine() throws IOException {

        String str = null;

        if (counter == 8192 || counter == 0) {
            b = new byte[8192];
            inputStream.read(b);
        }

        while (true) {

            if (counter != 8192) {
                char c = (char) b[counter];
                counter++;
                if (c != '\n' && c != 0) {
                    buff.append(c);
                } else {

                    str = buff.toString();
                    buff = new StringBuffer();
                    return str.trim();
                }
            } else {
                b = new byte[8192];
                inputStream.read(b);
                counter = 0;
            }
        }
    }

}
