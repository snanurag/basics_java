package algopractice.oct12.codechef;

import java.io.*;
import java.util.Arrays;

/*
 class event implements Comparable{
 int start;
 int end;
 int comp;
 event(int start , int end,int comp){
 this.start = start;
 this.end = end;
 this.comp = comp;
 }
 public int compareTo(Object o){
 event temp = (event)o;
 if(start != temp.start){
 return (start - temp.start);
 }
 else{
 return (this.end - temp.end);
 }
 }
 }

 */

public class EventOrganizer3 {
    private static InputReader ir;
    private static PrintWriter pw;

    static int maxValue(int a, int b) {
        return (a > b) ? a : b;

    }

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream(new File("in.txt"));

        ir = new InputReader(is);
        pw = new PrintWriter(System.out);
        int[][] comp = new int[49][49];
        int i, j, k;
        int[][] res = new int[49][49];
        int start, end;

        int t = ir.nextInt();
        while (t > 0) {
            t--;
            // ans = 0;
            // n = ir.nextLong();
            int N = ir.nextInt();
            /*
             * schedule = new event[N]; for(i = 0 ;i<N;i++){ schedule[i] = new
             * event(ir.nextInt(),ir.nextInt(),ir.nextInt()); }
             * Arrays.sort(schedule);
             */

            for (i = 0; i <= 48; i++) {
                Arrays.fill(comp[i], 0);
            }

            for (i = 0; i < N; i++) {
                start = ir.nextInt();
                end = ir.nextInt();
                comp[start][end] = maxValue(ir.nextInt(), comp[start][end]);
            }

            for (i = 0; i <= 48; i++) {
                for (j = i; j <= 48; j++) {
                    res[i][j] = comp[i][j];
                }
            }

            for (i = 0; i <= 48; i++) {
                for (j = i; j <= 48; j++) {
                    // res[i][j] = comp[i][j];
                    for (k = i; k <= j; k++) {
                        res[i][j] = maxValue(res[i][k] + res[k][j], res[i][j]);
                    }
                }
            }
            pw.println(res[0][48]);
        }

        pw.flush();
        pw.close();
    }
}

class InputReader {
    final private int BUFFER_SIZE = 1 << 19;

    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public InputReader(InputStream in) {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String nextString() throws Exception {
        StringBuffer sb = new StringBuffer("");
        byte c = read();
        while (c <= ' ')
            c = read();
        do {
            sb.append((char) c);
            c = read();
        } while (c > ' ');
        return sb.toString();
    }

    public char nextChar() throws Exception {
        byte c = read();
        while (c <= ' ')
            c = read();
        return (char) c;
    }

    public int nextInt() throws Exception {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws Exception {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = c == '-';
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
            c = read();
        } while (c > ' ');
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws Exception {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws Exception {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}
