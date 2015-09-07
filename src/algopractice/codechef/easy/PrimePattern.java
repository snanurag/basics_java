package algopractice.codechef.easy;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class PrimePattern {

    private static int counter = 0;

    private static InputStream inputStream;

    private static byte[] b = new byte[8192];

    private static StringBuffer buff = new StringBuffer();

    public static void main(String[] args) throws IOException {

	long x;
	long y;

	inputStream = System.in;

	String totalNo = readLine();

	long totalInputs = Long.valueOf(totalNo.trim());

	for (long j = 0; j < totalInputs; j++) {

	    String input = readLine();
	    // System.out.println(input);
	    String[] inputArray = input.trim().split(" ");
	    x = Integer.valueOf(inputArray[0]);
	    y = Integer.valueOf(inputArray[1]);

	    long distance = 0;
	    outer: while (true) {

		for (long i = 0; i <= distance; i++) {

		    // case 1
		    if (isCellBlack(x + i, y + distance - i)) {
			System.out.println(distance);
			break outer;
		    }

		    // case 2
		    if (isCellBlack(x - i, y + distance - i)) {
			System.out.println(distance);
			break outer;
		    }

		    // case 3
		    if (isCellBlack(x + i, y - distance + i)) {
			System.out.println(distance);
			break outer;
		    }

		    // case 4
		    if (isCellBlack(x - i, y - distance + i)) {
			System.out.println(distance);
			break outer;
		    }
		}
		distance++;
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
		    return str;
		}
	    } else {
		b = new byte[8192];
		inputStream.read(b);
		counter = 0;
	    }
	}
    }

    private static boolean isCellBlack(long x, long y) {

	long cellNo = calculateCellNo(x, y);

	if (isprime(cellNo)) {
	    return true;
	} else {
	    return false;
	}
    }

    private static long calculateCellNo(long x, long y) {

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

    private static boolean isprime(long n1) {

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

}
