package interviews.robinsystems;

import java.util.Arrays;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {8,9,10,1,2,3,4,5,6,7};
        System.out.println(search(arr, 9));
        int[] arr1 = {8,9,10,1,2,3,4,5,6};
        System.out.println(search(arr1, 9));
        System.out.println(search(arr1, 20) < 0);

        int[] arr3 = {1,2,3,4,5,6,7};
        System.out.println(search(arr3, 6));
        int arr2[] = {1};
        System.out.println(0 == search(arr2, 1));
        int arr4[] = {1,2};
        System.out.println(1==search(arr4, 2));
    }

    private static int search(int[] arr, int ele){
        int pivot = findPivot(arr);
        int len = arr.length;
        if (ele <= arr[len-1] || pivot == 0)
            return Arrays.binarySearch(arr, pivot, len, ele);
        else
            return Arrays.binarySearch(arr, 0, pivot-1,ele);
    }

    private static int findPivot(int[] arr){
        int s = 0;
        int len = arr.length -1;
        int e = len;

        while(e > s){
            int hf = (s + e)/2;

            if(arr[hf] < arr[len]){
                e = hf;
            }
            else {
                s = hf;
            }

            if(e - s == 1 && arr[s]> arr[e])
                return e;
        }
        return 0;
    }

    /**
     *
     * 8,9,10,1,2,3,4,5,6,7
     * e = 2
     * s = 4
     * hf = 4
     *
     *
     *  8 9 10 1 2 3 4 5 6 7
     *  e =  3
     *  s = 2
     *
     *  7 8 9 10 1 2 3 4 5 6
     *
     *  e = 4
     *  s = 3
     *
     *
     *  3 4 5 6 7 8 9 10 1 2
     */

}
