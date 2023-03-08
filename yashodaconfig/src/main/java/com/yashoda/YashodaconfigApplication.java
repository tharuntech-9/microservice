package com.yashoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.yashoda.dto.PolicyInfo;
import com.yashoda.service.PolicyService;

@SpringBootApplication
@EnableDiscoveryClient
public class YashodaconfigApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(YashodaconfigApplication.class, args);
		PolicyService policyService = applicationContext.getBean(PolicyService.class);
		for(int i=0; i < 10; i++) {
			try {
			PolicyInfo policy = policyService.getPolicy(1);
			System.out.println(policy);
			}catch (Throwable e) {
				e.getStackTrace();
			}
		}
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
