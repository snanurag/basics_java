package designproblems.thoughtworks;

public class Util {


    public static int[] convertIntoRowCol(String s) {
        return new int[]{getRowIndex(s.charAt(0)), Integer.parseInt(s.substring(1))-1};
    }

    public static int getRowIndex(String h) {
        return getRowIndex(h.toUpperCase().toCharArray()[0]);
    }

    private static int getRowIndex(char h) {
        return h - 'A';
    }

}
