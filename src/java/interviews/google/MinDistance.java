package interviews.google;

import java.util.Arrays;

/**
 * x 0 x 0 x 0
 * 0 0 0 0 0 0
 * 0 0 x 0 0 0
 * 0 0 0 y 0 0
 */
public class MinDistance {

    public void traverse(String[][] grid) {
        int[] pair = new int[4];
        int dist = Integer.MAX_VALUE;
        boolean[][] markerGrid = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != null) {
                    int[] arr = startSweep(i, j, grid, markerGrid);
                    int tmp = Math.abs(i - arr[0]) + Math.abs(j - arr[1]);
                    if (tmp < dist) {
                        dist = tmp;
                        pair = new int[]{i, j, arr[0], arr[1]};
                    }
                }
            }
        }

        System.out.print("pair -> ");
        Arrays.asList(pair).forEach(n -> System.out.print(n + " "));
        System.out.println("Distance -> " + dist);
    }

    /**
     * Return only when different value found than i,j. Otherwise recursive.
     *
     * @param i
     * @param j
     * @param grid
     * @param markerGrid
     * @return
     */
    private int[] startSweep(int i, int j, String[][] grid, boolean[][] markerGrid) {
        String val = grid[i][j];
        int dist = 0;
        int x = 0;
        while (true) {
            dist++;
            x = 0;
            while (x != dist + 1) {
                int row = i + x;
                int col = j + dist - x;
                if (row < grid.length && col < grid[0].length) {
                    if (!markerGrid[row][col]) {
                        markerGrid[row][col] = true;
                        String newval = grid[row][col];
                        if (newval != null) {
                            if (newval != val) return new int[]{row,col};
                            else return startSweep(row,col, grid, markerGrid);
                        }
                        if(row == grid.length -1 && col == grid[0].length -1) return null;
                    }
                }
                x++;
            }
        }
    }
}
