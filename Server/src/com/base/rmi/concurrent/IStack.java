package com.base.rmi.concurrent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStack extends Remote{
	
	public String getName() throws RemoteException;
	
	public int getPoint() throws RemoteException;
	
	public String pop() throws RemoteException;//删除，并返回此物品
	
	public void push(String goods) throws RemoteException;//添加

}
