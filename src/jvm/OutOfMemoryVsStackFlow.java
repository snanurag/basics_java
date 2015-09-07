package jvm;

public class OutOfMemoryVsStackFlow {

	private static void getIt(){
		long stackMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println(stackMemory);
		getIt();
	}
	
	//TODO : try out this in different ways.
	//1. /usr/lib/jvm/java-6-openjdk/bin/java -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -classpath /home/anurag/workspace/LearnJava/bin jvm.OutOfMemoryVsStackFlow > out
	//2. /usr/lib/jvm/java-6-openjdk/bin/java -Xms10m -Xmx10m -Dfile.encoding=UTF-8 -classpath /home/anurag/workspace/LearnJava/bin jvm.OutOfMemoryVsStackFlow > out
	//3. /usr/lib/jvm/java-6-openjdk/bin/java -Xss12m -Xms10m -Xmx10m -Dfile.encoding=UTF-8 -classpath /home/anurag/workspace/LearnJava/bin jvm.OutOfMemoryVsStackFlow > out
	
	//With using both the restrictions on the start and max size of the jvm memory the stackMemory value changes, that means that the value of stack depends on the heap size too.
	//When using the 1st jvm command then it uses the that much size of ram. That means the extra heap which is created from the given sizes are created taken from ram only.
	//Why 3rd command doesn't give any error if stack size is given more than the heap size?
	public static void main(String[] args) {
		getIt();
	}
}