package com.athena.membermgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.athena.membermgmt.dto.PolicyMemberDto;
import com.athena.membermgmt.entities.PolicyMember;
import com.athena.membermgmt.exception.PolicyMemberNotFoundException;
import com.athena.membermgmt.repositories.PolicyMemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final PolicyMemberRepository policyMemberRepository;

	@Transactional(readOnly = true)
	@Override
	public PolicyMemberDto getMember(int memberNo) {
		PolicyMemberDto dto = null;

		PolicyMember policyMember = policyMemberRepository.findById(memberNo)
				.orElseThrow(() -> new PolicyMemberNotFoundException("member not found"));
		dto = new PolicyMemberDto();
		BeanUtils.copyProperties(policyMember, dto);
		return dto;
	}

	@Transactional(readOnly = true)
	@Override
	public List<PolicyMember> getAllMembers() {

		return policyMemberRepository.findAll();

	}

	@Override
	public PolicyMember newMember(PolicyMember policyMember) {

		return policyMemberRepository.save(policyMember);
	}

	@Override
	public PolicyMember updateMember(PolicyMember policyMember) {
		return policyMemberRepository.save(policyMember);
	}

}
