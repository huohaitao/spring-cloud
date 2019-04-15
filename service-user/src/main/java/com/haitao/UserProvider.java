package com.haitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.haitao"})
public class UserProvider {

	public static void main(String[] args) {
		SpringApplication.run(UserProvider.class, args);
	}
	
}
