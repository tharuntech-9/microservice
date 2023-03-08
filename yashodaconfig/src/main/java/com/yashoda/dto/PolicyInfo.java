package com.yashoda.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PolicyInfo {
	private int policyNo;
	private int planNo;
	private String planName;
	private int memberNo;
	private String policyHolderName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date policyStartDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date policyEndDate;
	private double premiumAmount;
	private double insurredAmount;
	private String status;
}
