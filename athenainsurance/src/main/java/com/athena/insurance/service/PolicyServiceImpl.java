package com.athena.insurance.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.athena.insurance.dto.MemberDto;
import com.athena.insurance.dto.PolicyDetailsDto;
import com.athena.insurance.entities.Policy;
import com.athena.insurance.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {
	private final String MEMBER_MGMT_SERVICE_NM = "MEMBER-MGMT-SERVICE";
	private final String MEMBER_MGMT_BASE_URL = "http://" + MEMBER_MGMT_SERVICE_NM + "/";

	private final String MEMBER_DETAILS_URL = MEMBER_MGMT_BASE_URL + "/member/{memberNo}/details";
	@Autowired
	private PolicyRepository policyRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public PolicyDetailsDto getPolicyDetails(int policyNo) {
		PolicyDetailsDto policyDetailsDto = null;
		Map<String, String> pathvariables = null;
		MemberDto memberDto = null;
		URI resourceURI = null;
		Policy policy = null;

		policy = policyRepository.findById(policyNo).orElseThrow();
		policyDetailsDto = new PolicyDetailsDto();
		policyDetailsDto.setPolicyNo(policy.getPolicyNo());
		policyDetailsDto.setPolicyStartDate(policy.getPolicyStartDate());
		policyDetailsDto.setPolicyEndDate(policy.getPolicyEndDate());
		policyDetailsDto.setPremiumAmount(policy.getPremiumAmount());
		policyDetailsDto.setInsurredAmount(policy.getInsurredAmount());
		policyDetailsDto.setStatus(policy.getStatus());
		policyDetailsDto.setPlanNo(policy.getPlan().getPlanNo());
		policyDetailsDto.setPlanName(policy.getPlan().getPlanName());
		policyDetailsDto.setMemberNo(policy.getMemberNo());

		pathvariables = new HashMap<>();
		pathvariables.put("memberNo", String.valueOf(policy.getMemberNo()));
		resourceURI = UriComponentsBuilder.fromUriString(MEMBER_DETAILS_URL).build(pathvariables);

		memberDto = restTemplate.getForObject(resourceURI, MemberDto.class);
		policyDetailsDto.setPolicyHolderName(memberDto.getFirstName() + " " + memberDto.getLastName());
		policyDetailsDto.setGender(memberDto.getGender());
		policyDetailsDto.setDob(memberDto.getDob());

		return policyDetailsDto;
	}
}
