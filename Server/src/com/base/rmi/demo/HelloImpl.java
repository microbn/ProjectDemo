package com.base.rmi.demo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected HelloImpl() throws RemoteException {
	}

	@Override
	public String helloWord() throws RemoteException {
		return "hello";
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		return "hello,"+name;
	}


}
