package com.base.rmi.demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

public class HelloClient {

	public static void main(String[] args) {
		callHello();
	}
	
	public static void callHello(){

		//在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法 
		try {
			
			IHello hello = (IHello) Naming.lookup("rmi://192.168.40.69:8089/Rhello");
			
			System.out.println("存根class:"+hello.getClass());
			System.out.println(hello.helloWord());
			System.out.println(hello.sayHello("张三"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
