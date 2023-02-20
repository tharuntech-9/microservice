package com.athena.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athena.insurance.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
