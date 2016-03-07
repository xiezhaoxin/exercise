package com.xiezhaoxin.javaee.thread.runable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestRunable {
	
	@Test
	public void testRunables(){
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			exec.execute(new MyRunable(i));
		}
		exec.shutdown();
	}
	
	@Test
	public void testRunable(){
		for (int i = 0; i < 100; i++) {
			new Thread(new MyRunable(i)).start();;
		}
	}
	
}
