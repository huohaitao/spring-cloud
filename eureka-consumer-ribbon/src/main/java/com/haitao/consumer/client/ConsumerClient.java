/**
 * 
 */
package com.haitao.consumer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author huoht
 *
 */
@Component
public class ConsumerClient {

	@Autowired
	private RestTemplate restTemplate;
	
	public String hello(String name,String msg){
		String url = "http://eureka-provider/hello?name="+name+"&msg="+msg;
		return restTemplate.getForObject(url, String.class);
	}
}
