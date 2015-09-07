package instantiation;


public  class Take1{

	public Take1(){
		System.out.println(Intf1.y);
		printIt();
	}
	
	public void printIt(){
		
	}
	
	static{
		System.out.println("anurag in super static block");
		
	}
	
	{
		System.out.println("anurag in super instance block");
	}
}