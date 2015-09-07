
public class Take3 extends Thread{

    protected void createReq()
    {
	System.out.println("take3 createReq");
    }
    
    private void processReq()
    {
	createReq();
    }
    
    public void run()
    {
	processReq();
    }
    
}