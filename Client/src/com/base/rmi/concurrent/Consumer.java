package com.base.rmi.concurrent;

public class Consumer extends Thread {

	private IStack stack;
	
	public Consumer(IStack stack,String name) {
		super(name);
		this.stack = stack;
		start();
	}
	
	@Override
	public void run() {
		String goods;
		
		try {
			while(true){
				goods = stack.pop();
				
			//	System.out.println(getName()+":pop "+goods+" from " +stack.getName());
				
				Thread.sleep(400);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

