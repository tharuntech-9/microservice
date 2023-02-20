package com.athena.membermgmt.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "policy_members")
@Data
public class PolicyMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_no")
	private int memberNo;
	@Column(name = "first_nm")
	private String firstName;
	@Column(name = "last_nm")
	private String lastName;
	private LocalDate dob;
	private String gender;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "email_address")
	private String emailAddress;

}
