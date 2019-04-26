package bytemanupulation;

import java.util.BitSet;

public class Bitset {
    public static void main(String[] args) {
        BitSet b1 = new BitSet(10)                ;

        System.out.println(b1);
        System.out.println(b1.cardinality());
        b1.set(6);
        b1.set(0);
        System.out.println(b1.toLongArray());
        printBits(b1);

    }
    public static void printBits( BitSet b) {
        for (int i = 0; i < b.size(); i++) {
            System.out.print(b.get(i) ? "1" : "0");
        }
        System.out.println();
    }
}
