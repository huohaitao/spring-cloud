/**
 * 
 */
package com.haitao.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huoht
 *
 */
@RestController
public class IndexController {
	
	@RequestMapping("/hello")
	public String hello(String name,String msg){
		System.out.println(name+" say "+msg+" to me ！");
		return "Hello "+name;
	}
}
