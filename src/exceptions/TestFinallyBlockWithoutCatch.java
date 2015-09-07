package exceptions;

import java.io.FileNotFoundException;

public class TestFinallyBlockWithoutCatch {


	public int setName(){
		try{
			throw new FileNotFoundException();
		}
		finally{
			return 4;
		}
	}
	
	public static void main(String[] args) {
		TestFinallyBlockWithoutCatch t = new TestFinallyBlockWithoutCatch();
		System.out.println(t.setName());
	}
}
