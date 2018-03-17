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
	
	@RequestMapping("/dc")
	public Object discovery(){
		return this.discoveryClient.getServices();
	}
}
