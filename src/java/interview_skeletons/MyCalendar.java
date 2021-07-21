package interview_skeletons;

/**
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * Explanation:
 * The first event can be booked.  The second can't because time 15 is already booked by another event.
 * The third event can be booked, as the first event takes every time less than 20, but not including 20.
 */
public class MyCalendar {
    public static void main(String[] args) {
        MyCalendar t = new MyCalendar();
        System.out.println(t.book(10,20)); // true
        System.out.println(t.book(50,60)); // true
        System.out.println(t.book(10,40)); // false
        System.out.println(t.book(5,15)); // false
        System.out.println(t.book(5,10)); //true
        System.out.println(t.book(25,55)); // false
    }

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        return false;
    }

}
