/**
 * 
 */
package com.haitao.rpc.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.haitao.rpc.thrift.Constants;
import com.haitao.rpc.thrift.ThriftService.Iface;
import com.haitao.rpc.thrift.ThriftService.Processor;
import com.haitao.rpc.thrift.server.impl.ThriftServiceImpl;

/**
 * @author huoht
 *
 */
public class ThriftServer {
	
    public static void startServer() {
        try {
            System.out.println("HelloWorld TThreadPoolServer start on port  : "+Constants.SERVER_PORT+" ....");  
            TServerTransport serverTransport = new TServerSocket(Constants.SERVER_PORT);
            TProcessor tprocessor = new Processor<Iface>(new ThriftServiceImpl());
            //TThreadPoolServer 线程池服务模型 
            Args ttpsArgs = new Args(serverTransport);
            ttpsArgs.processor(tprocessor);
            ttpsArgs.protocolFactory(new TCompactProtocol.Factory());
            //线程池服务模型，使用标准的阻塞式IO，预先创建一组线程处理请求
          TServer server = new TThreadPoolServer(ttpsArgs);
//            TServer server = new TSimpleServer(ttpsArgs);
            server.serve();
        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	ThriftServer.startServer();
	}
}
