package A;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

public class B {
    static final int MAX = 16;

    public static void main(String[] args) throws Exception {
        final InputReader in = new InputReader(System.in);
        final OutputWriter out = new OutputWriter(System.out);
        long N = in.readLong();
        int Q = in.readInt();
        // PRECALC DIVISORS OF N
        Fact fn = new Fact(N);
        while (Q-- > 0) {
            int type = in.readInt();
            long qnum = in.readLong();
            switch (type) {
                case 1:
                    out.printLine(fn.map1.get(GCD(N, qnum)));
                    break;
                case 2:
                    out.printLine(N % qnum != 0 ? 0 : fn.map1.get(N / qnum));
                    break;
                case 3:
                    out.printLine(N % qnum != 0 ? fn.map1.size() : fn.map1.size()
                            - fn.map1.get(N / qnum));
                    break;
            }
        }
        out.close();
    }

    static long GCD(long a, long b) {
        long GCD = 0;
        while (b != 0) {
            GCD = b;
            b = a % b;
            a = GCD;
        }
        return GCD;
    }

    static class Fact {
        long[] divs;
        int[] counts;
        int count;
        HashMap<Long, Integer> map1;

        public Fact(long num) {
            this.count = 0;
            this.divs = new long[MAX];
            this.counts = new int[MAX];
            this.map1 = new HashMap<Long, Integer>();
            this.factorize(num);
            this.findFactors(0, 1, 1);
        }

        private void add(long i) {
            if (count == 0 || this.divs[count - 1] != i) {
                this.divs[count] = i;
                this.counts[count++] = 1;
            } else {
                this.counts[count - 1]++;
            }
        }

        private void factorize(long n) {
            // for each potential factor i
            for (long i = 2; i * i <= n; i++) {
                // if i is a factor of N, repeatedly divide it out
                while (n % i == 0) {
                    this.add(i);
                    n = n / i;
                }
            }
            // if biggest factor occurs only once, n > 1
            if (n > 1)
                this.add(n);
        }

        private void findFactors(int currentDivisor, long currentResult,
                                 int amount) {
            if (currentDivisor == this.count) {
                map1.put(currentResult, amount);
            } else {
                for (int i = 0; i <= this.counts[currentDivisor]; ++i) {
                    findFactors(currentDivisor + 1, currentResult, amount
                            * (i + 1));
                    currentResult *= this.divs[currentDivisor];
                }
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}