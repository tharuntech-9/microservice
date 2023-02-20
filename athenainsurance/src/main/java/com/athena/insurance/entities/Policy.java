package com.athena.insurance.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "policy")
@Data
public class Policy implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_no")
	private int policyNo;
	@Column(name = "member_no")
	private int memberNo;
	private int tenure;
	@Column(name = "premium_amount")
	private double premiumAmount;
	@Column(name = "insurred_amount")
	private double insurredAmount;
	@Column(name = "policy_start_dt")
	private LocalDate policyStartDate;
	@Column(name = "policy_end_dt")
	private LocalDate policyEndDate;
	@Column(name = "registered_mobile_no")
	private String registeredMobileNo;
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "plan_no")
	private Plan plan;
}
