package inheritance.inner;

public class ParentA implements Interface4{
    public static void main(String[] args) {
        Interface4 interface4 = new ParentA();
        interface4.printDefault();
    }

    public void normalMehtod(){
        printDefault();

    }
}
