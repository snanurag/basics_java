package algopractice;

public class FlipKartPrintBracketsPNC2 {

    static int n = 4;

    public static void main(String[] args) {
        func("", 0, 0);
    }

    private static void func(String str, int o, int c) {
        if (c < o)
            func(str + ")", o, c + 1);
        if (o < n)
            func(str + "(", o + 1, c);

        if (o == n && c == n)
            System.out.println(str);
    }
}
