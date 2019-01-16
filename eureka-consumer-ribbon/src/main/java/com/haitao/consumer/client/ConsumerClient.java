/**
 * 
 */
package com.haitao.consumer.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author huoht
 *
 */
@Component
public class ConsumerClient {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String hello(String name,String msg){
		String url = "http://service-provider/hello?name="+name+"&msg="+msg;
		return restTemplate.getForObject(url, String.class);
	}
	
	public String hello0(String name,String msg){
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-provider");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/hello?name="+name+"&msg="+msg;
		return restTemplate.getForObject(url, String.class);
	}
}
