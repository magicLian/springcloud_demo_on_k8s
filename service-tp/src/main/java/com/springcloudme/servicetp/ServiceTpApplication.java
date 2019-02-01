package com.springcloudme.servicetp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceTpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTpApplication.class, args);
	}

}

