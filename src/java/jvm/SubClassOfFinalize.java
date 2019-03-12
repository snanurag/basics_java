package jvm;

public class SubClassOfFinalize extends UseOfFinalizeMethod {

    public static void main(String[] args) throws InterruptedException {
        new SubClassOfFinalize();    //Try with commenting out this line.
        System.gc();
        Thread.sleep(1000);        //Try with commenting out this line.
    }

    protected void finalize() throws Throwable {
        System.out.println("In finalize method of SubClassOfFinalize");
    }

}
