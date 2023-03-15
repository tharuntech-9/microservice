package com.athena;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
public class AthenagatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthenagatewayApplication.class, args);
	}

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> circcuitBreakerFactoryCustomizer() {
		return (factory) -> {
			factory.configure((builder) -> {
				builder.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
						.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(20)).build())
						.build();
			}, "slow");
		};
	}
	
//	@Bean
//	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("membermgmt_route",
//						r -> r.path("/membermgmtservice/**")
//								.filters(f -> f.rewritePath("/membermgmtservice(?<segment>/?.*)", "$\\{segment}")
//										.circuitBreaker(c -> c.setName("slow")))
//								.uri("lb:http://MEMBER-MGMT-SERVICE"))
//				.build();
//	}
}
