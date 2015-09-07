package reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {

	public static void main(String[] args) {
		try {
//			Class.forName("reflection.constructor.Singleton").newInstance();
//			Constructor c = Class.forName("reflection.constructor.Singleton").getConstructors()[0]; //getConstructor method returns only publicly accessible constructors.
		    	Constructor c = Class.forName("reflection.constructor.Singleton").getDeclaredConstructors()[0];		//TODO try this after commenting above line
		    	Method m = Class.forName("reflection.constructor.Singleton").getDeclaredMethod("methodA",null);
		    	Method mB = Class.forName("reflection.constructor.Singleton").getDeclaredMethod("methodB",null);
			c.setAccessible(true);
//			c.newInstance(null);
			m.invoke(c.newInstance(null), null);
			mB.invoke(null, null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SecurityException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}
}
