package com.haitao.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-user")
@RequestMapping("/user")
public interface UserClient {

	@RequestMapping("/get")
	String get(@RequestParam("name") String name);
}
