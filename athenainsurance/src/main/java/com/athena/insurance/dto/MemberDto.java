package com.athena.insurance.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MemberDto {
	private int memberNo;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String gender;
}
