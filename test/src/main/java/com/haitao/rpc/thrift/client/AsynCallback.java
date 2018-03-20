/**
 * 
 */
package com.haitao.rpc.thrift.client;

import org.apache.thrift.async.AsyncMethodCallback;

/**
 * @author huoht
 *
 */
public class AsynCallback implements AsyncMethodCallback<String> {

	@Override
	public void onComplete(String response) {
		System.out.println("AsynCallback complete ： "+response);
	}

	@Override
	public void onError(Exception exception) {
		System.out.println("AsynCallback error ： ");
		exception.printStackTrace();
	}

}
