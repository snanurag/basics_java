package interviews.oracle;

public class MergeKSortedArray2 {
    public static int[] sort(int[][] k) {

        return sort(k, k.length);
    }

    public static int[] sort(int[][] k, int len) {
        if (len == 1)
            return k[0];
        int f = 0;
        if (len % 2 == 1) {
            f = len - 1;
        } else {
            f = len;
        }
        int counter = 0;
        int[][] arr = new int[len][];
        int arrCounter = 0;
        while (counter < f) {
            if (k[counter] != null && k[counter + 1] != null) {
                arr[arrCounter] = sort(k[counter++], k[counter++]);
                arrCounter++;
            }
        }

        int finalLen = 0;
        if (len % 2 == 1) {
            arr[arrCounter] = k[f];
            finalLen = f / 2 + 1;
        } else {
            finalLen = f / 2;
        }
        return sort(arr, finalLen);
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

        k[0] = new int[]{4,7,14};
        k[1] = new int[]{3,8, 15};
        k[2] = new int[]{5, 6, 7,8,13,};
        int[] f = sort(k);
        for(int i:f){
            System.out.print(i + " ");
        }
    }
}
