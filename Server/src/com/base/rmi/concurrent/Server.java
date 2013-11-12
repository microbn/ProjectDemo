package com.base.rmi.concurrent;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Server {

	public static void main(String[] args) {
		init();
	}
	
	public static void init(){
		try {
			IStack stack = new StackImpl("myStack");
			
			Context context = new InitialContext();
			
			LocateRegistry.createRegistry(8089);
			//LocateRegistry.createRegistry(port, csf, ssf);
			
			context.bind("rmi://127.0.0.1:8089/IStack", stack);
			
			System.out.println("服务器注册成功！");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
