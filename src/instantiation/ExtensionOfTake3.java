package instantiation;

public class ExtensionOfTake3 extends Take3 {
	
	public void printClassName(){
		System.out.println("Class is ExtensionOfTake3");
	}
	
	public static void main(String[] args) {
		new ExtensionOfTake3().printIt();
	}

}
