package generics;

public class TestTest1 {

    public static void main(String[] args) {
        Test1<Integer> t = new Test1<Integer>();
        System.out.println(t.getIt(2));

        t.setT(new Integer(3));

        Test1 t2 = new Test1();
        System.out.println(t2.getIt(2));

    }
}
