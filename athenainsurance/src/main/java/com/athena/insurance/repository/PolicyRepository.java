package com.athena.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athena.insurance.entities.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}
