package com.athena.pharamcy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AthenaPharmacyApplication {
	public static void main(String[] args) {
		SpringApplication.run(AthenaPharmacyApplication.class, args);
	}
}
