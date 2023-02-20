package com.athena.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AthenaconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenaconfigserverApplication.class, args);
	}
}
