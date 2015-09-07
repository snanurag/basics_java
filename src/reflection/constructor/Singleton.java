package reflection.constructor;

public class Singleton {
	
	private Singleton(){
		
	}
	
	static{
		System.out.println("anurag in static block");
	}

	{
		System.out.println("anurag in instance block");
	}
	
	
	
	public void methodA(){
	    System.out.println("anurag in methodA");
	}
	
	public static void methodB(){
	    System.out.println("anurag inside methodB");;
	}
}
