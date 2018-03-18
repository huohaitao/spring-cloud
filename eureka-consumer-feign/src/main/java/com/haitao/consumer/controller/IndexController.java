/**
 * 
 */
package com.haitao.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haitao.consumer.client.ConsumerClient;

/**
 * @author huoht
 *
 */
@RestController
public class IndexController {

	@Autowired
	private ConsumerClient consumerClient;
	
	@RequestMapping("/hello")
	public String helloEureka(String name){
		return this.consumerClient.hello(name);
	}
}
