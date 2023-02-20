package com.athena.membermgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication	
public class AthenamembermgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenamembermgtApplication.class, args);
	}

}
