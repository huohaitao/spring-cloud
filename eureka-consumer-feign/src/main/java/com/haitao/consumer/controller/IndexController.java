/**
 * 
 */
package com.haitao.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haitao.consumer.service.TestService;

/**
 * @author huoht
 *
 */
@RestController
public class IndexController {

	@Autowired
	private TestService service;
	
	@RequestMapping("/hello")
	public String helloEureka(String name){
		return this.service.hello(name);
	}
}
