package exceptions;

import java.io.FileNotFoundException;

public class ExtendingClasstoInterface implements InterfaceClass {

	public void methodA() throws FileNotFoundException		//TODO try with commenting throws clause
	{
	    throw new FileNotFoundException();
	}
}
