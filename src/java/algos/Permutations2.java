package algos;

public class Permutations2 {

    //Permutations using back-tracking.

    public static void main(String[] args) {
        permute("abcd".toCharArray() ,4);
    }

    public static void permute(char[] cArr, int len){
        if(len == 2){
            System.out.println(String.valueOf(cArr));
            swap(cArr, cArr.length-2, cArr.length-1);
            System.out.println(String.valueOf(cArr));
            swap(cArr, cArr.length-1, cArr.length-2);
        }
        else {
            int i = cArr.length - len;
            permute(cArr, len-1);
            for(int j=i+1; j <cArr.length; j++){
                swap(cArr,i,j);
                permute(cArr, len-1);
                swap(cArr,j,i);
            }
        }
    }

    private static void swap(char[] cArr, int i,int j){
        char tmp = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = tmp;
    }
}
