package jvm;

public class UseOfFinalizeMethod {

    
    protected void finalize() throws Throwable {
	System.out.println("In finalize method of UseOfFinalizeMethod");
    }
    
    
    public static void main(String[] args) throws InterruptedException {
	new UseOfFinalizeMethod();	//Try with commenting out this line.
	System.gc();
	Thread.sleep(1000);		//Try with commenting out this line.
    }
}
