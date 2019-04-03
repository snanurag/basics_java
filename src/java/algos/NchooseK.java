package algos;

import java.util.LinkedList;

public class NchooseK {

    public static void main(String[] args) {
        comb(new char[]{'a','b','c','d','e'},0,3,0, new LinkedList<>());
    }
    private static void comb(char[] arr, int start, int r, int d, LinkedList<Character> l){
        if(d == r){
            l.forEach(System.out::print);
            System.out.println();
        }
        else{
            for(int i= start; i< arr.length-r+d+1; i++){
                l.add(arr[i]);
                comb(arr, i+1, r, d+1, l);
                l.removeLast();
            }
        }
    }
}
