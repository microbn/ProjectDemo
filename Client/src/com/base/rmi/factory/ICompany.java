package com.base.rmi.factory;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICompany extends Remote{

	public String getName() throws RemoteException;
	public String getAddress() throws RemoteException;
	public void setName(String name) throws RemoteException;
	public void setAddress(String address) throws RemoteException;
}
