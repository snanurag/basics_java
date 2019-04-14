package bytemanupulation;

/**
 * Check if string has only unique characters.
 */
public class FindUniqueCharInString {

    /**
     * Basically this function is storing info in 32 bits of an int. It finds the alphabetical index of every letter and makes
     * the bit at corresponding number from right 1, using |. If any 1 reoccurs, which is checked using &, then it returns false.
     *
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueChars("abcdefghb") == false);
        System.out.println(isUniqueChars("abcdefgh") == true);
        System.out.println(isUniqueChars(("ay")));
    }
}
