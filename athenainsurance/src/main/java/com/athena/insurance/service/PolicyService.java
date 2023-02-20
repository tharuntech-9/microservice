package com.athena.insurance.service;

import org.springframework.stereotype.Service;

import com.athena.insurance.dto.PolicyDetailsDto;

@Service
public interface PolicyService {
	public PolicyDetailsDto getPolicyDetails(int policyNo);
}
