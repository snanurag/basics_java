class Take5 extends Take3{
    
    protected void createReq()
    {
	System.out.println("take5 createReq");
    }
 
    public static void main(String[] args) {
	Take3 t = new Take5();
	t.start();
    }
    
    
    
}
