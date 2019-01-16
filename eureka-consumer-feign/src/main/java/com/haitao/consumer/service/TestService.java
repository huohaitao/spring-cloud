package com.haitao.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haitao.consumer.client.ConsumerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {

	@Autowired
	private ConsumerClient client;
	
	/**
	 * 添加 @HystrixCommand 后spring会使用Hystrix进行服务降级
	 * 而Hystrix自身还提供了 依赖隔离 和 断路器
	 * 
	 * @param name
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "helloFallback")
	public String hello(String name) {
		return this.client.hello(name);
	}
	
	public String helloFallback(String name) {
		return "降级 hello -> "+name;
	}
}
