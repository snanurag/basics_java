package instantiation;

public class Take2 extends Take1 {

    static {
        System.out.println("anurag in static block");
    }

//	public static int i =9;

    public int i = 9;

    {
        System.out.println("anurag in instance block");
    }

    public Take2() {
        printIt();
    }

    public static void main(String[] args) {
        /**
         * In this we are checking the order on instantiation of instance and static fields.
         */
        new Take2();
    }

    public void printIt() {
        System.out.println("anurag got i " + i);
    }
}

