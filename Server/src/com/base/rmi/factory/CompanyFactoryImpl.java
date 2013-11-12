package com.base.rmi.factory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;
import java.util.Map;

public class CompanyFactoryImpl extends UnicastRemoteObject implements ICompanyFactory{
	private static final long serialVersionUID = 1L;
	private Map<String, ICompany> companys = null;
	
	protected CompanyFactoryImpl() throws RemoteException {
		companys = new Hashtable<String, ICompany>();
	}

	@Override
	public ICompany getCompany(String companyName) throws RemoteException {
		if(companys==null){
			return null;
		}
		ICompany company = companys.get(companyName);
		
		if(company!=null){
			return company;
		}
		ICompany rsCompany = new CompanyImpl();
		rsCompany.setName(companyName);
		companys.put(companyName, rsCompany);
		return rsCompany;
		
	}
}
