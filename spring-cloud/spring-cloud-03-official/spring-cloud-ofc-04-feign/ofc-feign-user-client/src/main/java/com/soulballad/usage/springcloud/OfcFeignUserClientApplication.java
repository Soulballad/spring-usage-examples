package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = UserService.class)
public class OfcFeignUserClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfcFeignUserClientApplication.class, args);
	}
}
