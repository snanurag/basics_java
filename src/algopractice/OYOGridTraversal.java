package algopractice;
/*
There is a grid of m x n which has any random number of coins in any sell. Have to start from the any column of first row and traverse downward.
Can traverse to only down, left-down or right-down cell. Find the complete traversal path till the last row that returns maximum sum of coins.
 */
import java.util.ArrayList;
import java.util.List;

public class OYOGridTraversal {

    public static void main(String[] args) {
        int[][] grid = new int[10][10];

        grid[3][4] = 2;
        traversal(grid);

    }

    public static void traversal(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0)
            return;
        List l = new ArrayList();
        int[][] sumGrid = new int[grid.length][grid[0].length];
        int maxSum = 0;
        for (int parentcolId = 0; parentcolId < grid[0].length; parentcolId++) {
            int childRow = 1;

            int sumTillNow = grid[0][parentcolId];

            while (childRow < grid.length) {

                int tmp = 0;

                for (int j = parentcolId - 1; j <= parentcolId + 1; j++) {

                    if (j < 0 || j >= grid[0].length)
                        continue;
                    if (sumGrid[childRow][j] == 0 || sumGrid[childRow][j] < sumTillNow + grid[childRow][j]) {
                        sumGrid[childRow][j] = sumTillNow + grid[childRow][j];
                        if (tmp < sumTillNow + grid[childRow][j]) {
                            tmp = sumTillNow + grid[childRow][j];
                            parentcolId = j;
                        }
                        sumTillNow = tmp;
                    } else
                        continue;
                }
                childRow++;
            }

            if (maxSum < sumTillNow) maxSum = sumTillNow;
        }
        System.out.println("Max sum " + maxSum);
    }
}
