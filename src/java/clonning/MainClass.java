package clonning;

public class MainClass {

    public static void main(String[] args) {

        /**
         *
         * This IndexAt1Starts is proving that we are only copying the byte values of
         * instance variables in the instance variables of the clone.
         *
         * So in case of primary instance variable, when you will change the
         * value on it's clone then it will be different than the original
         * variable.
         *
         */

        CloneTest cTest = new CloneTest();
        cTest.setI(5);
        System.out.println(cTest.getI());
        CloneTest cTest2 = (CloneTest) cTest.clone();
        System.out.println(cTest2.getI());
        System.out.println("Clone is same object: "
                + (cTest == cTest2));
        cTest2.setI(50);
        System.out.println(cTest.getI());

        System.out.println(cTest2.getI());

    }
}
