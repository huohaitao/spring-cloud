/**
 * 
 */
package com.haitao.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huoht
 *
 */
@RestController
public class IndexController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/hello")
	public String hello(String name,String msg){
		System.out.println(name+" say "+msg+" to me ！");
		return "Hello "+name;
	}
}
