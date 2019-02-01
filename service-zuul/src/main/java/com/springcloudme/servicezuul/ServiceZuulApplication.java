package com.springcloudme.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulServer
@EnableZuulProxy
public class ServiceZuulApplication {

	private static final String SPRING_BOOT_HELLO = "eureka.client.service-url.default-zone";

	@Resource
	private Environment environment;

	/**
	 * 2. 通过注入Environment获取值
	 */
	public void getAttrByEnvironment() {
		String property = environment.getProperty(SPRING_BOOT_HELLO);
		System.out.println("通过注入Environment获取值: " + property);
	}


	public static void main(String[] args) {
		ConfigurableApplicationContext atx = SpringApplication.run(ServiceZuulApplication.class, args);
		ServiceZuulApplication bean = atx.getBean(ServiceZuulApplication.class);
		bean.getAttrByEnvironment();
	}
}

