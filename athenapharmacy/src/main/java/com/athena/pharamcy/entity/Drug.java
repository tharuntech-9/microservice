package com.athena.pharamcy.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "drug")
@Data
@Getter
public class Drug {
	public int getDrugNo() {
		return drugNo;
	}
	public void setDrugNo(int drugNo) {
		this.drugNo = drugNo;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public LocalDate getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(LocalDate manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drug_no")
	protected int drugNo;
	@Column(name = "drug_nm")
	protected String drugName;
	@Column(name = "generic_name")
	protected String genericName;
	protected String manufacturer;
	protected String category;
	@Column(name = "batch_no")
	protected String batchNo;
	@Column(name = "manufactured_dt")
	protected LocalDate manufacturedDate;
	@Column(name = "expiry_month")
	protected int expiryMonth;
	@Column(name = "expiry_year")
	protected int expiryYear;
	protected int quantity;
	protected double price;

}
