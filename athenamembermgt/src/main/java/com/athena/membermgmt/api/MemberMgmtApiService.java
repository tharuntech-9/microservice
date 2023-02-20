package com.athena.membermgmt.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.athena.membermgmt.dto.PolicyMemberDto;
import com.athena.membermgmt.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberMgmtApiService {
	private final MemberService memberService;

	@GetMapping(value = "/{memberNo}/details", produces = { MediaType.APPLICATION_JSON_VALUE })
	public PolicyMemberDto getPolicyMember(@PathVariable("memberNo") int memberNo) {
		return memberService.getMember(memberNo);
	}

}
