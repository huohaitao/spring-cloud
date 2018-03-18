/**
 * 
 */
package com.haitao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用最基础的方式调用eureka服务
 * @author huoht
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.haitao"})
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
}
