package bytemanupulation;

public class BitConversion {
    /**
     * Write a function to determine the number of bits required to convert integer A to
     * integer B.
     * Input: 31, 14
     * Output: 2
     *
     *
     */

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(31));
        System.out.println(Integer.toBinaryString(14));
        System.out.println(Integer.toBinaryString(((31|14) - (31 &14))));


        /**
         * 29 to 14
         */
        System.out.println(Integer.toBinaryString(29));
        System.out.println(Integer.toBinaryString(14));
        System.out.println(Integer.toBinaryString(-(29 & 14)+(29|14)));

    }
}
