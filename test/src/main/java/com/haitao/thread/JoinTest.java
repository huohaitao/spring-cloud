/**
 * 
 */
package com.haitao.thread;

/**
 * @author huoht
 *
 */
public class JoinTest {
	public static void main(String[] args) throws InterruptedException {
		JoinTread jt1 = new JoinTread("1");
		JoinTread jt2 = new JoinTread("2");
		JoinTread jt3 = new JoinTread("3");
		jt1.start();
		jt2.start();
		jt1.join();
		jt2.join();
		jt3.start();
		jt3.join();
		System.out.println("Main thread end !");
	}
	
}

class JoinTread extends Thread{
	
	private String name;
	
	

	/**
	 * @param name
	 */
	public JoinTread(String name) {
		super();
		this.name = name;
	}



	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread:"+this.name+" weakup !");
	}
	
}
