package rmipackage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * This example shows that there would be infinite threads at RMI server and the
 * old threads will be getting used also. Except the print of hashcode shows
 * that there would be single object only.
 *
 * @author ashrinagar
 */
public class CalcClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                public void run() {
                    Calc c = null;
                    try {
                        c = (Calc) Naming.lookup("rmi://192.168.1.2:1099/calc");
                    } catch (MalformedURLException | RemoteException
                            | NotBoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    try {
                        c.getThreadName();
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                ;
            };
            t.start();
        }
    }

}
