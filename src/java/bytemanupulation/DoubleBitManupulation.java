package bytemanupulation;

import javax.sound.midi.Soundbank;

public class DoubleBitManupulation {
    public static void main(String[] args) {
        System.out.println(Double.toHexString(1));
        System.out.println(Double.toHexString(Math.pow(2,1023)));
        System.out.println(Double.toHexString(Math.pow(2,1024)));
        System.out.println(Double.toHexString(5));
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.toHexString(Double.MAX_VALUE));
        System.out.println(Double.doubleToLongBits(Double.MAX_VALUE));
    }
}
