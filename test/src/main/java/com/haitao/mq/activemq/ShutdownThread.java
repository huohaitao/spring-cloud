/**
 * 
 */
package com.haitao.mq.activemq;

import javax.jms.Connection;
import javax.jms.JMSException;

/**
 * @author huoht
 *
 */
public class ShutdownThread extends Thread{
	private Connection connection;

	public ShutdownThread(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void run() {
		System.out.println("Shutdown connection");
		if(connection!=null){
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
