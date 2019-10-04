package algos;

public class KMP {

    static boolean match(String main, String sub) {
        int[] pi = makePI(sub);
        int j = 0;
        int i = 0;
        int len = main.length();
        while (i < len) {
            if (main.charAt(i) == sub.charAt(j)) {
                j++;
                if (j == sub.length())
                    return true;
            } else if(j!=0){
                j = pi[j - 1] - 1;
                //TODO: this needs to be removed. Think of proper logic.
                if(j <0)
                    j = 0;
                continue;
            }

            i++;
        }
        return false;
    }

    static int[] makePI(String sub) {
        int pi[] = new int[sub.length()];
        pi[0] = 0;
        int j = 0;
        int i = 1;
        while(i <sub.length())
            if(sub.charAt(j) == sub.charAt(i))
            {
                pi[i] = j+1;
                j++;i++;
            }
            else if(j!=0){
                j = pi[j-1];
            }
            else{
                i++;
        }
        return pi;
    }

    public static void main(String[] args) {
//        System.out.println(match("ab", "ab"));
//        System.out.println(match("abab", "abab"));
//        System.out.println(match("abax", "abab"));
        System.out.println(match("aabaabaaaa", "aabaabaaax"));
//                                               010123452
//        System.out.println(match("", "ababaa"));
        System.out.println(match("aabaab", "abaaa"));
//                                                     010122
    }
}
