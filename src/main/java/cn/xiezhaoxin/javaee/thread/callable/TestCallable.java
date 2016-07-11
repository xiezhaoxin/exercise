package cn.xiezhaoxin.javaee.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class TestCallable {

	@Test
	public void testCallables() throws InterruptedException, ExecutionException{
		ExecutorService exec = Executors.newCachedThreadPool();

		List<Future<Object>> futures = new ArrayList<Future<Object>>();
		
		for (int i = 0; i < 100; i++) {			
			futures.add(exec.submit(new MyCallable(i)));
		}
		
		for (Future<Object> future : futures) {
//			System.err.println(future.get());
			if(future.isDone()){
				System.err.println(future.get());
			}else {
				System.err.println("This task not done!");
			}
		}
		
		exec.shutdown();
	}
	
	@Test
	public void testCallable() throws InterruptedException, ExecutionException{
		Callable<Object> myCallable = new MyCallable(99);
		FutureTask<Object> future = new FutureTask<Object>(myCallable);
		new Thread(future).start();
		
		System.err.println(future.get());
	}
}
