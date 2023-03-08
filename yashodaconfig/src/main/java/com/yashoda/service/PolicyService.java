package com.yashoda.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder.Resilience4JCircuitBreakerConfiguration;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ConfigBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.yashoda.dto.PolicyInfo;

@Component
public class PolicyService {
	private final String INSURANCE_SERVICE_NAME = "INSURANCE-SERVICE";
	private final String GET_POLICY_DETAILS = "http://" + INSURANCE_SERVICE_NAME + "/policy/{policyNo}/details";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public PolicyInfo getPolicy(int policyNo) {
		PolicyInfo policyInfo = null;
		CircuitBreaker circuitBreaker = null;

		circuitBreaker = circuitBreakerFactory.create("slow");
		circuitBreaker = circuitBreakerFactory.create("fast");

		policyInfo = circuitBreaker.run(() -> {
			Map<String, String> pathVariables = null;

			pathVariables = new HashMap<>();
			pathVariables.put("policyNo", String.valueOf(policyNo));

			URI resourceURI = UriComponentsBuilder.fromUriString(GET_POLICY_DETAILS).build(pathVariables);
			return restTemplate.getForObject(resourceURI, PolicyInfo.class);
		});

		return policyInfo;
	}
}
