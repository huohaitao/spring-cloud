/**
 * 
 */
package com.haitao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haitao.client.UserClient;

/**
 * @author huoht
 *
 */
@RestController
public class IndexController {
	
	@Autowired
	private UserClient userClient;
	@RequestMapping("/hello")
	public String hello(String name,String msg){
		String user = userClient.get(name);
		System.out.println(user+" say "+msg+" to me ！");
		return "Hello "+user;
	}
}
