package com.athena.insurance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.insurance.dto.PolicyDetailsDto;
import com.athena.insurance.service.PolicyService;

@RestController
@RequestMapping("/policy")
public class PolicyApiController {
	@Autowired
	private PolicyService policyService;
	
	@GetMapping(value = "/{policyNo}/details", produces = {MediaType.APPLICATION_JSON_VALUE} )
	public PolicyDetailsDto getPolicyDetails(@PathVariable("policyNo")  int policyNo) {
		return policyService.getPolicyDetails(policyNo);
	}
}
