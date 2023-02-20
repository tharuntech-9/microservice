package com.athena.insurance.dto;

import java.time.LocalDate;

import com.athena.insurance.entities.Plan;

import lombok.Data;
@Data
public class PolicyDetailsDto {

	private int policyNo;
	private int planNo;
	private String planName;
	private int memberNo;
	private String policyHolderName;
	private int tenure;
	private LocalDate dob;
	private String gender;
	private double premiumAmount;
	private double insurredAmount;
	private LocalDate policyStartDate;
	private LocalDate policyEndDate;
	private String registeredMobileNo;
	private String status;
}
