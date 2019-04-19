package interviews.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * x 0 x 0 x
 * 0 x 0 x 0
 * x 0 x 0 x
 * 0 x 0 x 0
 * x 0 x 0 y
 * <p>
 * x 0 x
 * 0 x 0
 * x 0 y
 */
public class MinDistance {

    public void traverse(String[][] grid) {
        int[] pair = new int[4];
        int dist = Integer.MAX_VALUE;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == "x") {
                    int[] y = diamondTraversal(row, col, grid, dist);
                    if (y != null) {
                        dist = Math.abs(row - y[0]) + Math.abs(col - y[1]);
                        pair = new int[]{row, col, y[0], y[1]};
                    }
                }
            }
        }

        System.out.print("pair -> ");

        for (int i : pair) {
            System.out.print(i+" ");
        }
        System.out.println("Distance -> " + dist);
    }


    /**
     * Return only when different value found than i,j. Otherwise recursive.
     *
     * @param grid
     * @return
     */
    private int[] diamondTraversal(int row, int col, String[][] grid, int dist) {
        int l = 1;
        while (l < dist) {
            for (int i = 0; i <= l; i++) {
                int[] y = checkAllNodesAt(row, col, i,  (l - i), grid);
                if (y != null) return y;
            }
            l++;
        }
        return null;
    }

    private int[] checkAllNodesAt(int row, int col, int i, int j, String[][] grid) {

        if (row+i < grid.length && col+j < grid[0].length && grid[row+i][col+j] == "y") return new int[]{row+i, col+j};
        else if (row-i > -1 && col+j < grid[0].length && grid[row-i][col+j] == "y") return new int[]{row -i, col+j};
        else if (row+i < grid.length && col-j > -1 && grid[row+i][col-j] == "y") return new int[]{row +i, col-j};
        else if (row-i > -1 && col-j > -1 && grid[row-i][col-j] == "y") return new int[]{row -i, col-j};
        else return null;
    }

    /**
     *  x 0 x
     *  0 x 0
     *  x 0 y
     * @param args
     */
    public static void main(String[] args) {
        String[][] strings = new String[3][3];
        strings[0][0] = "x";
        strings[0][2] = "x";
        strings[1][1] = "x";
        strings[2][0] = "x";
        strings[2][2] = "y";

        new MinDistance().traverse(strings);

    }
}
