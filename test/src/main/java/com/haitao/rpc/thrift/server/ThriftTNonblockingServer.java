/**
 * 
 */
package com.haitao.rpc.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.haitao.rpc.thrift.Constants;
import com.haitao.rpc.thrift.ThriftService.Iface;
import com.haitao.rpc.thrift.ThriftService.Processor;
import com.haitao.rpc.thrift.server.impl.ThriftServiceImpl;

/**
 * @author huoht
 *
 */
public class ThriftTNonblockingServer {
	
	public static void startServer() {
        try {
            System.out.println("HelloWorld TThreadPoolServer start on port  : "+Constants.SERVER_PORT+" ....");  
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(Constants.SERVER_PORT);
            TProcessor tprocessor = new Processor<Iface>(new ThriftServiceImpl());
            TNonblockingServer.Args ttpsArgs = new TNonblockingServer.Args(serverTransport);
            ttpsArgs.processor(tprocessor);
            ttpsArgs.protocolFactory(new TCompactProtocol.Factory());
            ttpsArgs.transportFactory(new TFramedTransport.Factory());
            TServer server = new TNonblockingServer(ttpsArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		ThriftTNonblockingServer.startServer();
	}
}
