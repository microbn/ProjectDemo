package com.base.rmi.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICompanyFactory extends Remote{

	public ICompany getCompany(String companyName) throws RemoteException;
}
