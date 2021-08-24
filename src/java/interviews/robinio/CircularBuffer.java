package interviews.robinio;


import java.lang.reflect.Array;

public class CircularBuffer<T> {

    /**
     * 6 7 3 4 5
     */

    private int size;
    private T[] array;
    private int addPointer = 0;
    private int getPointer = 0;

    public CircularBuffer(Class<T> clazz, int size) {
        this.size = size;
        array = (T[]) Array.newInstance(clazz, size);
    }

    public void add(T o) {
        if (addPointer == size) {
            addPointer = 0;
        }
        getPointer = addPointer;
        array[addPointer++] = o;

    }

    public T get() throws Exception {
        if (getPointer == 0 && array[getPointer] == null) {
            throw new Exception("There is no element present in this buffer.");
        }

        if (getPointer != 0) {
            return array[getPointer--];
        } else {
            getPointer = size - 1;
            return array[0];
        }
    }

    public static void main(String[] args) {
        try {
            CircularBuffer c = new CircularBuffer(String.class, 4);
            c.add("1");
            c.add("2");
            c.add("3");
            System.out.println(c.get());
            c.add("4");
            System.out.println(c.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
