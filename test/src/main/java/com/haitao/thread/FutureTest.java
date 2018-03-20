/**
 * 
 */
package com.haitao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huoht
 *
 */
public class FutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyCallable mc = new MyCallable();
		MyCallable mc0 = new MyCallable();
		
		FutureTask<String> f0 = new FutureTask<String>(mc);
		FutureTask<String> f1 = new FutureTask<String>(mc0);
		
		Thread t = new Thread(f0);
		Thread t1 = new Thread(f1);
		
		t.start();
		System.out.println(f0.get());
		t1.start();
		System.out.println(f1.get());
		
		System.out.println("finished ");
	}
	
	static class MyCallable implements Callable<String>{

		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName()+" 运行中");
			Thread.sleep(1000);
			return Thread.currentThread().getName();
		}
		
	}
}
