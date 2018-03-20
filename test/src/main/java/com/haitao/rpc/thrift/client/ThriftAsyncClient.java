/**
 * 
 */
package com.haitao.rpc.thrift.client;

import java.io.IOException;

import org.apache.thrift.TException;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;
import org.apache.thrift.transport.TTransportException;

import com.haitao.rpc.thrift.Constants;
import com.haitao.rpc.thrift.ThriftService.AsyncClient;

/**
 * @author huoht
 *
 */
public class ThriftAsyncClient {

	public static final String SERVER_IP = "localhost";  
    public static final int TIMEOUT = 3000;  
  
    /** 
     * 
     * @param userName 
     */  
    public static void startClient(String userName) {  
    	TNonblockingTransport transport=null;
        try {
        	TAsyncClientManager clientManager = new TAsyncClientManager();
            transport = new TNonblockingSocket(SERVER_IP, Constants.SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致  
            TProtocolFactory protocol = new TCompactProtocol.Factory();
            AsyncClient client = new AsyncClient(protocol,clientManager, transport);
            System.out.println("Client start .....");
            AsynCallback callBack = new AsynCallback();
            client.sayHello(userName,callBack);
            System.out.println("Deal next ! ");
            Thread.sleep(5000);
            System.out.println("client end ! ");
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
            if (null!= transport) {
                transport.close();
            }
        }
    }
    
    public static void main(String[] args) {
    	ThriftAsyncClient.startClient("霍海涛");
	}
}
