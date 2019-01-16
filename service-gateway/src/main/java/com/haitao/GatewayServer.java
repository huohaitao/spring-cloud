package com.haitao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.haitao.filter.AccessFilter;

/**
 * zuul 服务网关主要是用于第三方系统调用 本地 服务时 进行服务的路由转发 和 调用权限的校验
 * @author huoht
 * @date 2019年1月16日
 * @version V1.0
 */
@EnableZuulProxy
@SpringBootApplication
public class GatewayServer {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServer.class, args);
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
