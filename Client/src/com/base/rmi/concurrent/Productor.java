package com.base.rmi.concurrent;

public class Productor extends Thread{

	private IStack stack;
	
	public Productor(IStack stack,String name) {
		super(name);
		this.stack = stack;
		start();
	}

	@Override
	public void run() {
		try {
			
			while(true){
				
				this.stack.push("goods");
				
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
}
