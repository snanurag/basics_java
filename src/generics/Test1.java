package generics;

public class Test1<String> {	// when it is inside angle brackets then it is the variable not the class type.
	
	public String getIt(String s){
		return s;
	}

	public <T extends Number> void setT(T t){	//Ensuring that the input is of type Number.
		//	new FlipkartPrintBracketsPNC<Integer>();					//TODO : try with removing this comment.
		//	new FlipkartPrintBracketsPNC().setIt(new Integer(9));		//TODO : try with removing this comment.
	}
	
}

class Test2<T extends String>{	//Ensuring type at class level.
	public void setIt(T t){
		
	}
}
