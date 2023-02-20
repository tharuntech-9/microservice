package com.athena.pharamcy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.athena.pharamcy.entity.Drug;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
	List<Drug> findByDrugNameLike(String drugName);
}
