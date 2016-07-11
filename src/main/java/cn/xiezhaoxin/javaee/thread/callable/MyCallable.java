package cn.xiezhaoxin.javaee.thread.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Object>{
	
	private int i;
	
	public MyCallable() {
		super();
	}

	public MyCallable(int i) {
		super();
		this.i = i;
	}

	public Object call() throws Exception {		
		Thread.sleep(100);
		if(i == 99){
			Thread.sleep(10000);
		}
		return "这是第" + i + "个线程";
	}
	
}
