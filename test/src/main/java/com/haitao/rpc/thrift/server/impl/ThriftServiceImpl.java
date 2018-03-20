/**
 * 
 */
package com.haitao.rpc.thrift.server.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.thrift.TException;

import com.haitao.rpc.thrift.Position;
import com.haitao.rpc.thrift.ThriftService.Iface;

/**
 * @author huoht
 *
 */
public class ThriftServiceImpl implements Iface {

	@Override
	public String sayHello(String name) throws TException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+" say hello to me !!");
		return "hello!";
	}

	@Override
	public Position helloNation(String name) throws TException {
		List<String> fs = new LinkedList<String>();
		fs.add("美丽");
		fs.add("文明");
		Position p = new Position(1, "中国", fs);
		System.out.println(name+" say hello to "+p.getName()+" !!");
		return p;
	}

}
