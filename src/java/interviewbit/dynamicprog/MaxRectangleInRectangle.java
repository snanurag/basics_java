package interviewbit.dynamicprog;

import java.util.ArrayList;

public class MaxRectangleInRectangle {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int biggest = 0;

        int row = 0;
        int col = 0;
        while (row < A.size() && col < A.get(0).size()) {
            int tmp = 0;


//            if((A.size() - row) * (A.get(0).size() - col) < biggest) continue;

            if (A.get(row).get(col) == 1)
                tmp = checkForRectangle(row, col, A);

            col++;

            if (col >= A.get(row).size()) {
                col = 0;
                row++;
            }

            if (tmp > biggest)
                biggest = tmp;
        }
        return biggest;
    }

    private int checkForRectangle(int row, int col, ArrayList<ArrayList<Integer>> A) {

        int i = row;
        int j = col;
        boolean rowTraversal = true;
        boolean colTraversal = true;

        while (rowTraversal && colTraversal && isCornerOne(i, j, A)) {
            rowTraversal = traverseRow(row, i, j, A);
            colTraversal = traverseCol(col, j, i, A);
            if (!rowTraversal || !colTraversal) break;
            i++;
            j++;
        }

        int sqJ = j-1;
        int sqI = i-1;

        while (rowTraversal) {
            rowTraversal = traverseRow(row, sqI, j, A);
            if(!rowTraversal) break;
            j++;
        }

        j--;

        while (colTraversal) {
            colTraversal = traverseCol(col, sqJ, i, A);
            if(!colTraversal) break;
            i++;
        }
        i--;

        int rowRect = (i - row + 1) * (sqJ - col + 1);
        int colRect = (sqI - row + 1) * (j - col + 1);

        return rowRect > colRect ? rowRect : colRect;
    }

    private boolean isCornerOne(int row, int col, ArrayList<ArrayList<Integer>> A) {
        if (row >= A.size() || col >= A.get(0).size() || A.get(row).get(col) != 1) return false;
        else return true;

    }

    private boolean traverseRow(int min, int max, int col, ArrayList<ArrayList<Integer>> A) {
        if (col >= A.get(0).size()) return false;
        while (min <= max) {
            if (A.get(min).get(col) != 1) return false;
            min++;
        }
        return true;
    }

    private boolean traverseCol(int min, int max, int row, ArrayList<ArrayList<Integer>> A) {
        if (row >= A.size()) return false;
        while (min <= max) {
            if (A.get(row).get(min) != 1) return false;
            min++;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(0);
        ArrayList<Integer> j = new ArrayList<>();
        j.add(0);
        j.add(1);

        a.add(l);
        a.add(j);

        System.out.println(new MaxRectangleInRectangle().maximalRectangle(a));
    }
}
