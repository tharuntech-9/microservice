package com.athena.membermgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.athena.membermgmt.dto.PolicyMemberDto;
import com.athena.membermgmt.entities.PolicyMember;

@Service
public interface MemberService {
	public PolicyMemberDto getMember(int memberNo);

	public List<PolicyMember> getAllMembers();

	public PolicyMember newMember(PolicyMember policyMember);

	public PolicyMember updateMember(PolicyMember policyMember);

}
