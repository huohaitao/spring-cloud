/**
 * 
 */
package com.haitao.mq.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author huoht
 *
 */
public class Receiver {

	private ConnectionFactory getConnectionFactory(){
		return new ActiveMQConnectionFactory(  
                ActiveMQConnection.DEFAULT_USER,  
                ActiveMQConnection.DEFAULT_PASSWORD, "tcp://huo.ht.com:61616");
	}
	
	public void prepareToReceivePersistTopic(String cid){
		ConnectionFactory connectionFactory = this.getConnectionFactory();
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(connection));
			connection.setClientID(cid);
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Topic topic = session.createTopic("HHTTopic");
			MessageConsumer consumer = session.createDurableSubscriber(topic,"bbb");
			this.receiveMessage(consumer);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void prepareToReceiveTopic(){
		ConnectionFactory connectionFactory = this.getConnectionFactory();
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(connection));
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createTopic("HHTTopic");
			MessageConsumer consumer = session.createConsumer(destination);
			this.receiveMessage(consumer);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void prepareToReceive(){
		ConnectionFactory connectionFactory = this.getConnectionFactory();
		Connection connection = null;
		try {
			connection = connectionFactory.createConnection();
			Runtime.getRuntime().addShutdownHook(new ShutdownThread(connection));
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("HHTQueue");
			MessageConsumer consumer = session.createConsumer(destination);
			this.receiveMessage(consumer);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void receiveMessage(MessageConsumer consumer) throws JMSException{
		 while (true) {  
             TextMessage message = (TextMessage) consumer.receive(100000);  
             if (null != message) {  
                 System.out.println(Thread.currentThread().getName()+" 收到消息: " + message.getText());  
             } else {  
                 break;  
             }  
         }  
	}
	
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				new Receiver().prepareToReceivePersistTopic("hht-sr0");
			}
		}.start();
//		new Thread(){
//			@Override
//			public void run() {
//				new Receiver().prepareToReceiveTopic();
//			}
//		}.start();
	}
}
