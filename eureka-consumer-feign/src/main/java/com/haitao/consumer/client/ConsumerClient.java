/**
 * 
 */
package com.haitao.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huoht
 *
 */
@FeignClient("eureka-provider")
public interface ConsumerClient {
	
	@RequestMapping("hello")
	public String hello(String name);
}
