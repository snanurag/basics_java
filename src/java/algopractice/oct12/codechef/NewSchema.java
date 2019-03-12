package algopractice.oct12.codechef;

import java.io.IOException;
import java.io.InputStream;

public class NewSchema {

    /**
     * p = 3^(n-3)-3^(n-4)+3^(n-5).....3^1 = no. cases for identical elements at
     * n-1 and 1 position
     * <p>
     * q= 3^(n-2)-p => no. of cases for different elements at n-1 and 1 position
     * <p>
     * total no. = (p*3+q*2)*4 => for each p there are 3 elements at n position
     * and for each q there are 2 elements at n position
     * <p>
     * total no. = 3^n-3(-1)^n-3 for n > 3
     */


    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {

        inputStream = System.in;

        String line = readLine();

        Integer totalCases = Integer.parseInt(line);

        for (int i = 0; i < totalCases; i++) {

            line = readLine();

            Integer testCase = Integer.parseInt(line);
            if (testCase == 2) {
                System.out.print("12");
            } else if (testCase == 3) {
                System.out.print("24");
            } else {
                System.out.print(getResult(testCase));
            }
            if (i != totalCases - 1)
                System.out.print('\n');
        }
    }


    private static long getResult(int testCase) {
        long result = 0;
        if (testCase % 2 == 0)
            result = (pow(3, testCase) + 3) % 1000000007;
        else
            result = (pow(3, testCase) - 3) % 1000000007;
        if (result < 0) {
            return 1000000007 - result;
        } else {
            return result;
        }
    }

    private static long pow(long i, long p) {
        long l = i;
        long pow = 1;
        long halfp = p / 2;
        if (p == 0) {
            return 1;
        }
        if (p == 1) {

            return i;
        }

        while (true) {

            if (l > 1000000007)
                l = l % 1000000007;
            l *= l;

            if (l > 1000000007)
                l = l % 1000000007;
            pow += pow;

            if (pow >= halfp) {
                return (l * pow(i, p - pow)) % 1000000007;
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
