package com.base.rmi.demo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloServer {

	public static void main(String[] args) {
		init();
	}
	
	public static void init(){
		
		try {
			IHello hello = new HelloImpl();//创建远程对象
			
			/*//本地主机上的远程对象注册表实例，如果缺少注册表的创建，则无法绑定对象到远程注册表上
			LocateRegistry.createRegistry(8089);
			
			//把远程对象注册到RMI注册服务上，并命名为Rhello
			Naming.bind("rmi://192.168.40.69:8089/Rhello", hello);*/
			
			
			
			Context context = new InitialContext();
			LocateRegistry.createRegistry(8089);
			context.rebind("rmi://127.0.0.1:8089/Rhello", hello);
			
			
			System.out.println("remote object bind successfully!!");
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}/* catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} */catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
