package interviews.logichub;

public class RegexMatch {

    public static void main(String[] args) {
        System.out.println(passed());
    }

    private static boolean passed() {
        return
                "".matches("") == match("", "") &&
                        "".matches(".*") == match("", ".*") &&
                        "a".matches("a*") == match("a", "a*")
                        &&
                        "aa".matches("a.") == match("aa", "a.")
                        &&
                        "ab".matches("a.") == match("ab", "a.")
                        &&
                        "a".matches(".*") == match("a", ".*")
                        &&
                        "ab".matches(".*") == match("ab", ".*")
                        &&
                        "abc".matches(".*") == match("abc", ".*")
                        &&
                        "abc".matches(".*c") == match("abc", ".*c")
                        &&
                        "abcd".matches("a.*d") == match("abcd", "a.*d")
                        &&
                        "abc".matches(".*d") == match("abc", ".*d")
                        &&
                        "abc".matches("a*c") == match("abc", "a*c")
                        &&
                        "abbc".matches("ab*") == match("abbc", "ab*")
                        &&
                        "abbb".matches("ab*.") == match("abbb", "ab*.")
                        &&
                        "abbc".matches("ab*.") == match("abbc", "ab*.")
                        &&
                        "mississippi".matches("mis*is*p*.") == match("mississippi", "mis*is*p*.");
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
        if (p.startsWith("*")) System.exit(1);
        if (len == 0 && pLen == 0) return true;
        if (len == 0 && p == ".*") return true;

        while (i < len && j < pLen) {
            char c = s.charAt(i);
            char pc = p.charAt(j);
            if (pc == '.') {
                i++;
                j++;
            } else if (pc == '*') {
                char prevP = p.charAt(j - 1);
                j++;
                while (i < len) {
                    c = s.charAt(i);
                    if (j < pLen && match(s.substring(i), p.substring(j)))
                        return true;
                    if (prevP != '.' && c != prevP) break;
                    i++;
                }
            } else if (c == pc) {
                i++;
                j++;
            } else return false;
        }

        if (i == len && (j == pLen || (j == pLen - 1 && p.substring(j).equals("*"))))
            return true;
        else
            return false;
    }
}
