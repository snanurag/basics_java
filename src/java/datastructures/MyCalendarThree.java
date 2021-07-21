package datastructures;

import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-iii/

/**
 * My output is right not of this site.
 */
class MyCalendarThree {

    public MyCalendarThree() {

    }
    TreeMap<Integer, Integer> tMap = new TreeMap<>();

    public int book(int start, int end) {
        int max;
        if (tMap.containsKey(start)) {
            int val = tMap.get(start);
            tMap.put(start, val+1);
            max = tMap.get(start);
        } else {
            int key = tMap.lowerKey(start) == null ? 0: tMap.lowerKey(start) ;
            int val = tMap.get(key)  == null ? 0: tMap.get(key);
            tMap.put(start, val+1);
            max = val+1;
        }

        int fKey = tMap.lowerKey(end) == null ? 0:tMap.lowerKey(end) ;
        if  (fKey == start){
            tMap.put(end, tMap.get(start)-1);
        }
        while (fKey != start && fKey != 0){
            int val = tMap.get(fKey);
            if (!tMap.containsKey(end))
                tMap.put(end, val);
            tMap.put(fKey, val+1);
            max = Math.max(max, val+1);
            fKey = tMap.lowerKey(fKey);
        }

        return max;
    }

    public static void main(String[] args) {
        MyCalendarThree t = new MyCalendarThree();
        System.out.println(t.book(10,20));
        System.out.println(t.book(50,60));
        System.out.println(t.book(10,40));
        System.out.println(t.book(5,15));
        System.out.println(t.book(5,10));
        System.out.println(t.book(25,55));
    }
}
