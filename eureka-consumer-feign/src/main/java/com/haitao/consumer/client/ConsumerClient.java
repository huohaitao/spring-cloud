/**
 * 
 */
package com.haitao.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huoht
 *
 */
@FeignClient("service-provider")
public interface ConsumerClient {
	
	@RequestMapping("hello")
	public String hello(@RequestParam("name") String name);
	
}
