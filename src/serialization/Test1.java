package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1 {
	
	public static void main(String[] args) {
	//    doSave();
		doLoad();
	}
	
	private static void doSave() {
		try {
			File f = new File("/home/anurag/Desktop/Noname1.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Test2 t2 = new Test2();
			oos.writeObject(t2);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void doLoad() {
		try {
			File f = new File("/home/anurag/Desktop/Noname1.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream oos = new ObjectInputStream(fis);
	//		Object o2 = oos.readObject();
			Test2 t2 = (Test2)oos.readObject();
			System.out.println(t2.i);
			
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
