package com.xiezhaoxin.javaee.thread.runable;

public class MyRunable implements Runnable{
	private int i;
	
	public MyRunable() {
		super();
	}

	public MyRunable(int i) {
		super();
		this.i = i;
	}

	public void run() {
		System.err.println("这是第" + i + "个线程！");
	}

}
