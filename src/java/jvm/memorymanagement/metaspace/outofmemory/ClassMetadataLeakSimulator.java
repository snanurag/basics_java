package jvm.memorymanagement.metaspace.outofmemory;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * PermGenRemovalValidator
 *
 * Run this program using -verbose:gc to see that Metaspace keeps on increasing with time.
 *
 * Run java -XX:+PrintFlagsFinal -version | grep -iE 'HeapSize|PermSize|ThreadStackSize' in Java 7
 * Run java -XX:+PrintFlagsFinal -version | grep -iE 'HeapSize|Metaspace|ThreadStackSize' in Java 8
 *
 * The above two commands will tell you the initial Max size of MaxPerm and MaxMetaspace. And you can see that Metaspace is set to
 * 18446744073709547520 Bytes that is 2 ^ 64. That means it can consume 4 GB * 4 GB of your memory. That is practically whole RAM.
 * But MaxPermGen is set to around ~100 MB. Because once PermGen space is claimed It can't be re-claimed by heap or any other process.
 *
 * @author Pierre-Hugues Charbonneau
 * 
 */
public class ClassMetadataLeakSimulator {

	private static Map<String, ClassA> classLeakingMap = new HashMap<String, ClassA>();
	private final static int NB_ITERATIONS_DEFAULT = 50000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Class metadata leak simulator");
		System.out.println("Author: Pierre-Hugues Charbonneau");
		System.out.println("http://javaeesupportpatterns.blogspot.com");

		int nbIterations = (args != null && args.length == 1) ? Integer.parseInt(args[0]) : NB_ITERATIONS_DEFAULT;

		try {

			for (int i = 0; i < nbIterations; i++) {

				String fictiousClassloaderJAR = "file:" + i + ".jar";

				URL[] fictiousClassloaderURL = new URL[] { new URL(fictiousClassloaderJAR) };

				// Create a new classloader instance
				URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);
				
				// Create a new Proxy instance
				ClassA t = (ClassA) Proxy.newProxyInstance(newClassLoader,
						new Class<?>[] { ClassA.class },
						new ClassAInvocationHandler(new ClassAImpl()));
				
				// Add the new Proxy instance to the leaking HashMap
				classLeakingMap.put(fictiousClassloaderJAR, t);
			}
		} 
		catch (Throwable any) {
			System.out.println("ERROR: " + any);
		}

		System.out.println("Done!");
	}
}