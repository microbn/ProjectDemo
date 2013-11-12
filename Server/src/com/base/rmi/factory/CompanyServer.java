package com.base.rmi.factory;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CompanyServer {

	public static void main(String[] args) {
		init();
	}
	
	public static void init(){
		
		try {
			ICompanyFactory companyFactory = new CompanyFactoryImpl();
			
			Context context = new InitialContext();
			
			LocateRegistry.createRegistry(8089);
			
			context.bind("rmi://127.0.0.1:8089/ICompanyFactory", companyFactory);
			
			System.out.println("CompanyServer start success!");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
