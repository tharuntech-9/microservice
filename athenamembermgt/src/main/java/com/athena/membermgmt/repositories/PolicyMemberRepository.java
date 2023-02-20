package com.athena.membermgmt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athena.membermgmt.entities.PolicyMember;

public interface PolicyMemberRepository extends JpaRepository<PolicyMember, Integer> {

}
