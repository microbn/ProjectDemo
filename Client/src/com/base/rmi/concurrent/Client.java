package com.base.rmi.concurrent;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		try {
			IStack stack = (IStack) Naming.lookup("rmi://192.168.40.69:8089/IStack");
			Productor p1 = new Productor(stack, "p1");
			Productor p2 = new Productor(stack, "p2");
			Consumer c = new Consumer(stack, "c");
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
