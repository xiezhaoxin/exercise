package cn.xiezhaoxin.javaee.thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestThread {

	@Test
	public void testThreads(){
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			exec.execute(new MyThread(i));
		}
	}
	
	@Test
	public void testThread(){
		for (int i = 0; i < 100; i++) {			
			new MyThread(i).start();
		}
	}

}
