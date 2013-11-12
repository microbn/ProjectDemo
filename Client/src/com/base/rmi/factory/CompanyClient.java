package com.base.rmi.factory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CompanyClient {

	public static void main(String[] args) {
		init();
	}
	public static void init(){
	
		try {
			Context context = new InitialContext();
			ICompanyFactory companyFactory = (ICompanyFactory) context.lookup("rmi://192.168.40.69:8089/ICompanyFactory");
			ICompany company1 = companyFactory.getCompany("com1");
			String address1 = company1.getAddress();
			if(address1==null){
				company1.setAddress("address1");
			}else{
				System.out.println("name:"+company1.getName()+" address:"+address1);
			}
			ICompany company2 = companyFactory.getCompany("com1");
			System.out.println((company1==company2)+"---"+company1.equals(company2));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
