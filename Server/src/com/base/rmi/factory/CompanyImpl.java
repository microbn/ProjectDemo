package com.base.rmi.factory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompanyImpl implements ICompany {
	private String name;
	private String address;
	
	public CompanyImpl() throws RemoteException{
		UnicastRemoteObject.exportObject(this,8089);
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public String getAddress() throws RemoteException {
		return address;
	}

	@Override
	public void setName(String name) throws RemoteException {
		System.out.println("setName:"+name);
		this.name = name;
	}

	@Override
	public void setAddress(String address) throws RemoteException {
		System.out.println("setAddress:"+address);
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equal....");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyImpl other = (CompanyImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	

	
}
