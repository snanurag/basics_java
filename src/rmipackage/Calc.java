package rmipackage;

import java.rmi.Remote;
import java.rmi.RemoteException;


	public interface Calc extends Remote
	{
	   public int add(int i,int j)throws RemoteException;
	   
	   public void getThreadName()throws RemoteException;
	}

