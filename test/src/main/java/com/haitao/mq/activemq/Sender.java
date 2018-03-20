/**
 * 
 */
package com.haitao.mq.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author huoht
 *
 */
public class Sender {
	
	public void prepareTopicTosend(boolean persistent){
		ConnectionFactory connectionFactory = this.getConnectionFactory();
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			connection.setClientID("hht-st0");
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(connection));
			connection.start();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createTopic("HHTTopic");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(persistent?DeliveryMode.PERSISTENT:DeliveryMode.NON_PERSISTENT);
			sendMessage(session, producer,persistent?"持久订阅":"订阅");  
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			closeConnection(connection);
		}
	}
	
	public void prepareTosend(){
		ConnectionFactory connectionFactory = this.getConnectionFactory();
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(connection));
			connection.setClientID("hht-s0");
			connection.start();
			Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("HHTQueue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);
			sendMessage(session, producer,"点对点");  
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			closeConnection(connection);
		}
	}

	private void closeConnection(Connection connection) {
		if(connection!=null){
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sendMessage(Session session, MessageProducer producer,String prefix) throws JMSException{
		int i = 0;
		while(true){
			String msg = prefix+ "- ActiveMq 发送的消息" + i;
	        TextMessage message = session.createTextMessage(msg);
	        producer.send(message);
	        System.out.println("发送消息：" + msg);
	        session.commit();
	        i++;
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    }  
	
	private ConnectionFactory getConnectionFactory(){
		return new ActiveMQConnectionFactory(  
                ActiveMQConnection.DEFAULT_USER,  
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://huo.ht.com:61616");
	}
	
	public static void main(String[] args) {
		Sender sender = new Sender();
//		sender.prepareTosend();
		sender.prepareTopicTosend(true);
	}
}
