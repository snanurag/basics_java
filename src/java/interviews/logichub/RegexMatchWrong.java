
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 *
 * Math for . and * only. * is 0 to multiple occurance of ANY character.
 */

public class RegexMatchWrong {
    public static void main(String[] args) {
        System.out.println(passed());
    }

    private static boolean passed() {
        return
                match("", "*") &&
                        !match("", ".") &&
                        match("aa", "a*") &&
                        match("aa", "*a") &&
                        match("abdbdc", "a*bd..c") &&
                        match("abdbdbdc", "a*bd..c") &&
                        match("abdbdbdc", "*a*bd..c") &&
                        match("abdebdebdec", "a*bde*c") &&
                        match("abdebdcbdcc", "a*bde*c") &&
                        !match("aebdc", "a*bd..c") &&
                        !match("abdc", "a*bd..c") &&
                        match("abdc", "a*..c") &&
                        match("mississippi", "mis*is*p*.");

    }

    /**
     * This function takes string and pattern and returns true if string matches with pattern
     *
     * @param s String
     * @param p Pattern
     * @return true if match else false
     */
    private static boolean match(String s, String p) {
        int len = s.length();
        int pLen = p.length();
        int j = 0;
        int i = 0;

        while (i < len && j < pLen) {
            char c = s.charAt(i);
            char pc = p.charAt(j);
            if (pc == '.') {
                i++;
                j++;
            } else if (pc == '*') {
                boolean mVal = false;
                do {
                    String newP = "";
                    if (j < pLen - 1)
                        newP = p.substring(j + 1);
                    else
                        return true;
                    if (i == len) break;
                    mVal = match(s.substring(i++), newP);
                }
                while (!mVal);
                return mVal;
            } else if (c == pc) {
                i++;
                j++;
            } else return false;
        }

        if (i == len && (j == pLen || p == "*")) return true;
        else return false;
    }
}
