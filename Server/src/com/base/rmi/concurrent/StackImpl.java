package com.base.rmi.concurrent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StackImpl extends UnicastRemoteObject implements IStack{
	
	private String name;
	private String[] buffer = new String[50];
	private int point = -1;
	
	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
			
	protected StackImpl(String name) throws RemoteException {
		this.name = name;
	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public synchronized int getPoint() throws RemoteException {
		return this.point;
	}

	@Override
	public synchronized String pop() throws RemoteException {
		this.notifyAll();
		
		while(this.point==-1){
			System.out.println(Thread.currentThread().getName()+"-pop:wait!");
			
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		String goods = modifyBuffer(point, null);
	//	buffer[point] = null;
	//	modifyBuffer(point, null);
	//	Thread.yield();
		System.out.println("server-pop:"+goods);
		point--;
		return goods;
	}

	@Override
	public synchronized void push(String goods) throws RemoteException {
		this.notifyAll();
		
		while(point==buffer.length-1){
			System.out.println(Thread.currentThread().getName()+"-push:wait!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		point++;
	//	buffer[point] = goods+point;
		modifyBuffer(point, goods+point);
//		Thread.yield();
		
		System.out.println("server-push:"+goods+point);
	}

	private synchronized String modifyBuffer(int point,String value){
		String temp = buffer[point];
		buffer[point] = value;
		return temp;
	}
	
	private String setBuffer(int point,String value){
		try {
			rwLock.writeLock().lock();
			String temp = buffer[point];
			buffer[point] = value;
			return temp;
		} finally{
			rwLock.writeLock().unlock();
		}
	}
	private String getBuffer(int point){
		try {
			rwLock.readLock().lock();
			String temp = buffer[point];
			return temp;
		} finally{
			rwLock.readLock().unlock();
		}
	}
}
