package com.athena.membermgmt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyMemberDto {
	private int memberNo;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
	private String mobileNo;
	private String emailAddress;
}
