package com.xiezhaoxin.javaee.thread.thread;

public class MyThread extends Thread {
	private int i;
	
	public MyThread() {
		super();
	}

	public MyThread(int i) {
		super();
		this.i = i;
	}

	@Override
	public void run() {
		System.err.println("这是第" + i + "个线程！");
		super.run();
	}
	
}
