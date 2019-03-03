package algopractice.codechef.easy;

import java.util.Scanner;

public class Prime {
    public static void main(String args[]) {
        int i;
        Scanner in = new Scanner(System.in);
        i = in.nextInt();/* Take input from standard input */
        if (isprime(i)) {
            System.out.println("YES");/* Print output on standard output */
        } else {
            System.out.println("NO");/* Print output on standard output */
        }
    }

    public static boolean isprime(int a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }
}
