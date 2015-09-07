package exceptions;

public class SubClassToParent1 extends ParentClass1{

	public void setIt(){ 	
	//	throw new IllegalAccessException();		//	TODO try with removing these comments.
	}

	public static void removeDuplicates(char[] str) throws IllegalAccessException{
		
	}
	
	public void setIt2() throws IllegalAccessException {
		
	}
	
	public void getIt(){
		throw new NullPointerException();
	}
	
	public static void main(String[] args) throws IllegalAccessException{
		ParentClass1 p = new SubClassToParent1();
		p.getIt();
	}
}
