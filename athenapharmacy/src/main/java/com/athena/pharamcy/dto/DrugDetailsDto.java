package com.athena.pharamcy.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DrugDetailsDto implements Serializable {
	private static final long serialVersionUID = 3603588331712854276L;
	private int drugNo;
	private String drugName;
	private String genericName;
	private String manufacturer;
	private int expiryMonth;
	private int expiryYear;
	private int quantity;
	private double price;
}
