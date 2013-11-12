package com.base.rmi.demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHello extends Remote{

	public String helloWord() throws RemoteException;
	
	public String sayHello(String name) throws RemoteException;
}
