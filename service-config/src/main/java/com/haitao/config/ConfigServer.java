package com.haitao.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 
 */

/**
 * 配置中心， 当有应用需要从配置中心读取配置信息时应首先启动此程序
 * 
 * @author huoht
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
	}
	
}
