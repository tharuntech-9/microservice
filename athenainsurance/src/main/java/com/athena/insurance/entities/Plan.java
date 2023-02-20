package com.athena.insurance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "plan")
@Data
public class Plan implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plan_no")
	private int planNo;
	@Column(name = "plan_nm")
	private String planName;
	@Column(name = "plane_type")
	private String planType;
	@Column(name = "min_tenure")
	private int minTenure;
	@Column(name = "max_tenure")
	private int maxTenure;
	@Column(name = "min_insurred_amount")
	private double minInsurredAmount;
	@Column(name = "max_insurred_amount")
	private double maxInsurredAmount;
	@Column(name = "min_age")
	private int minage;
	@Column(name = "max_age")
	private int maxage;
}
