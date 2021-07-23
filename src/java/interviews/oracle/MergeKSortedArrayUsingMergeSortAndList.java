package interviews.oracle;

import java.util.*;

public class MergeKSortedArrayUsingMergeSortAndList {
    public static int[] sort(int[][] k) {
        return sort(Arrays.asList(k));
    }

    public static int[] sort(List<int[]> k) {
        if (k.size() == 1)
            return k.get(0);
        int f = k.size();
        if (f % 2 == 1) {
            f -= 1;
        }
        int counter = 0;
        List<int[]> newList = new ArrayList<>();
        while (counter < f) {
            if (k.get(counter) != null && k.get(counter + 1) != null) {
                newList.add(sort(k.get(counter++), k.get(counter++)));
            }
        }

        if (k.size() % 2 == 1) {
            newList.add(k.get(k.size() - 1));
        }
        return sort(newList);
    }

    public static int[] sort(int[] a, int[] b) {
        int[] finalArr = new int[a.length + b.length];
        int counter = 0;
        int i, j;
        for (i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] < b[j]) {
                finalArr[counter] = a[i];
                i++;
            } else {
                finalArr[counter] = b[j];
                j++;
            }
            counter++;
        }

        while (i < a.length) {
            finalArr[counter] = a[i];
            i++;
            counter++;
        }
        while (j < b.length) {
            finalArr[counter] = b[j];
            j++;
            counter++;
        }
        return finalArr;
    }


    public static void main(String[] args) {
        int[][] k = new int[3][];

        k[0] = new int[]{4, 7, 14};
        k[1] = new int[]{3, 8, 15};
        k[2] = new int[]{5, 6, 7, 8, 13,};
        int[] f = sort(k);
        for (int i : f) {
            System.out.print(i + " ");
        }
    }
}
