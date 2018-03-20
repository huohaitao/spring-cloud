/**
 * 
 */
package com.haitao.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author huoht
 *
 */
public class ProducerAndConsumer {

	public static void main(String[] args) {
		BlockingQueue<Product> products = new ArrayBlockingQueue<Product>(1);
		Producer pro = new Producer(products, "小米");
//		Producer dpro = new Producer(products, "代工");
		Consumer zs = new Consumer(products, "张三");
//		Consumer ls = new Consumer(products, "李四");
		pro.start();
//		dpro.start();
		zs.start();
//		ls.start();
	}
}

class Product {
	private String name;
	
	private String producer;

	
	/**
	 * @param name
	 * @param producer
	 */
	public Product(String name, String producer) {
		super();
		this.name = name;
		this.producer = producer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" @ ");
		builder.append(producer);
		return builder.toString();
	}
}

class Producer extends Thread{

	private BlockingQueue<Product> products;
	private String name;
	
	/**
	 * @param products
	 * @param name
	 */
	public Producer(BlockingQueue<Product> products, String name) {
		super();
		this.products = products;
		this.name = name;
	}

	@Override
	public void run() {
		int i=0;
		while(true){
			try {
				Product p = new Product("小米MIX-"+i, this.name);
				products.put(p);
				System.out.println("Produced : "+p);
				i++;
//				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
}

class Consumer extends Thread{
	private BlockingQueue<Product> products;
	private String name;
	
	public Consumer(BlockingQueue<Product> products, String name) {
		super();
		this.products = products;
		this.name = name;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(9000);
				Product p = products.take();
				System.out.println(this.name + "Cousumed : "+p);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}