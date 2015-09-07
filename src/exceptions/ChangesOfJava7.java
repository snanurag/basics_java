package exceptions;

import java.io.IOException;

public class ChangesOfJava7 {

    public void method1() throws IOException { // In java 7 not required to
					       // throw catch block exception if
					       // try block
					       // and catch block throws exceptions are same
					       // but catch block exception is
					       // of super type of try block

	try {
	    throw new IOException();
	} catch (Exception e) {
	    throw e;
	}

    }
}
