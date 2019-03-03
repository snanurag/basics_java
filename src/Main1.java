import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    static HashSet pr, npr;

    public static void main(String[] args) {

        int T, casecnt, x, y;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (casecnt = 0; casecnt < T; casecnt++) {
            x = sc.nextInt();
            y = sc.nextInt();
            int ret = -1;
            long n2 = num(x, y);
            if (isPrime(n2))
                ret = 0;

            for (int i = 1; ret == -1; i++) {
                int x1, x2, x3, x4, y1, y2, y3, y4;
                x1 = x + i;
                x2 = x;
                x3 = x - i;
                x4 = x;
                y1 = y;
                y2 = y + i;
                y3 = y;
                y4 = y - i;
                for (int j = 0; j <= i && ret == -1; j++) {
                    //First Quadrant
                    long n1 = num(x1, y1);
                    if ((n1 % 2) == 0)
                        break;

                    if (isPrime(n1)) {
                        ret = i;
                        break;
                    }
                    x1--;
                    y1++;

                    //Second Quadrant
                    n1 = num(x2, y2);
                    if (isPrime(n1)) {
                        ret = i;
                        break;
                    }
                    x2--;
                    y2--;

                    // Third Quadrant
                    n1 = num(x3, y3);
                    if (isPrime(n1)) {
                        ret = i;
                        break;
                    }
                    x3++;
                    y3--;

                    // Fourth Quadrant
                    n1 = num(x4, y4);
                    if (isPrime(n1)) {
                        ret = i;
                        break;
                    }
                    x4++;
                    y4++;
                }
            }
            ret = Math.min(ret, Math.abs(x - 1) + Math.abs(y - 1));
            System.out.println(ret);
        }
    }

    static boolean isPrime(long n1) {
        if (n1 == 1 || n1 == 0)
            return false;
        if (n1 == 2 || n1 == 3 || n1 == 5)
            return true;
        if ((n1 - 1) % 6 != 0 && (n1 + 1) % 6 != 0)
            return false;
        Long l = n1;
        BigInteger b = new BigInteger(l.toString());
        return b.isProbablePrime(10);
    }

    static long num(int x, int y) {

        if (x == 0 && y == 0) {
            return 0;
        }

        long xMod = Math.abs(x);

        long yMod = Math.abs(y);

        long insideBox;

        if (xMod > yMod) {
            insideBox = xMod;
        } else {
            insideBox = yMod;
        }

        long totalInsideBox = (2 * (insideBox - 1) + 1)
                * (2 * (insideBox - 1) + 1);

        long extraCells;

        if (xMod > yMod) {
            if (x > 0) {
                extraCells = xMod + y;
            } else {
                extraCells = 2 * xMod;
                extraCells += 2 * xMod;
                extraCells += xMod - y;
            }
        } else if (yMod > xMod) {
            if (y > 0) {
                extraCells = 2 * yMod;
                extraCells += yMod - x;
            } else {
                extraCells = 2 * yMod;
                extraCells += 2 * yMod;
                extraCells += 2 * yMod;
                extraCells += yMod + x;
            }
        } else {
            if (x > 0 && y > 0) {
                extraCells = 2 * xMod;
            } else if (x < 0 && y > 0) {
                extraCells = 2 * xMod;
                extraCells += 2 * xMod;
            } else if (x < 0 && y < 0) {
                extraCells = 2 * xMod;
                extraCells += 2 * xMod;
                extraCells += 2 * xMod;
            } else {
                extraCells = 2 * xMod;
                extraCells += 2 * xMod;
                extraCells += 2 * xMod;
                extraCells += 2 * xMod;
            }

        }

        long cellNo = totalInsideBox + extraCells;
        return cellNo - 1;

    }
}