package designproblems.thoughtworks;

public class Util {


    public static StringBuffer outBuff = new StringBuffer();

    /**
     * Returns array s which has Row index value at index 0 and Column index value at index 1.
     *
     * @param s location in string format
     * @return array of row, col.
     */
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
