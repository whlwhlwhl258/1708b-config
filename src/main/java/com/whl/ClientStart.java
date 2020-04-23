package com.whl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.whl.mapper")
@EnableCircuitBreaker
public class ClientStart {

	public static void main(String[] args) {
		SpringApplication.run(ClientStart.class, args);

	}

}
