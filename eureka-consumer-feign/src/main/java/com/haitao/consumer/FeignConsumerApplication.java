/**
 * 
 */
package com.haitao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用最基础的方式调用eureka服务
 * @author huoht
 *
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan({"com.haitao"})
public class FeignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumerApplication.class, args);
	}
}
