/**
 * 
 */
package com.haitao.rpc.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.haitao.rpc.thrift.Constants;
import com.haitao.rpc.thrift.Position;
import com.haitao.rpc.thrift.ThriftService.Client;

/**
 * @author huoht
 *
 */
public class ThriftClient {

	public static final String SERVER_IP = "localhost";  
    public static final int TIMEOUT = 3000;  
  
    /** 
     * 
     * @param userName 
     */  
    public static void startClient(String userName) {  
        TTransport transport=null;
        try {
            transport = new TSocket(SERVER_IP, Constants.SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致  
            TProtocol protocol = new TCompactProtocol(transport);
            //TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            Client client = new Client(protocol);
            transport.open();
            String result = client.sayHello(userName);
            Position p = client.helloNation(userName);
            System.out.println("Thrify client result : " + result);
            System.out.println(p.toString());
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null!= transport) {
                transport.close();
            }
        }
    }
    
    public static void main(String[] args) {
		ThriftClient.startClient("霍海涛");
	}
}
