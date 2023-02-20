package com.athenaeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AthenaeurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenaeurekaserverApplication.class, args);
	}

}
