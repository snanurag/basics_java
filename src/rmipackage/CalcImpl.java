package rmipackage;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Tutorial for RMI
 * http://www.developer.com/java/other/article.php/3455311/Understanding
 * -Java-RMI-Internals.htm
 * <p>
 * TODO try running rmiregistry without mentioning the classpath of stub class
 * and implementing the codebase property.
 *
 * @author ashrinagar
 */
public class CalcImpl extends UnicastRemoteObject implements Calc {

    static {
        System.out.println("In CalcImpl static block");
    }

    public CalcImpl() throws RemoteException {
        super();
        System.out.println("In CalcImpl constructor");
    }

    public static void main(String[] args) throws Exception {
        CalcImpl c = new CalcImpl();
        Naming.rebind("rmi://192.168.1.2:1099/calc", c);

//		for(;;){
//			Calc calc = (Calc) Naming.lookup("rmi://127.0.0.1:1099/calc");
//			calc.getThreadName();
//		}
    }

    public int add(int i, int j) throws RemoteException {
        return i + j;
    }

    public void getThreadName() throws RemoteException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Object is " + this.hashCode());
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String toString() {
        return Thread.currentThread().getName();
    }
}
